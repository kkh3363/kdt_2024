import React from 'react';
import { createSlice , configureStore} from '@reduxjs/toolkit';
import { useDispatch, useSelector,Provider } from 'react-redux';
import store from './store';
import {up} from './counterSlice';

function Counter(){
    const dispatch=useDispatch();
    const count = useSelector((state)=>{
         return state.counter.value;
         });
    return (
        <div>
            <button onClick={()=>{
            //    dispatch({type:'countSlice/up', step:2});
                dispatch( up(2));
            }}>+</button> {count}
        </div>
    )
}
function App(){
    return (
        <Provider store={store}>
        <div>
            <h1>증감기</h1>
            <Counter></Counter>
        </div>
        </Provider>

    )
}
export default App;
