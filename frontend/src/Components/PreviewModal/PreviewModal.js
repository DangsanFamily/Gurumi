import axios from "axios";
import React,{useState,useEffect} from "react";
import "../PreviewModal/style.css";


const PreviewModal=({block, closePrevModalFunc})=> {
    const [prevModal, setPrevModal] = useState(false);
    const [content, setContent] = useState("");
    const [type, setType] = useState("");

    useEffect(() => {
        axios
            .get(`/blocks/${block}`)
            .then((res) => {
                setContent(res.data.content);
                setType(res.data.type);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);

    console.log(block.data)
    return (
        <>
        <div className="block-image">
            <img className="block" src="./img/logo.png"></img>
        </div>
        </>
    );
};

export default PreviewModal;