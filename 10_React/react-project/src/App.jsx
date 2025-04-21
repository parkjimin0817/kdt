import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import LifecycleTest from './components/LifecycleTest'
import Comment from './components/Comment'

function App() {
  // const [isButton, setIsButton] = useState(true);
  // const toggleButton = () => {
  //   setIsButton(!isButton);
  // }

  return (
    <>
      {/* {isButton && <LifecycleTest/>}
      <button onClick={toggleButton}>count 없애기</button> */}
      <Comment message={"안녕하십니까마귀"}/>
    </>
  )
}

export default App
