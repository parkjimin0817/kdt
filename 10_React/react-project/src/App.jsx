import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import LifecycleTest from './components/LifecycleTest'
import Comment from './components/Comment'
import CommentList from './components/CommentList'

function App() {
  // const [isButton, setIsButton] = useState(true);
  // const toggleButton = () => {
  //   setIsButton(!isButton);
  // }

  return (
    <>
      {/* {isButton && <LifecycleTest/>}
      <button onClick={toggleButton}>count 없애기</button> */}
      {/* <Comment message={"안녕하세요"}/> */}
      <CommentList />
    </>
  )
}

export default App
