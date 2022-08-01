import axios from "axios";
import React, { useState } from "react";
import "../ImageModal/style.css";

function ImageModal({ closImageModalFunc }) {
    const [image, setImage] = useState(null);
    const [uploadFile, setuploadFile] = useState();
    const cancelClicked = () => {
        closImageModalFunc();
    };
    const changeImage = (e) => {
        setImage(URL.createObjectURL(e.target.files[0]));

        setuploadFile(e.target.files[0]);
    };
    return (
        <div className="image-modal">
            <div className="header">
                <div className="title">사진을 등록하세요!</div>
            </div>
            <div className="body">
                <div className="input-container">
                    <label className="input-button" for="input-file">
                        찾아보기
                    </label>
                    <input type="file" accept="image/*" id="input-file" style={{ display: "none" }}></input>
                </div>

                <div className="img-container">
                    <img className="img" src={image ? image : "./img/logo.png"} />
                </div>
            </div>

            <div className="footer">
                <div className="cancel" onClick={cancelClicked}>
                    취소
                </div>
                <div className="register">등록</div>
            </div>
        </div>
    );
}

export default ImageModal;
