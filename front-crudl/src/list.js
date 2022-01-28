import React, { useEffect, useState } from "react";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Create from "./create";
import info, { getting } from './DataAccess'
import Read from "./read";
import RemoveCircleIcon from '@mui/icons-material/RemoveCircle';
import EditIcon from '@mui/icons-material/Edit';
import Edit from "./edit";
import Button from '@mui/material/Button';
import { oneAtTime, terminate, traverse } from "./api";



const List=()=>{
    const [cview,setCview]=useState(false)
    const [rview,setRview]=useState(false)
    const [eview,setEview]=useState(false)
    const [company,setCompany]=useState("")
    // const [pos,setPos]=useState(0)

    const[all, setAll]= useState([])

    useEffect(()=>{
        iterate()
    },[])

    const iterate=async()=>{
        const t= await traverse()
        setAll(t.data) 
    }

    const [obj,setObj]=useState(
        {
            "org":"",
            "locations":"",
            "employees":0,
            "basic":0.0,
            "services":"",
            "benchmarks":""
        }
    )

    const callCreate=()=>{
        setCview(true)
    }

    const reading=async(one)=>{
        const hey=await oneAtTime(one)
        setObj(hey.data) 
    }

    const abort=async(par)=>{
        const yet=await terminate(par)
        alert(yet.data)
        window.location.assign("http://localhost:3000")
    }
    return(
        <>
            {(cview)?
            <>
                <Create/>
                <button className="btn btn-outline-dark" 
                onClick={()=>setCview(false)}>
                    Back
                </button>
            </>
            :
            (rview)?
            <>
                <Read corp={obj}/>
                <button className="btn btn-outline-dark" 
                onClick={()=>setRview(false)}>
                    Back
                </button>
            </>
            :
            (eview)?
            <>
                {/* <Edit corp={obj} order={pos}/> */}
                <Edit id={company}/>
                <button className="btn btn-outline-dark" 
                onClick={()=>setEview(false)}>
                    Back
                </button>
            </>
            :
            <>
            <button className="btn btn-outline-success" onClick={callCreate}>
                Create
            </button>
            <div className="row justify-content-center">
                <div className="col-lg-8 col-md-10 col-sm-12 table-responsive">
                    <table className="table table-stripped table-hover shodow text-light bg-info">
                        <thead>
                            <tr>
                                <th>Name of the Corporate</th>
                                <th>Locations</th>
                                <th>Number of employees</th>
                                <th>Basic salary</th>
                                <th>Services</th>
                                <th>Benchmark's</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {all.map((data,index)=>(
                                <tr>
                                    <td onClick={
                                        ()=>{
                                            setRview(true)
                                            // const tmp=getting(data.org)
                                            // setObj(tmp)
                                            //setObj(data)
                                            reading(data.org)
                                        }}>
                                        {data.org}
                                    </td>
                                    {/* <td>{data.locations}</td> */}
                                    { <td>
                                        {data.locations.map((ele)=>(
                                            <p>{ele}</p>
                                        ))}
                                    </td> }
                                    <td>{data.employees}</td>
                                    <td>{data.basic}</td>
                                    {/* <td>{data.services}</td> */}
                                    { <td>
                                        {data.services.map((ele)=>(
                                            <p>{ele}</p>
                                        ))}
                                    </td> }
                                    {/* <td>{data.benchmarks}</td> */}
                                    { <td>
                                        {data.benchmarks.map((ele)=>(
                                            <p>{ele}</p>
                                        ))}
                                    </td> }
                                    <td>
                                        <Button color="error" className="btn btn-outline-danger"onClick={
                                            ()=>{
                                                abort(data.org)
                                            }
                                        }>
                                            <RemoveCircleIcon/>
                                        </Button>
                                    </td>
                                    <td>
                                        <button className="btn btn-outline-warning"onClick={
                                            ()=>{
                                                setEview(true)
                                                // const tmp=getting(data.org)
                                                // setPos(index)
                                                // setObj(tmp)
                                                setCompany(data.org)
                                            }
                                        }>
                                            <EditIcon/>
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
            </>
            }
        </>
    );
}

export default List;