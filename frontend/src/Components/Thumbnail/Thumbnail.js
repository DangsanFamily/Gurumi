import React from "react";

function Thumbnail({title,description,image,url }) {
    
    return (
        <>
        <img src={image} style={{maxHeight:"60%"}}></img>
        <div style={{maxHeight:"10%" ,textOverflow:"ellipsis"}}>{title}</div>
        <div style={{maxHeight:"20%",textOverflow:"ellipsis",overflow:"hidden"}}>{description}</div>
        <div style={{maxHeight:"10%"}}>{url}</div>

        </>
    );
}

export default Thumbnail;
