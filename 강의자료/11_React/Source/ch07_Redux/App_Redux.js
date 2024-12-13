import React, { useState } from 'react';
import './App.css';
import {createStore} from 'redux';
import {Provider, useSelector, useDispatch, connect} from 'react-redux';

function reducer(curState, action){
    if (curState === undefined){
        return {
            number:1,
        }
    }
    const newState= {...curState};
    if ( action.type ==='PLUS'){
        newState.number++
    }
    console.log('number', newState.number);
    return newState;
}
const store = createStore(reducer);

function Left2(){
    return (
        <div>
            <h3>Left 2 :   </h3>
            <Left3  ></Left3>
        </div>
    )
}
function Left3(){
    function f(state){
        return state.number;
    }
    const number = useSelector(f);
    return (
        <div>
            <h3>Left 3 :{number} </h3>
        </div>
    )
}
function Left1(){
    const number = useSelector((state)=>state.number);
    return (
        <div>
            <h3>Left 1 {number} </h3>
            <Left2  ></Left2>
        </div>
    )
}
function Right1(){
    return (
        <div>
            <h3>Right 1  </h3>
            <Right2  ></Right2>
        </div>
    )
}
function Right2(){
    return (
        <div>
            <h3>Right 2:  </h3>
            <Right3  ></Right3>
        </div>
    )
}
function Right3(){
    const dispatch = useDispatch();

    return (
        <div>
            <h3>Right 3   </h3>
            <input type="button" value="+" onClick={() =>{
                dispatch( {type:'PLUS'});
            }}></input>
        </div>
    )
}
function App(){
    
    return (
        <div id="container">
            <h1>Root  </h1>
            <div id="grid">
                <Provider store={store}>
                    <Left1 ></Left1>
                    <Right1 ></Right1>
                </Provider>
            </div>
        </div>
    )
}

export default App;
