import './App.css';
import { Route, Routes} from 'react-router-dom';
import Home from './pages/home/Home';
import Register from './pages/register/Register';
import Login from './pages/login/Login';
import ViewInfo from './pages/dashboard/ViewInfo';
import Logic from './components/Logic.jsx';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

function App() {
  
  return (
    <>
      <Logic/>
      <Routes>
        <Route  path="/" element={<Home />} />
        <Route  path="/login" element={<Login />} />
        <Route  path="/register" element={<Register />} />
        <Route  path="/viewinfo" element={<ViewInfo/>}/>
        <Route  path="*" element={<h1>404 Not Found</h1>} />
     
      </Routes>
    </>
  );
}

export default App;
