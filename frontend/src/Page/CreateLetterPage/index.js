import React, { useState, useEffect } from "react";
import { CgAdd } from "react-icons/cg";
import "./style.css";
import MainModal from "../../Components/MainModal/MainModal";
import TextRevisedModal from "../../Components/TextReviseModal/BlockReviseModal";
import ImageRevisedModal from "../../Components/ImageReviseModal/ImageRevisedModal";
import LinkRevisedModal from "../../Components/LinkReviseModal/LinkReviseModal";
import { useNavigate, useLocation } from "react-router-dom";
import axios from "axios";

function CreateLetterPage() {
    const [modal, setModal] = useState(false);

    const [blockIdList, setBlockIdList] = useState([]);
    const [textRevisedModal, setTextRevisedModal] = useState(false);
    const [imageRevisedModal, setImageRevisedModal] = useState(false);
    const [linkRevisedModal, setLinkRevisedModal] = useState(false);
    const [clickedBlockId, setClickedBlockId] = useState(0);

    const navigate = useNavigate();
    const location = useLocation();
    const preview = () => {
        navigate("/preview", {
            state: {
                blockIdList: blockIdList,
            },
        });
    };
    // const getBlockList = location.state.blockIdList;
    // const getBlock = () => {
    //     setBlockIdList([...getBlockList])
    // }
    useEffect(() => {
        if (location.state) {
            setBlockIdList(location.state.blockIdList);
        }

        // console.log(location.state.blockIdList)
    }, []);

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
        axios
            .get(`/blocks/${id}`)
            .then((res) => {
                if (res.data.type === "text") {
                    setTextRevisedModal(true);
                } else if (res.data.type === "image") {
                    setImageRevisedModal(true);
                } else if (res.data.type === "link") {
                    setLinkRevisedModal(true);
                }
            })
            .catch((err) => {
                console.log(err);
            });
    };
    const closeRevisedBlockModal = (type) => {
        if (type === "text") {
            setTextRevisedModal(false);
        } else if (type === "image") {
            setImageRevisedModal(false);
        } else if (type === "link") {
            setLinkRevisedModal(false);
        }
    };

    const removeBlock = (id) => {
        setBlockIdList(blockIdList.filter((blockId) => blockId !== id));
    };

    return (
        <div className="create-message-container">
            {modal === true ? <MainModal closeModalFunc={closeModal} addBlockFunc={addBlock} /> : null}
            {textRevisedModal === true ? (
                <TextRevisedModal
                    block={clickedBlockId}
                    closeModalFunc={closeRevisedBlockModal}
                    removeBlockFunc={removeBlock}
                />
            ) : null}
            {imageRevisedModal === true ? (
                <ImageRevisedModal
                    block={clickedBlockId}
                    closeModalFunc={closeRevisedBlockModal}
                    removeBlockFunc={removeBlock}
                />
            ) : null}
            {linkRevisedModal === true ? (
                <LinkRevisedModal
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
                    <button className="button" onClick={preview}>
                        미리 보기
                    </button>
                </div>
                <div className="right">
                    <button className="button">전송하기</button>
                </div>
            </div>
        </div>
    );
}
export default CreateLetterPage;
