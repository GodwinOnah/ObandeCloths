import axios from 'axios';
import react, {useState, useEffect} from 'react';

export const Clothings = () => {

    const [clothings,SetClothings] = useState([]);

     const fetchClothings = () =>{
       axios.get("http://localhost:8080/api/clothings").then(res =>{
         console.log(res.data)
         SetClothings(res.data);
       })
     };
     
       useEffect(()=>{
         fetchClothings();
       },[]);

       return clothings.map((clothing,index)=>{
         return (
         <div class="container" key={index}>
            <div class="d-flex containerL">
           <div class="card cardL" >
           <img class="card-img-top" src={clothing.clothPicture}  alt="..."/>
         <div class="card-body">
         <h3>{clothing.clothName}</h3>
           <h3><strong >Price:</strong><strong class="pricing">{clothing.clothPrice}</strong></h3>
         </div>
       </div> 
       <div class="test"> Hello</div>

           </div>
         </div>
         )
       })
};