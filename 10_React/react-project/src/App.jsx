import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UseStateTest from './components/useState/UseStateTest'
import SignUp from './components/useState/SignUp'
import LandingPage from './components/useState/LandingPage'
import UseRefTest from './components/useRef/UseRefTest'
import UserRefScroll from './components/useRef/UserRefScroll'
import UseMemoTest from './components/useMemo/UseMemoTest'
import UsecallbackTest from './components/useCallback/UsecallbackTest'
import UseEffectTest from './components/useEffect/UseEffectTest'
import EffectView from './components/useEffect/EffectView'

function App() {

  return (
    <>
      {/* <UseStateTest/> */}
      {/* <SignUp/> */}
      {/* <LandingPage/> */}
      {/* <UseRefTest/> */}
      {/* <UserRefScroll/> */}
      {/* <UseMemoTest/> */}
      {/* <UsecallbackTest/> */}
      <EffectView/>
    </>
  )
}

export default App
