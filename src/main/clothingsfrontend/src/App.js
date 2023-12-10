import './App.css';
import {Routes,Route}from 'react-router-dom';
import {Nav} from './Contents/JSFiles/Nav.js';
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

      </Routes> 
    </div>
  );
}

export default App;
