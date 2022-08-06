import React,{useState} from "react";
import "./style.css";
import { useNavigate,useLocation } from "react-router-dom";
import { CgLogOut } from "react-icons/cg";


const PreViewPage = (props) => {
    const [previewModal, setPreviewModal] = useState(false);
    const [clickedBlockId, setClickedBlockId] = useState(0);

    const navigate = useNavigate();
    const location = useLocation();
    console.log('state', location.state);

    const blockIdList = location.state.blockIdList;
    const back = () => {
        navigate("/create-message",{
            state: {
                blockIdList: blockIdList,
            }
        });
    };

    const showPreviewModal = (id) => {
        setClickedBlockId(id);
        setPreviewModal(true);
    }

    const closePreviewModal = () => {
        setPreviewModal(false);
    }

    return (
        <div className="preview-message-container">
            <div className="header-container">
            <div className="back">
                <CgLogOut onClick={back} size="30"></CgLogOut>
            </div>
            <div className="header">미리 보기</div>
            </div>
            <div className="body">
                {blockIdList && blockIdList.map((block, index) => {
                    let side = index % 2 == 0 ? "left" : "right";
                    const className = `block-container ${side}`;
                    return (
                        <div
                            className={className}
                            key={index}
                            onClick={() => {
                                showPreviewModal(block);
                            }}
                        >
                            {" "}
                            <img className="block" src="./img/logo.png"></img>
                        </div>
                    );
                })}
            </div>
        </div>
    )
}

export default PreViewPage;