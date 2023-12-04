import '../../Contents/CSSFiles/Login.css';
import {useState} from 'react';
import { toast,ToastContainer } from "react-toastify";


export const Signup=()=>{

const [firstName,SetFirstName] = useState('');
const [lastName,SetLastName] = useState('');
const [email,SetEmail] = useState('');
const [address,SetAddress] = useState('');
const [phone,SetPhone] = useState('');
const [password,SetPassword] = useState('');
const [confirmPassword,SetConfirmPassword] = useState('');
const [isSigningIn,SetIsSigningIn] = useState(false)
const [data,SetData] = useState({});



const handleSubmit = (e) =>{
  e.preventDefault();
  SetIsSigningIn(true);
  const datax = {firstName,lastName,email,address,phone, password};

  if(password !== confirmPassword){
    toast.warning("Password missmatch");
    SetIsSigningIn(false);
    return;
  }

  if(password === confirmPassword){
    SetData(datax);
  fetch("http://localhost:8080/api/signup",
 {
  method: 'POST',
  headers:{
      "Content-Type": "application/json"
   },
  body: JSON.stringify(data)
  }).then(res =>{
    return res.text();      
       }).then(res =>{ 
        toast.warning(res);
        SetIsSigningIn(false);     
           })
      };
  }


	return(
			<div>
        <ToastContainer
              position='top-right'
              autoClose={5000}
              hideProgressBar={false}
              newestOnTop={false}
              closeOnClick
              rtl={false}
              pauseOnFocusLoss
              draggable
              pauseOnHover
              theme='light'
              />
				<h1>Signup</h1>
        <hr/>
        <form onSubmit={handleSubmit}>
        <div class="container">
          <div class="row  ">
            <div  class="col-12 login">
                <input 
                value={firstName}
                onChange = {(e)=>SetFirstName(e.target.value)}
                type='text' placeholder="First Name" />
            </div>
            <div  class="col-12 login">
                <input 
                value={lastName}
                onChange = {(e)=>SetLastName(e.target.value)}
                type='text' placeholder="Last Name" />
            </div>
            <div  class="col-12 login">
                <input 
                value={email}
                onChange = {(e)=>SetEmail(e.target.value)}
                type='email' placeholder="Email" />
            </div>
            <div  class="col-12 login">
                <textarea 
                value={address}
                onChange = {(e)=>SetAddress(e.target.value)}
                type='text' placeholder="Address" />
            </div>
            <div class="col-12 login">
                <input 
                value={phone}
                onChange = {(e)=>SetPhone(e.target.value)}type='text' placeholder="Phone" />
             </div>
             <div class="col-12 login">
                <input 
                value={password}
                onChange = {(e)=>SetPassword(e.target.value)}type='password' placeholder="Choose Password" />
             </div>
             <div class="col-12 login">
                <input 
                value={confirmPassword}
                onChange = {(e)=>SetConfirmPassword(e.target.value)}
                type='password' placeholder="Confirm Password" />
             </div>
             <div >
              <div class="col-12 login">
              {!isSigningIn && <button  type='submit'>Signup</button>}
                {isSigningIn && <button disabled>Signing you up...</button>}
              </div>
                </div>
          </div>
          </div>
          </form>
          </div>
          );
        }