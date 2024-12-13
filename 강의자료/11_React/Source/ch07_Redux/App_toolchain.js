import React from 'react';
import { createSlice , configureStore} from '@reduxjs/toolkit';
import { useDispatch, useSelector,Provider } from 'react-redux';

const counterSlice = createSlice({
    name:'countSlice',
    initialState:{value:0},
    reducers:{
        up:(state,action)=>{
            console.log(action);
            state.value = state.value + action.step;
        }
    }
});

const store = configureStore({
    reducer:{
        counter: counterSlice.reducer
    }
    
});
function Counter(){
    const dispatch=useDispatch();
    const count = useSelector((state)=>{
         return state.counter.value;
         });
    return (
        <div>
            <button onClick={()=>{
                dispatch({type:'countSlice/up', step:2});
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
