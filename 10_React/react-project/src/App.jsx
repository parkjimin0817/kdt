import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import Profile from './pages/Profile'
import About from './pages/About'
import NotFound from './pages/NotFound'
import { Link } from 'react-router-dom'

function App() {


  return (
    <BrowserRouter>
      <nav style={{marginBottom: 12}}>
        {/* Link : a 태그와 동일한 역할을 하지만 react-router-dom을 활용해 spa방식으로 자연스럽게 화면 전환 */}
        <Link to="/" style={{marginRight: 12}}>홈</Link>
        <Link to="/about" style={{marginRight: 12}}>소개</Link>
        <Link to="/profile/최지원">프로필</Link>
      </nav>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/about' element={<About/>}/>
        <Route path='/profile/:username' element={<Profile/>}/>
        <Route path='*' element={<NotFound/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
