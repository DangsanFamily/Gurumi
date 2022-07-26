import React from "react";
import MainPage from "./Page/MainPage";
import CreateMessagePage from "./Page/CreateMessagePage";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./App.css";

function App() {
    return (
        <div className="App" style={{ background: "url(./img/main.jpg)" }}>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<MainPage />} />
                    <Route path="/create-message" element={<CreateMessagePage />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
