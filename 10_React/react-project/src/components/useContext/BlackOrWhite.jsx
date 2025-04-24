import React, {useState} from 'react'
import MainContent from './MainContent';
import ThemeContext from './ThemeContext';

const BlackOrWhite = () => {
    const [theme, setTheme] = useState("white");

    const toggleTheme = () => {
        setTheme(theme === "white" ? "black" : "white")
    }


  return (
    <div>
        <ThemeContext.Provider value={{theme, toggleTheme}}>
            <MainContent/>
        </ThemeContext.Provider>
    </div>
  )
}

export default BlackOrWhite