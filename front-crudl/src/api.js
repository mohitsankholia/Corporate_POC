import axios from 'axios'

const url="http://localhost:8081/DLitheBootcampBasicPOC/rest"


//axios.mthod(url,object)

const abc=async()=>{

    const rec =await axios.get(`${url}/`)
    return rec
}
const append=async(obj)=>{
   const ack =await axios.post(`${url}/new`, obj) 
   return ack
}

export {append, abc}