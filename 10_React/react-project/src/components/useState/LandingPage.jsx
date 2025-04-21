import React, {useState} from 'react'
import Toolbar from './Toolbar'
import Grade from './Grade'

const LandingPage = () => {
    const [isLogin, setIsLogin] = useState(false);

    const onClickLogin = () => {
        setIsLogin(true);
    }

    const onClickLogout = () => {
        setIsLogin(false);
    }

  return (
    <div>
        <Toolbar isLogin={isLogin}
                onClickLogin={onClickLogin}
                onClickLogout={onClickLogout}/>
        <Grade isLogin={isLogin}/>
    </div>
  )
}

export default LandingPage