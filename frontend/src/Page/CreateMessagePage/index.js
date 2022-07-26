import React, { useState } from "react";
import { CgAdd } from "react-icons/cg";
import { BsTrash } from "react-icons/bs";
import { AiFillHome, AiOutlineClose, AiOutlineMessage, AiOutlineLink, AiOutlinePicture } from "react-icons/ai";
import "../style.css";

function MessageModal({ closeMessageModalFunc, registerMessageFunc, closeModalFunc }) {
    const [message, setMessage] = useState("");
    const cancelClicked = () => {
        closeMessageModalFunc();
    };
    const textareaHandler = (e) => {
        setMessage(e.target.value);
    };
    const registerMessage = () => {
        registerMessageFunc(message);
        closeMessageModalFunc();
        closeModalFunc();
    };

    return (
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
    );
}
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
function CreateMessagePage() {
    const [modal, setModal] = useState(false);

    const [cloud, setCloud] = useState([]);
    const [cloudID, setCloudID] = useState(0);
    const [messageRevisedModal, setMessageRevisedModal] = useState(false);
    const [clickedCloud, setClickedCloud] = useState({});
    const addCloud = (message) => {
        const newCloud = {
            message: message,

            id: cloudID,
        };

        setCloud([...cloud, newCloud]);

        setCloudID(cloudID + 1);
    };
    const showModal = () => {
        setModal(true);
    };
    const closeModal = () => {
        setModal(false);
    };

    const showMessageRevisedModal = (id) => {
        let target = cloud.find((c) => c.id === id);

        setClickedCloud(target);
        setMessageRevisedModal(true);
    };
    const closeRevisedMessageModal = () => {
        setMessageRevisedModal(false);
    };

    const reviseCloud = (exCloud, message) => {
        const reviseCloud = {
            id: exCloud.id,

            message: message,
        };
        setCloud(cloud.map((c) => (exCloud.id === c.id ? { ...c, ...reviseCloud } : c)));
    };

    const removeCloud = (id) => {
        setCloud(cloud.filter((c) => c.id !== id));
    };

    return (
        <div className="create-message-container">
            {modal === true ? <MainModal closeModalFunc={closeModal} addCloudFunc={addCloud} /> : null}
            {messageRevisedModal === true ? (
                <MessageRevisedModal
                    cloud={clickedCloud}
                    reviseCloudFunc={reviseCloud}
                    closeModalFunc={closeRevisedMessageModal}
                    removeCloudFunc={removeCloud}
                />
            ) : null}
            <div className="header">마음을 전해보세요!</div>
            <div className="body-layer">
                {cloud.map((c, index) => {
                    let side = index % 2 == 0 ? "left" : "right";
                    const className = `cloud-container ${side}`;
                    return (
                        <div
                            className={className}
                            key={index}
                            onClick={() => {
                                showMessageRevisedModal(c.id);
                            }}
                        >
                            {" "}
                            <img className="cloud" src="./img/logo.png"></img>
                        </div>
                    );
                })}
                <div className="cloud-add">
                    {" "}
                    <CgAdd onClick={showModal} size="50"></CgAdd>
                </div>
            </div>

            <div className="button-layer">
                <div className="left">
                    <button className="button">미리 보기</button>
                </div>
                <div className="right">
                    <button className="button">전송하기</button>
                </div>
            </div>
        </div>
    );
}
export default CreateMessagePage;
