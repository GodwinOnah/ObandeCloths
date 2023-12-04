import '../../Contents/CSSFiles/Login.css';
import {Form, Link } from "react-router-dom";
import {useState} from 'react';


export const Login = () =>{

const [email,SetEmail] = useState('');
const [password,SetPassword] = useState('');
const [data,SetData] = useState({});
const [isLoggingIn,SetIsLoggingIn] = useState(false)

const handleSubmit = (e) =>{
  e.preventDefault();
  SetIsLoggingIn(true);
  const datax = {email, password};
  SetData(datax);
  
  fetch(
  "http://localhost:8080/api/login",
    {
      method: 'POST',
      headers:{
          "Content-Type": "Json"
       },
      body: JSON.stringify(data)
      }
  ).then(res =>{
          SetIsLoggingIn(false);
          console.log(res)
          return res;
          
       })
      };
   
	return(
			<div>
				<h1>Login</h1>
        <hr/>
        <form onSubmit={handleSubmit}>
        <div class="container">
          <div class="row  ">
            <div  class="col-12 login">
                <input 
                value={email}
                onChange = {(e)=>SetEmail(e.target.value)}
                type='email' 
                placeholder="Email" />
            </div>
             <div class="col-12 login">
                <input 
                value={password}
                onChange = {(e)=>SetPassword(e.target.value)}
                type='password' 
                placeholder="Choose Password" />
             </div>
              <div class="col-12 login">
                {!isLoggingIn && <button type='submit'>Login</button>}
                {isLoggingIn && <button disabled>Logging you in...</button>}
              </div>
              <div>New User? <Link to="/Signup">Register</Link></div>
                </div>
          </div>
          </form>
          </div>
          );
        }
     