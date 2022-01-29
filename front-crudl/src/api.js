import axios from 'axios'

// const url="http://localhost:8081/DLitheBootcampBasicPOC/rest"
const url="http://localhost:8080/DLitheBootcampBasicPOC-0.0.1-SNAPSHOT/rest"


//axios.mthod(url,object)

const traverse=async()=>{
   const tmp= await axios.get(`${url}/`)
    return tmp 
}

const append=async(obj)=>{
   const ack =await axios.post(`${url}/new`, obj) 
   return ack
}

const oneAtTime=async(param)=>{
   const tmp= await axios.get(`${url}/${param}`)
   return tmp 
}

const terminate=async(param)=>{
   const t= await axios.delete(`${url}/remove/${param}`)
   return t
}

const change=async(object)=>{
   const t= await axios.put(`${url}/up`, object)
   return t
}
export {append, traverse, oneAtTime, terminate, change}