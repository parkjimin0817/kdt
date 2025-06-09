import { ThemeProvider } from 'styled-components';
import './App.css';
import theme from './styles/theme';
import GlobalStyle from './styles/GlobalStyle';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Layout from './components/Layout';
import { ToastContainer } from 'react-toastify';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Router>
        <Layout>
          <Routes>
            <Route path="/" element={<Home />} />
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
