import axios from "axios";
import React, { useState, useEffect } from "react";
import Thumbnail from "../Thumbnail/Thumbnail";
import { BsTrash } from "react-icons/bs";
import "../LinkModal/style.css";

function LinkRevisedModal({ block, closeModalFunc, removeBlockFunc }) {
    const [link, setLink] = useState(null);
    const [title, setTitle] = useState(null);
    const [description, setDescription] = useState(null);
    const [image, setImage] = useState(null);
    const [url, setUrl] = useState(null);
    const [content, setContent] = useState(null);
    const [id, setId] = useState(block);
    const [type, setType] = useState("");

    useEffect(() => {
        axios
            .get(`/blocks/${block}`)
            .then((res) => {
                setContent(res.data.content);
                setLink(res.data.content);
                setType(res.data.type);
                axios
                    .get(`/link?url=${res.data.content}`)
                    .then((res2) => {
                        setTitle(res2.data.title);
                        setDescription(res2.data.description);
                        setImage(res2.data.imgUrl);
                        setUrl(res2.data.domainName);
                    })
                    .catch((err) => {
                        alert("url을 다시 확인해주세요");
                    });
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);

    const textHandler = (e) => {
        setLink(e.target.value);
    };
    const closeModal = () => {
        closeModalFunc(type);
    };
    const registerThumbnail = () => {
        axios
            .get(`/link?url=${link}`)
            .then((res) => {
                setTitle(res.data.title);
                setDescription(res.data.description);
                setImage(res.data.imgUrl);
                setUrl(res.data.domainName);
                setContent(link);
            })
            .catch((err) => {
                alert("url을 다시 확인해주세요");
            });
    };

    const reviseContent = () => {
        if (!content) {
            alert("전송하고 싶은 링크를 확인해주세요!");
            return;
        }
        if (!content.replace(/\s/g, "").length) {
            alert("전송하는 링크가 공백입니다!");
            return;
        }
        const body = {
            type: type,
            content: content,
        };
        axios
            .patch(`/blocks/${id}`, body)
            .then((res) => {
                closeModalFunc(type);
            })
            .catch((err) => {});
    };
    const removeContent = () => {
        axios
            .delete(`/blocks/${id}`)
            .then((res) => {
                removeBlockFunc(id);
                closeModalFunc(type);
            })
            .catch((err) => {});
    };
    return (
        <div className="modal-background">
            <div className="link-modal">
                <div className="header">
                    <BsTrash color="black" size="32" onClick={removeContent}></BsTrash>
                </div>
                <div className="body">
                    <div className="input-container">
                        <input type="text" onChange={textHandler} className="input-text"></input>
                        <button onClick={registerThumbnail} className="button">
                            생성
                        </button>
                    </div>

                    <div className="preview-container">
                        <Thumbnail title={title} description={description} image={image} url={url}></Thumbnail>
                    </div>
                </div>

                <div className="footer">
                    <div className="cancel" onClick={closeModal}>
                        취소
                    </div>
                    <div className="register" onClick={reviseContent}>
                        수정
                    </div>
                </div>
            </div>
        </div>
    );
}

export default LinkRevisedModal;
