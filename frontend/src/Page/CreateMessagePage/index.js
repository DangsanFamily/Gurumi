import React, { useState } from "react";
import { CgAdd } from "react-icons/cg";
import "../CreateMessagePage/style.css";
import MainModal from "../../Components/MainModal/MainModal";
import MessageRevisedModal from "../../Components/MessageReviseModal/MessageReviseModal";

function CreateMessagePage() {
    const [modal, setModal] = useState(false);

    const [blockIdList, setBloudIdList] = useState([]);
    const [messageRevisedModal, setMessageRevisedModal] = useState(false);
    const [clickedBlockId, setClickedBlockId] = useState(0);
    const addBlock = (id) => {
        setBloudIdList([...blockIdList, id]);
    };
    const showModal = () => {
        setModal(true);
    };
    const closeModal = () => {
        setModal(false);
    };

    const showMessageRevisedModal = (id) => {
        setClickedBlockId(id);
        setMessageRevisedModal(true);
    };
    const closeRevisedMessageModal = () => {
        setMessageRevisedModal(false);
    };

    const removeBlock = (id) => {
        setBloudIdList(blockIdList.filter((blockId) => blockId !== id));
    };

    return (
        <div className="create-message-container">
            {modal === true ? <MainModal closeModalFunc={closeModal} addBlockFunc={addBlock} /> : null}
            {messageRevisedModal === true ? (
                <MessageRevisedModal
                    block={clickedBlockId}
                    closeModalFunc={closeRevisedMessageModal}
                    removeBlockFunc={removeBlock}
                />
            ) : null}
            <div className="header">마음을 전해보세요!</div>
            <div className="body-layer">
                {blockIdList.map((block, index) => {
                    let side = index % 2 == 0 ? "left" : "right";
                    const className = `block-container ${side}`;
                    return (
                        <div
                            className={className}
                            key={index}
                            onClick={() => {
                                showMessageRevisedModal(block);
                            }}
                        >
                            {" "}
                            <img className="block" src="./img/logo.png"></img>
                        </div>
                    );
                })}
                <div className="block-add">
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
