import { ThemeProvider } from 'styled-components';
import './App.css';
import theme from './styles/theme';
import GlobalStyle from './styles/GlobalStyle';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Layout from './components/Layout';
import { ToastContainer } from 'react-toastify';
import SignUp from './pages/SignUp';
import LogIn from './pages/LogIn';
import Profile from './pages/Profile';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Router>
        <Layout>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signup" element={<SignUp />} />
            <Route path="/login" element={<LogIn />} />
            <Route path="/profile" element={<Profile />} />
          </Routes>
        </Layout>
      </Router>
      <ToastContainer
        position="top-right"
        autoCloase={3000}
        closeOnClick
        draggable
        hideProgressBar={false}
        newestOnTop
      />
    </ThemeProvider>
  );
}

export default App;
