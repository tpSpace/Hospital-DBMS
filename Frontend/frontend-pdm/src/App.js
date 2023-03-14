import './App.css';
import { Route, Routes, Link} from 'react-router-dom';
import Home from './pages/home/Home';
import Register from './pages/register/Register';
import Login from './pages/login/Login';
import styled from 'styled-components';
function App() {
  return (
    <>
      <Nav>
        <Logo>HPDM</Logo>
        <Ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/login">Login</Link></li>
          <li><Link to="/register">Register</Link></li>
        </Ul>
      </Nav>

      <Routes>
        <Route  path="/" element={<Home />} />
        <Route  path="/login" element={<Login />} />
        <Route  path="/register" element={<Register />} />
      </Routes>
    </>
  );
}
const Nav = styled.nav`
  width: 100%;
  height: 70px;
  background-color: #2E3440;
  position: fixed;

  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const Ul = styled.ul`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 50;
  margin-right: 1rem;
  height: 100%;
  list-style: none;
  font-size: 1.2rem;
  li {
    margin: 0 1rem;
    padding: 5px;

    a {
      text-decoration: none;
      color: #fff;
    }
  }
  li:hover {
    background-color: #3B4252;
    padding: 5px;
    border-radius: 5px;
    shadow: 1 1 5px #000;
    a {
      color: #fff;
    }
  }

`;

const Logo = styled.h1`
  color: #fff;
  font-size: 2rem;
  font-weight: 700;
  margin-left: 1rem;
`;

export default App;
