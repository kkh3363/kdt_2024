import React, { useState } from 'react';
import './App.css';


function Left2(props){
    return (
        <div>
            <h3>Left 2 :  {props.number}</h3>
            <Left3 number={props.number}></Left3>
        </div>
    )
}
function Left3(props){
    return (
        <div>
            <h3>Left 3 :  {props.number}</h3>
        </div>
    )
}
function Left1(props){
    return (
        <div>
            <h3>Left 1 : {props.number}</h3>
            <Left2 number={props.number}></Left2>
        </div>
    )
}
function Right1(props){
    return (
        <div>
            <h3>Right 1: {props.number} </h3>
            <Right2 onIncrease={()=>{
                props.onIncrease();
            }}></Right2>
        </div>
    )
}
function Right2(props){
    return (
        <div>
            <h3>Right 2: {props.number} </h3>
            <Right3 onIncrease={()=>{
                props.onIncrease();
            }}></Right3>
        </div>
    )
}
function Right3(props){
    return (
        <div>
            <h3>Right 3 : {props.number} </h3>
            <input type="button" value="+"
                onClick={()=>{
                    props.onIncrease();
                }}></input>
        </div>
    )
}
function App(){
    const [number, setNumber]=useState(1);
    return (
        <div id="container">
            <h1>Root :{number}</h1>
            <div id="grid">
                <Left1 number={number}></Left1>
                <Right1 onIncrease={()=>{
                    setNumber(number+1);
            }}></Right1>
            </div>
        </div>
    )
}

export default App;
