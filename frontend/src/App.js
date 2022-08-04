import React from "react";
import MainPage from "./Page/MainPage";
import CreateLetterPage from "./Page/CreateLetterPage";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./App.css";

function App() {
    return (
        <div className="App" style={{ background: "url(./img/main.jpg)" }}>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<MainPage />} />
                    <Route path="/create-message" element={<CreateLetterPage />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
