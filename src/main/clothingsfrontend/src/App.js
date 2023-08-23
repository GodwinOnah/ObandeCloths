import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import react, {useState, useEffect} from 'react'

const Clothings = () => {
  const fetchClothings = () =>{
    axios.get("http://localhost:8080/api/clothings").then(res =>{
      console.log(res)
    })
  }

    useEffect(()=>{
      fetchClothings();
    },[]);

    return <h1>Godwin</h1>
};

function App() {
  
  return (
    <div className="App">
      <Clothings />
    </div>
  );
}

export default App;
