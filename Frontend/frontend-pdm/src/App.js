import './App.css';
import { Route, Routes} from 'react-router-dom';
import Home from './pages/home/Home';
import Register from './pages/register/Register';
import Login from './pages/login/Login';
import ViewInfo from './pages/viewinfo/ViewInfo';
import Logic from './navbar/Logic.jsx';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Appointment from './pages/appointment/Appointment';
import EditInfo from './pages/editUser/EditInfo';
import Shift from './pages/shift/Shift';
import Operation from './pages/operation/Operation';

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
        <Route  path='/appointment' element={<Appointment/>}/>
        <Route  path='/edituser/:id' element={<EditInfo/>}/>
        <Route  path='/operation/edituser/:id' element={<EditInfo/>}/>
        <Route  path='/shift' element={<Shift/>}/>
        <Route path='/operation' element={<Operation/>}/>
     
      </Routes>
    </>
  );
}

export default App;
