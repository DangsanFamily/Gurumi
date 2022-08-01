import React, { useState } from "react";
import { BsTrash } from "react-icons/bs";
import "./style.css";

function MessageRevisedModal({ cloud, reviseCloudFunc, closeModalFunc, removeCloudFunc }) {
    const [message, setMessage] = useState(cloud.message);
    const textareaHandler = (e) => {
        setMessage(e.target.value);
    };
    const reviseCloud = () => {
        reviseCloudFunc(cloud, message);
        closeModalFunc();
    };
    const closeModal = () => {
        closeModalFunc();
    };
    const removeCloud = () => {
        removeCloudFunc(cloud.id);
        closeModalFunc();
    };

    return (
        <div className="message-modal">
            <div className="header" style={{ backgroundColor: "red", borderColor: "red", opacity: "0.8" }}>
                <BsTrash color="black" size="32" onClick={removeCloud}></BsTrash>
            </div>
            <div className="body">
                <div className="color-container"></div>
                <div className="message-container">
                    <textarea className="message" defaultValue={message} onChange={textareaHandler}></textarea>
                </div>
            </div>
            <div className="footer">
                <div className="cancel" onClick={closeModal}>
                    취소
                </div>

                <div className="register" onClick={reviseCloud}>
                    수정
                </div>
            </div>
        </div>
    );
}

export default MessageRevisedModal;