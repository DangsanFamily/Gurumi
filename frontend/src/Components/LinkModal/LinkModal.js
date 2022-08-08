import axios from "axios";
import React, { useState, useEffect } from "react";
import Thumbnail from "../Thumbnail/Thumbnail";
import "../LinkModal/style.css";

function LinkModal({ closeLinkModalFunc, closeModalFunc }) {
    const [link, setLink] = useState(null);
    const [title, setTitle] = useState(null);
    const [description, setDescription] = useState(null);
    const [image, setImage] = useState(null);
    const [url, setUrl] = useState(null);

    const cancelClicked = () => {
        closeLinkModalFunc();
    };
    const textHandler=(e)=>{
        setLink(e.target.value)
    }
    const registerThumbnail=()=>{
        axios.get(`/link?url=${link}`).then((res)=>{
            setTitle(res.data.title)
            setDescription(res.data.description)
            setImage(res.data.imgUrl)
            setUrl(res.data.domainName)

        }).catch((err)=>{
            alert("url을 다시 확인해주세요")
        })
    }

    return (
        <div className="link-modal">
            <div className="header">
                <div className="title">링크를 등록하세요!</div>
            </div>
            <div className="body">
                
                <div className="input-container">
                <input type="text" onChange={textHandler}></input>
                <button onClick={registerThumbnail}>등록</button>
                </div>
                
                <div className="preview-container">
                    <Thumbnail title={title} description={description} image={image} url={url}></Thumbnail>
                </div>
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
