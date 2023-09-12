import '../../Contents/CSSFiles/Login.css';
import {Link } from "react-router-dom";

export const Login=()=>{
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