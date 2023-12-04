import './App.css';
import {Routes,Route}from 'react-router-dom';
import {Nav} from './Contents/JSFiles/Nav.js';
import {Login} from './Contents/JSFiles/Login.js';
import {Signup} from './Contents/JSFiles/Signup.js';
import {Admin}from './Contents/JSFiles/Admin.js';
import {Clothings}from './Contents/JSFiles/Clothings.js';
import "react-toastify/dist/ReactToastify.css";


function App() {
  
  return (
    <div className="App">
      <Nav />
    <Routes>
        <Route path='/' exact element={<Clothings/>}/>
        <Route path='Admin' element={<Admin />} />
        <Route path='Login' element={<Login />} />  
        <Route path='Signup' element={<Signup />} />   
      </Routes> 
    </div>
  );
}

export default App;
