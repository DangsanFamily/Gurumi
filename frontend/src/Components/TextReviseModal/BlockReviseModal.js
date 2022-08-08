import React, { useState, useEffect } from "react";
import axios from "axios";
import { BsTrash } from "react-icons/bs";
import "./style.css";

function TextRevisedModal({ block, closeModalFunc, removeBlockFunc }) {
    const [content, setContent] = useState("");
    const [type, setType] = useState("");
    const [id, setId] = useState(block);
    const textareaHandler = (e) => {
        setContent(e.target.value);
    };
    useEffect(() => {
        axios
            .get(`/blocks/${block}`)
            .then((res) => {
                setContent(res.data.content);
                setType(res.data.type);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);

    const reviseBlock = () => {
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
    const closeModal = () => {
        closeModalFunc(type);
    };
    const removeBlock = () => {
        axios
            .delete(`/blocks/${id}`)
            .then((res) => {
                removeBlockFunc(id);
                closeModalFunc(type);
            })
            .catch((err) => {});
    };

    return (
        <div className="message-modal">
            <div className="header" style={{ backgroundColor: "red", borderColor: "red", opacity: "0.8" }}>
                <BsTrash color="black" size="32" onClick={removeBlock}></BsTrash>
            </div>
            <div className="body">
                <div className="color-container"></div>
                <div className="message-container">
                    <textarea className="message" defaultValue={content} onChange={textareaHandler}></textarea>
                </div>
            </div>
            <div className="footer">
                <div className="cancel" onClick={closeModal}>
                    취소
                </div>

                <div className="register" onClick={reviseBlock}>
                    수정
                </div>
            </div>
        </div>
    );
}

export default TextRevisedModal;
