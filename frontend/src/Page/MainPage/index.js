import React from "react";
import "./style.css";
import { useNavigate } from "react-router-dom";
function MainPage() {
    const next = () => {
        navigate("/create-message");
    };
    const navigate = useNavigate();
    return (
        <div className="main-page">
            <div className="title">
                {" "}
                <img className="logo" src="./img/logo.png" alt=""></img>구르미
            </div>
            <div className="body-container">
                <button className="start-button hover" onClick={next}>
                    시작하기
                </button>
            </div>
        </div>
    );
}
export default MainPage;
