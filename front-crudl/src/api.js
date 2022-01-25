import axios from 'axios'

const url="http://localhost:8081/DLitheBootcampBasicPOC/rest"


//axios.mthod(url,object)

const traverse=async()=>{
   const tmp= await axios.get(`${url}/`)
    return tmp 
}

const append=async(obj)=>{
   const ack =await axios.post(`${url}/new`, obj) 
   return ack
}

export {append, traverse}