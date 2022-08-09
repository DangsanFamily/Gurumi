import axios from "axios";
import React, { useState } from "react";
import "../ImageModal/style.css";

function ImageModal({ closeImageModalFunc, closeModalFunc, registerBlockFunc }) {
    const [image, setImage] = useState(null);
    const [uploadFile, setuploadFile] = useState(null);
    const cancelClicked = () => {
        closeImageModalFunc();
    };
    const changeImage = (e) => {
        var binaryData = [];
        binaryData.push(e.target.files[0]);

        setImage(URL.createObjectURL(new Blob(binaryData, { type: "application/zip" })));
        setuploadFile(e.target.files[0]);
    };
    const registerImage = () => {
        if (!uploadFile) {
            alert("파일을 선택해주세요!");
            return;
        }
        const formData = new FormData();
        formData.append("type", "image");
        formData.append("content", null);
        formData.append("image", uploadFile);

        axios
            .post("/blocks", formData)
            .then((res) => {
                closeImageModalFunc();
                closeModalFunc();
                registerBlockFunc(res.data.id);
            })
            .catch((err) => {});
    };
    return (
        <div className="modal-background">
            <div className="image-modal">
                <div className="header">
                    <div className="title">사진을 등록하세요!</div>
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
                        <img className="img" src={image ? image : "./img/logo.png"} />
                    </div>
                </div>

                <div className="footer">
                    <div className="cancel" onClick={cancelClicked}>
                        취소
                    </div>
                    <div className="register" onClick={registerImage}>
                        등록
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ImageModal;
