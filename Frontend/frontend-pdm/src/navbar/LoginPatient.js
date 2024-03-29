import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
const LoginPatient = () => {

  let navigate = useNavigate();

  function handleLogout() {
    localStorage.setItem('status', 'false');
    localStorage.removeItem('role');
    localStorage.removeItem('email');
    navigate('/');
    window.location.reload();
    console.log("Bye");
  }

    return (
      // eslint-disable-next-line
        <Nav>
            <Logo>HPDM</Logo>
            <Ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/appointment">Appointment</Link></li>
                <li><Link to="/viewinfo">Profile</Link></li>
                {/* eslint-disable-next-line */}
                <li><a onClick={handleLogout} href="">Logout</a></li>
            </Ul>
        </Nav>
    )
}
const Nav = styled.nav`
  width: 100%;
  height: 70px;

  background-color: #2E3440;

  position: sticky;
  top: 0;
  z-index: 100;
  
  display: flex;
  justify-content: space-between;
  align-items: center;
  align-content: center;
  border: 1px solid #2E3440;
  
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
export default LoginPatient;