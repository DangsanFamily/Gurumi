import MainPage from './Page/MainPage'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

import './App.css'

function App() {
  return (
    <div className="App" style={{ background: 'url(./img/main.jpg)' }}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MainPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
