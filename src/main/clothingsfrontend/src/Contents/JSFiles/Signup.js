import '../../Contents/CSSFiles/Login.css';
import axios from 'axios';
import {useState, useEffect} from 'react';

export const Signup=()=>{

const [upload,SetUpload] = useState([]);

 const fetchUser = () =>{
       axios.post("http://localhost:8080/api/signup").then(res =>{
         if(res){
         return "Saved Successfully"}
         return "Data not saved"
       })
     };

      useEffect(()=>{
             fetchUser();
            },[]);

	return(
			<div>
				<h1>Signup</h1>
        <hr/>
        <div class="container">
          <div class="row  ">
            <div  class="col-12 login">
                <input type='text' placeholder="First Name" />
            </div>
            <div  class="col-12 login">
                <input type='text' placeholder="Last Name" />
            </div>
            <div  class="col-12 login">
                <input type='email' placeholder="Email" />
            </div>
            <div  class="col-12 login">
                <textarea type='text' placeholder="Address" />
            </div>
            <div class="col-12 login">
                <input type='text' placeholder="Phone" />
             </div>
             <div class="col-12 login">
                <input type='password' placeholder="Choose Password" />
             </div>
             <div class="col-12 login">
                <input type='password' placeholder="Confirm Password" />
             </div>
              <div class="col-12 login">
                <button type='submit'>Signup</button>
              </div>
                </div>
          </div>
          </div>
          );}