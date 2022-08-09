import React from "react";
import "./style.css";
function Thumbnail({ title, description, image, url }) {
    return (
        <div className="thumbnail-container">
            <img src={image} className="img-container"></img>
            <div className="title-container">{title}</div>
            <div className="description-container">{description}</div>
            <div className="url-container">{url}</div>
        </div>
    );
}

export default Thumbnail;
