import axios from "axios";
import React, { useState,useEffect } from "react";
import { BsTrash } from "react-icons/bs";
import "../ImageModal/style.css";

function ImageRevisedModal({ block, closeModalFunc, removeBlockFunc }) {
    const [image, setImage] = useState(null);
    const [type, setType] = useState("");
    const [uploadFile, setuploadFile] = useState("http://localhost:8080/image/d25a8cb0-6a83-4833-b71a-43b281f3fc1btest.jpg");
    const [id, setId] = useState(block);
    useEffect(() => {
        axios
            .get(`/blocks/${block}`)
            .then((res) => {
                console.log(res.data.content)
                setImage(res.data.content);
                setType(res.data.type);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);
    const changeImage = (e) => {
        var binaryData = [];
        binaryData.push(e.target.files[0]);
        setImage(URL.createObjectURL(new Blob(binaryData, {type: "application/zip"})));
        setuploadFile(e.target.files[0]);
    };
    const reviseImage = () => {
        if(uploadFile===null){
            alert("이미지를 수정하세요!")
            return
        }
        const formData = new FormData();
        formData.append("type", "image");
        formData.append("content",null);
        formData.append("image", uploadFile);
        axios
            .patch(`/blocks/${id}`, formData)
            .then((res) => {
                closeModalFunc(type)
            })
            .catch((err) => {});
 
    };
    const closeModal = () => {
        closeModalFunc(type);
    };
    const removeImage=()=>{
        axios
            .delete(`/blocks/${id}`)
            .then((res) => {
                removeBlockFunc(id);
                closeModalFunc(type);
            })
            .catch((err) => {});
    }
    return (
        <div className="image-modal">
            <div className="header" style={{ backgroundColor: "red", borderColor: "red", opacity: "0.8" }}>
            <BsTrash color="black" size="32" onClick={removeImage}></BsTrash>
            </div>
            <div className="body">
                <div className="input-container">
                    <label className="input-button" for="input-file">
                        찾아보기
                    </label>
                    <input
                        type="file"
                        accept="image/*"
                        id="input-file"
                        style={{ display: "none" }}
                        onChange={changeImage}
                    ></input>
                </div>

                <div className="img-container">
                    <img className="img" src={image} />
                </div>
            </div>

            <div className="footer">
                <div className="cancel" onClick={closeModal}>
                    취소
                </div>
                <div className="register" onClick={reviseImage}>
                    수정
                </div>
            </div>
        </div>
    );
}

export default ImageRevisedModal;
