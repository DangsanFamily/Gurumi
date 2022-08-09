import axios from "axios";
import React, { useState } from "react";
import "./style.css";

function TextModal({ closeTextModalFunc, registerBlockFunc, closeModalFunc }) {
    const [message, setMessage] = useState("");
    const cancelClicked = () => {
        closeTextModalFunc();
    };
    const textareaHandler = (e) => {
        setMessage(e.target.value);
    };
    const registerMessage = () => {
        const req = {
            type: "text",
            content: message,
        };
        axios
            .post("/blocks", req)
            .then((res) => {
                console.log(res.data);
                registerBlockFunc(res.data.id);
                closeTextModalFunc();
                closeModalFunc();
            })
            .catch((err) => {});
    };

    return (
        <div className="modal-background">
            <div className="message-modal">
                <div className="header">
                    <div className="title">하고 싶은 말을 적어보세요</div>
                </div>
                <div className="body">
                    <div className="color-container"></div>
                    <div className="message-container">
                        <textarea
                            className="message"
                            placeholder="내용을 입력하세요!"
                            onChange={textareaHandler}
                        ></textarea>
                    </div>
                </div>
                <div className="footer">
                    <div className="cancel" onClick={cancelClicked}>
                        취소
                    </div>
                    <div className="register" onClick={registerMessage}>
                        등록
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TextModal;
