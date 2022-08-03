import axios from "axios";
import React, { useState, useEffect } from "react";
import "../LinkModal/style.css";

function LinkModal({ closeLinkModalFunc, closeModalFunc }) {
    const [link, setLink] = useState(null);

    const cancelClicked = () => {
        closeLinkModalFunc();
    };

    return (
        <div className="link-modal">
            <div className="header">
                <div className="title">링크를 등록하세요!</div>
            </div>
            <div className="body">
                <div className="input-container"></div>

                <div className="preview-container"></div>
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

export default LinkModal;
