import '../../Contents/CSSFiles/Login.css';
import {useState} from 'react';
import { toast,ToastContainer } from "react-toastify";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

export const Signup = () =>{
    const [firstName,SetFirstName] = useState('');
    const [lastName,SetLastName] = useState('');
    const [email,SetEmail] = useState('');
    const [address,SetAddress] = useState('');
    const [phone,SetPhone] = useState('');
    const [password,SetPassword] = useState('');
    const [confirmPassword,SetConfirmPassword] = useState('');
    const [isSigningIn,SetIsSigningIn] = useState(false)
    const [data,SetData] = useState({});
    const [show, setShow] = useState(false); 
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

      

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
            toast.success(res);
            SetIsSigningIn(false); 
            handleClose();    
               })
          };
      }

  const SignupModal = ()=>{
    
      return(
          <div class="modal1">
            <ToastContainer
                  position='top-right'
                  autoClose={2000}
                  hideProgressBar={false}
                  newestOnTop={false}
                  closeOnClick
                  rtl={false}
                  pauseOnFocusLoss
                  draggable
                  pauseOnHover
                  theme='light'
                  />
          
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
                    {isSigningIn && <strong>Signing you up...</strong>}
                  </div>
                    </div>
              </div>
              </div>
             
              </div>
              );
            };
    
      return (
        <div style={{cursor:"pointer"}}>
          <p onClick={handleShow}>
           Signup
          </p>
    
          <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
              <Modal.Title>Signup</Modal.Title>
            </Modal.Header>
            <form onSubmit={handleSubmit}>
            <Modal.Body><SignupModal/></Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={handleClose}>
                Cancel
              </Button>
              <Button type="submit" variant="primary">
                Submit
              </Button>
            </Modal.Footer>
            </form>
          </Modal>
        </div>
      );
    }
    
   



