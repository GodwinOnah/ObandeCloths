import axios from 'axios';
import React,{useCallback} from 'react';
import {useDropzone} from 'react-dropzone';
import '../../Contents/CSSFiles/Admin.css'; 
import {useState, useEffect} from 'react';

export const Admin=()=>{

//   const [clothName,setClothName] = useState("");
// const [clothPrice,setClothPrice] = useState("");
// const [clothPictureId,setClothPictureId] = useState("");
const [userX,setUserX] = useState([]);
const [user,setUser] = useState({});
const [data,setData] = useState({clothName:"",clothPrice:"",clothPictureId:""});

useEffect(()=>{
  axios.get("http://localhost:8080/api/signup",
  {
   
  headers:{
      "Content-Type": "application/json"
   }
  }).then(res =>{
 
    setUserX(res.data);
  })
},[]);

const userY = () =>{
  return (
    <table class="table table-hover">
    <thead>
         <tr>
         <th>USER</th>
         <th>FIRST NAME</th>
         <th>LAST NAME</th>
         <th>EMAIL</th>
         <th>ADDRESS</th>
         <th>PHONE NUMBER</th>
         </tr>
       </thead>
       <tbody> 
             {
             userX.map((user,index)=>(
               <tr key = {index}>              
               <th >{index+1}</th>
               <td>{user.firstName}</td>
               <td>{user.lastName}</td>
               <td>{user.email}</td>
               <td>{user.address}</td>
               <td>{user.phone}</td>             
               </tr>  
            ))
            }           
            </tbody>
           </table>  
  )}
	return(
			<div>
        <h1 style={{color:'Blue', margin:'100px'}}>Welcome Admin</h1>
        <div>
        <h3>Registered Customers</h3>
        <hr/>
        <div class="listOfCustomers" >
         {userY()}
        </div>
        </div>

				<h3>Add New Product</h3>
        <hr/>
        <div class="container">
          <form  post ="" onSubmit={formSubmit}>
          <div class="row addPro ">
            <div  class="col-12 addPro2">
                <input type='text' name="clothName" onChange={handleChange} value={data.clothName} placeholder="Cloth Name" />
            </div>
            <div class="col-12 addPro2">
                <input type='text' name="clothPrice" onChange={handleChange} value={data.clothPrice} placeholder="Price" />
             </div>
             <div class="col-12 addPro2">
                <div class="drop">
                <Dropzone />
                <input type='file' name="clothPictureId" onChange={handleChange} value={data.clothPictureId}  placeholder="Upload Picture" />
                </div> 
              </div>
              <div class="col-12 addPro2">
                <button type='submit'>Upload</button>
              </div>
                </div>
                </form>
          </div>
          
			</div>


		)
  
    function handleChange(e){
        const name = e.target.name;
        const value = e.target.value;
        setData({...data, [name]:value})
    }

   function formSubmit(){

    console.log(55);
    console.log(data);
    
    // axios.post('http://localhost:8080/api/addClothings',data
    // //   {
    // //     headers:{
    // //     "Content-Type": "Json"
    // //   }
    // // }
    // ).then(()=>{
    //     console.log("File Data sent");
    // }).catch(error=>{
    //     console.log(error);
    // })

    // let data ={
    //   clothName:clothName,
    //   clothPrice:clothPrice,
    //   clothPictureId:clothPictureId
    // }
    //  console.log(data);

    // setFormData(data);

    //   if(e.target.files.length>0){      
    //      const file = e.target.files[0];
    //      var thisFormData = new FormData();
    //      thisFormData.append('myFiles',file);
    //     formData = thisFormData;
        
    // }
    // axios.post('http://localhost:8080/api/addClothings',formData
  //   {
  //     headers:{
  //     "Content-Type": "Json"
  //   }
  // }
  // ).then(()=>{
  //     console.log("File Data sent");
  // }).catch(error=>{
  //     console.log(error);
  // })
  // }, [])
  // }

  }

        function Dropzone({clothPictureId}) {
            const onDrop = useCallback(acceptedFiles => {
              const file = acceptedFiles[0];
    
              const formDataDropZone = new FormData();
              formDataDropZone.append("file",file);
    
              axios.post(`http://localhost:8080/api/clothings/${clothPictureId}/images/Uploads`,formDataDropZone,
              {
                headers:{
                "Content-Type": "multipart/form-data"
              }
            }
            ).then(()=>{
                console.log("File uploaded");
            }).catch(error=>{
                console.log(error);
            })
            }, [clothPictureId]
            )
    
            const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})
          
            return (
            
              <div {...getRootProps()}>
                <input {...getInputProps()} />
                {
                  isDragActive ?
                    <p>Drop the files here ...</p> :
                    <p>Drag 'n' drop some files here, or click to select files</p>
                }
              </div>
            )
          };
}