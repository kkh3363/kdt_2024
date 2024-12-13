### Student.js
```
import React from "react";
import {ACTION_TYPES} from './App';

const Student =( {name, email,dispatch,id, isHere}) =>{
    return (
        <div>
            <span
                style={{
                    textDecoration: isHere ? 'line-through' : 'none',
                    color : isHere ? "gray": "black",
                }}
                onClick={()=>{
                    dispatch( {type:ACTION_TYPES.markStudent, payload:{id}});
                }}
            >{name} {email}</span>
            <button
                onClick={()=>{
                    dispatch({type:ACTION_TYPES.delStudent, payload:{id} });
                }}
            >삭제</button>
        </div>
    )
}

export default Student;
```
### App.js
```
import React,{useReducer, useState} from "react";
import Student from "./Student";

export const ACTION_TYPES = {
    addStudent: 'add-student',
    delStudent: 'delete-student',
    markStudent: 'mark-student',
}
const reducer= (state, action) =>{
    
    switch(action.type){
        case ACTION_TYPES.addStudent:
            const name=action.payload.name;
            const newStudent ={
                id:Date.now(),
                name: action.payload.name,
                email: action.payload.email,
                isHere: true,
            };
            return {
                count: state.count+1,
                students: [...state.students, newStudent],
            }
        case ACTION_TYPES.delStudent:
            return {
                count: state.count -1,
                students: state.students.filter(
                    (student) => student.id !== action.payload.id
                ),
            };
        case ACTION_TYPES.markStudent:
            return {
                count: state.count,
                students: state.students.map( (student) =>{
                    if ( student.id === action.payload.id){
                        return {...student, isHere: !student.isHere}
                    }
                    return student;
                }),
            };
        default :
            return state;

    }
}
const initalState ={
    count: 0,
    students:[]
        //{id: Date.now(), name:'홍길동', isHere: false}
    
}
function App(){
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [studentInfo, dispatch] = useReducer(reducer, initalState);
    return (
        <div>
            <h1>출석부</h1>
            <p>총학생수 : {studentInfo.count} 명</p>
            이름 :<input 
                type='text'
                placeholder="이름을 입력하시오" 
                value={name}
                onChange={(e)=>setName(e.target.value)}
            /><br />
            이메일 : <input 
                type='text'
                placeholder="이메일을 입력하시오" 
                value={email}
                onChange={(e)=>setEmail(e.target.value)}
            />
            <button
                onClick={()=>{
                    dispatch({ type: ACTION_TYPES.addStudent, 
                        payload:{ 
                            name:name,
                            email:email,
                        } 
                    })
                }}
            >추가</button>
            { studentInfo.students.map ( (student)=>{
                return (
                    <Student 
                        key={student.id}
                        name={student.name}
                        email={student.email}
                        dispatch={dispatch}
                        id ={student.id}
                        isHere={student.isHere}
                    />
                );
            })}
        </div>
    )
}

export default App;
```
