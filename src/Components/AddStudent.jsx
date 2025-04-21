import React,{useEffect, useState} from 'react';
import {Link, useNavigate,useParams} from 'react-router-dom';
import StudentService from '../Services/StudentService';

const AddStudent = () => {
const [name, setName] = useState('');
const [age, setAge] = useState('')
const [address, setAddress] = useState('')
const navigate=useNavigate();
const {id}=useParams();

const saveOrUpdateStudent=(e)=>{
e.preventDefault();

const student={name, age: age ? parseInt(age) : 0,address}

if(id){
    StudentService.updateStudent(id,student).then((response)=>{
        navigate('/students')
    }).catch(error=>{
        console.log(error)
    })
}else{
    StudentService.createStudent(student).then((response)=>{
        console.log(response.data);
        navigate('/students')

}).catch(error=>{
    console.log(error)
})
}
}
useEffect(() => {
    if(id){
 StudentService.getStudentById(id).then((response)=>{
    setName(response.data.name)
    setAge(response.data.age)
    setAddress(response.data.address)
 }).catch(error=>{
    console.log(error)
 })
}
}, [id])
const title=()=>{   
        if(id){
            return <h2 className='text-center'>Update Student</h2>
        }else{
            return <h2 className='text-center'>Add Student</h2>
        }
    }
  return (
    <div>
        <br/> <br/>
    <div className='container'>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                {
                    title()
                }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                        <label className='form-label'>Student Name :</label>
                        <input
                        type='text'
                        placeholder='Enter Student Name'
                        name='name'
                        className='form-control'
                        value={name}
                        onChange={(e)=>setName(e.target.value)}
                        >                        
                        </input>
                        </div>

                        <div className='form-group mb-2'>
                        <label className='form-label'>Student Age :</label>
                        <input
                        type='number'
                        placeholder='Enter Student Age'
                        name='age'
                        className='form-control'
                        value={age}
                        onChange={(e)=>setAge(e.target.value)}
                        >                        
                        </input>
                        </div>

                        <div className='form-group mb-2'>
                        <label className='form-label'>Student Address :</label>
                        <input
                        type='text'
                        placeholder='Enter Student Address'
                        name='address'
                        className='form-control'
                        value={address}
                        onChange={(e)=>setAddress(e.target.value)}
                        >                        
                        </input>
                        </div>
                        <button className='btn btn-success' onClick={(e)=>saveOrUpdateStudent(e)}>Submit</button>
                        <Link to="/students" className='btn btn-danger'style={{marginLeft:"10px"}}>Cancel</Link>
                    </form>
                </div>
        </div>
        </div>
    </div>
    </div>
  )
}

export default AddStudent