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

const fetchUsers = () =>{
  axios.get("http://localhost:8080/api/signup",
  {
   
  headers:{
      "Content-Type": "application/json"
   }
  }).then(res =>{
 
    setUserX(res.data);
  })
};

useEffect(()=>{
  fetchUsers();
},[]);

 
	return(
			<div>
        <div>
        <h1>Registered Customers</h1>
        <hr/>
        <div class="listOfCustomers" >
      {
          userX.map((user,index)=>(<li key = {index}>
          {user.firstName} {user.lastName}
        </li>))
    }
        </div>
        </div>

				<h1>Add New Product</h1>
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