import React from "react";
import MainPage from "./Page/MainPage";
import CreateLetterPage from "./Page/CreateLetterPage";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import PreViewPage from "./Page/PreiVewPage/PreViewPage";

import "./App.css";

function App() {
    return (
        <div className="App" style={{ background: "url(./img/main.jpg)" }}>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<MainPage />} />
                    <Route path="/create-message" element={<CreateLetterPage />} />
                    <Route path="/preview" element={<PreViewPage />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
