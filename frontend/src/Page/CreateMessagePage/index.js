import React, { useState } from "react";
import { CgAdd } from "react-icons/cg";
import "../CreateMessagePage/style.css";
import MainModal from "../../Components/MainModal/MainModal";
import MessageRevisedModal from "../../Components/MessageReviseModal/MessageReviseModal";

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
