import React, { useState } from "react";
import { AiOutlineClose, AiOutlineMessage, AiOutlineLink, AiOutlinePicture } from "react-icons/ai";
import MessageModal from "../MessageModal/MessageModal";
import "../MainModal/style.css";

function MainModal({ closeModalFunc, addCloudFunc }) {
    const [messageModal, setMessageModal] = useState(false);
    const [mainModal, setMainModal] = useState(true);
    const closeModal = () => {
        closeModalFunc();
    };
    const showMessageModal = () => {
        setMessageModal(true);
        setMainModal(false);
    };
    const registerMessage = (message) => {
        addCloudFunc(message);
    };
    const closeMessageModal = () => {
        setMessageModal(false);
        setMainModal(true);
    };

    return (
        <>
            {" "}
            {messageModal === true ? (
                <MessageModal
                    closeMessageModalFunc={closeMessageModal}
                    registerMessageFunc={registerMessage}
                    closeModalFunc={closeModalFunc}
                    isNew={true}
                />
            ) : null}
            {mainModal === true ? (
                <div className="modal">
                    <div className="header">
                        <div className="title">추가 하기</div>
                        <AiOutlineClose color="#ff97bf" onClick={closeModal}></AiOutlineClose>
                    </div>
                    <div className="body">
                        <AiOutlineMessage color="#ff97bf" onClick={showMessageModal} size="64"></AiOutlineMessage>
                        <AiOutlinePicture color="#ff97bf" size="64"></AiOutlinePicture>
                        <AiOutlineLink color="#ff97bf" size="64"></AiOutlineLink>
                    </div>
                </div>
            ) : null}
        </>
    );
}

export default MainModal;