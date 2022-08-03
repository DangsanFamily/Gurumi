import React, { useState,useEffect } from "react";
import axios from "axios";
import { BsTrash } from "react-icons/bs";
import "./style.css";

function MessageRevisedModal({ cloud,  closeModalFunc, removeCloudFunc }) {
    const [content, setContent] = useState("");
    const [type,setType]=useState("");
    const [id,setId]=useState(cloud);
    const textareaHandler = (e) => {
        setContent(e.target.value);
    };
    useEffect(() => {
 
      axios.get(`/blocks/${cloud}`).then((res)=>{
        setContent(res.data.content)
        setType(res.data.type)
       
      }).catch((err)=>{
        console.log(err)
      })
    }, [])
    
    const reviseCloud = () => {
        const body = {
            
            type: type,
            content: content,
        };
        axios
            .patch(`/blocks/${id}`, body)
            .then((res) => {
                console.log(res.data)
                
                closeModalFunc();
            })
            .catch((err) => {});

    };
    const closeModal = () => {
        closeModalFunc();
    };
    const removeCloud = () => {
        axios
            .delete(`/blocks/${id}`)
            .then((res) => {
 
                removeCloudFunc(id);
                closeModalFunc();
            })
            .catch((err) => {});
      
    };

    return (
        <div className="message-modal">
            <div className="header" style={{ backgroundColor: "red", borderColor: "red", opacity: "0.8" }}>
                <BsTrash color="black" size="32" onClick={removeCloud}></BsTrash>
            </div>
            <div className="body">
                <div className="color-container"></div>
                <div className="message-container">
                    <textarea className="message" defaultValue={content} onChange={textareaHandler}></textarea>
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

export default MessageRevisedModal;
