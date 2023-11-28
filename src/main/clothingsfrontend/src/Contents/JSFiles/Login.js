import '../../Contents/CSSFiles/Login.css';
import {Link } from "react-router-dom";
import axios from 'axios';
import {useState, useEffect} from 'react';


export const Login=()=>{

const [exist,SetExist] = useState([]);

 const fetchUser = () =>{
       axios.post("http://localhost:8080/api/login").then(res =>{
         if(res) return "Logged in successfully";
         return "Not Logged in";
       })
     };

      useEffect(()=>{
             fetchUser();
            },[]);

	return(
			<div>
				<h1>Login</h1>
        <hr/>
        <div class="container">
          <div class="row  ">
            <div  class="col-12 login">
                <input type='email' placeholder="Email" />
            </div>
             <div class="col-12 login">
                <input type='password' placeholder="Choose Password" />
             </div>
              <div class="col-12 login">
                <button type='submit'>Login</button>
              </div>
              <div>New User? <Link to="/Signup">Register</Link></div>
                </div>
          </div>
          </div>
          );}