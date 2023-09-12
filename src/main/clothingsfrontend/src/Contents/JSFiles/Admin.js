import axios from 'axios';
import React,{Component,useCallback, useState} from 'react';
import {useDropzone} from 'react-dropzone';
import '../../Contents/CSSFiles/Admin.css'; 

const [clothName,setClothName] = useState("");
const [clothPrice,setClothPrice] = useState("");
const [ClothPictureId,setClothPictureId] = useState("");
const [formData,setFormData] = useState(null);


export const Admin=()=>{
	return(
			<div>
				<h1>Add New Product</h1>
        <hr/>
        <div class="container">
          <form onSubmit={submitForm()}>
          <div class="row addPro ">
            <div  class="col-12 addPro2">
                <input type='text' placeholder="Cloth Name" />
            </div>
            <div class="col-12 addPro2">
                <input type='text' placeholder="Price" />
             </div>
             <div class="col-12 addPro2">
                <div class="drop">
                <Dropzone />
                <input type='file' onChange={addClothData(e)} placeholder="Upload Picture" />
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

   function onSubmit(e){
    e.preventDefault();

      if(e.target.files.length>0){      
         const file = e.target.files[0];
         var thisFormData = new FormData();
         thisFormData.append('myFiles',file);
        formData = thisFormData;
        
    }}

    function addClothData(e){
      let data ={
        clothName:clothName,
        clothPrice:clothPrice,
        ClothPictureId:ClothPictureId
      }

    }

        function Dropzone({clothPictureId}) {
            const onDrop = useCallback(acceptedFiles => {
              const file = acceptedFiles[0];
    
              const formData = new FormData();
              formData.append("file",file);
    
              axios.post(`http://localhost:8080/api/clothings/${clothPictureId}/images/Uploads`,formData,
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
            }, [])
    
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