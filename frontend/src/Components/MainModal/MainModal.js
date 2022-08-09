import React, { useState } from "react";
import { AiOutlineClose, AiOutlineMessage, AiOutlineLink, AiOutlinePicture } from "react-icons/ai";
import TextModal from "../TextModal/TextModal";
import ImageModal from "../ImageModal/ImageModal";
import LinkModal from "../LinkModal/LinkModal";
import "../MainModal/style.css";

function MainModal({ closeModalFunc, addBlockFunc }) {
    const [textModal, setTextModal] = useState(false);
    const [imageModal, setImageModal] = useState(false);
    const [linkModal, setLinkModal] = useState(false);
    const [mainModal, setMainModal] = useState(true);
    const closeModal = () => {
        closeModalFunc();
    };
    const showBlockModal = () => {
        setTextModal(true);
        setMainModal(false);
    };
    const registerBlock = (id) => {
        addBlockFunc(id);
    };
    const closeTextModal = () => {
        setTextModal(false);
        setMainModal(true);
    };

    const showImageModal = () => {
        setImageModal(true);
        setMainModal(false);
    };
    const closeImageModal = () => {
        setImageModal(false);
        setMainModal(true);
    };
    const showLinkModal = () => {
        setLinkModal(true);
        setMainModal(false);
    };
    const closeLinkModal = () => {
        setLinkModal(false);
        setMainModal(true);
    };

    return (
        <div className="modal-background">
            {" "}
            {textModal === true ? (
                <TextModal
                    closeTextModalFunc={closeTextModal}
                    registerBlockFunc={registerBlock}
                    closeModalFunc={closeModal}
                    isNew={true}
                />
            ) : null}
            {linkModal === true ? <LinkModal closeLinkModalFunc={closeLinkModal} /> : null}
            {imageModal === true ? (
                <ImageModal
                    closeImageModalFunc={closeImageModal}
                    closeModalFunc={closeModal}
                    registerBlockFunc={registerBlock}
                />
            ) : null}
            {mainModal === true ? (
                <div className="modal">
                    <div className="header">
                        <div className="title">추가 하기</div>
                        <AiOutlineClose color="#ff97bf" onClick={closeModal}></AiOutlineClose>
                    </div>
                    <div className="body">
                        <AiOutlineMessage color="#ff97bf" onClick={showBlockModal} size="64"></AiOutlineMessage>
                        <AiOutlinePicture color="#ff97bf" size="64" onClick={showImageModal}></AiOutlinePicture>
                        <AiOutlineLink color="#ff97bf" size="64" onClick={showLinkModal}></AiOutlineLink>
                    </div>
                </div>
            ) : null}
        </div>
    );
}

export default MainModal;
