import '../style.css'
import { Button } from 'react-bootstrap'
import axios from 'axios'

function MainPage() {

  const apiTest=()=>{
   axios.get('/api/test').then(res => {
    alert(res.data)
  })
  }

  return (
    <div className="main-page">
      <div className="title">구르미</div>
      <div className="body-container">
        <Button className="start-button" onClick={apiTest}>시작하기</Button>
      </div>
    </div>
  )
}
export default MainPage
