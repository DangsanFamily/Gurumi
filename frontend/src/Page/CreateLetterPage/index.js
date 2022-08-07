import React, { useState,useEffect } from "react";
import { CgAdd } from "react-icons/cg";
import "./style.css";
import MainModal from "../../Components/MainModal/MainModal";
import BlockRevisedModal from "../../Components/BlockReviseModal/BlockReviseModal";
import {useNavigate,useLocation} from "react-router-dom";

function CreateLetterPage() {
    const [modal, setModal] = useState(false);

    const [blockIdList, setBlockIdList] = useState([]);
    const [blockRevisedModal, setBlockRevisedModal] = useState(false);
    const [clickedBlockId, setClickedBlockId] = useState(0);

    const navigate = useNavigate();
    const location = useLocation();
    const preview = () => {
        navigate("/preview",{
            state: {
                blockIdList: blockIdList,
            }
        });
    };
    // const getBlockList = location.state.blockIdList;
    // const getBlock = () => {
    //     setBlockIdList([...getBlockList])
    // }
    useEffect(() => {
        if(location.state){
            setBlockIdList(location.state.blockIdList)
        }
        
        // console.log(location.state.blockIdList)
    }, [])
    
    const addBlock = (id) => {
        setBlockIdList([...blockIdList, id]);
    };
    const showModal = () => {
        setModal(true);
    };
    const closeModal = () => {
        setModal(false);
    };

    const showBlockRevisedModal = (id) => {
        setClickedBlockId(id);
        setBlockRevisedModal(true);
    };
    const closeRevisedBlockModal = () => {
        setBlockRevisedModal(false);
    };

    const removeBlock = (id) => {
        setBlockIdList(blockIdList.filter((blockId) => blockId !== id));
    };

    return (
        <div className="create-message-container">
            {modal === true ? <MainModal closeModalFunc={closeModal} addBlockFunc={addBlock} /> : null}
            {blockRevisedModal === true ? (
                <BlockRevisedModal
                    block={clickedBlockId}
                    closeModalFunc={closeRevisedBlockModal}
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
                                showBlockRevisedModal(block);
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
                    <button className="button" onClick={preview}>미리 보기</button>
                </div>
                <div className="right">
                    <button className="button">전송하기</button>
                </div>
            </div>
        </div>
    );
}
export default CreateLetterPage;
