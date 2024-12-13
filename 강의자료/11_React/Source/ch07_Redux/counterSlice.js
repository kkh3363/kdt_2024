import { createSlice } from '@reduxjs/toolkit';

const counterSlice = createSlice({
    name:'counterSlice',
    initialState:{value:0},
    reducers:{
        up:(state,action)=>{
            console.log(action);
            state.value = state.value + action.payload ;
        }
    }
});
export default counterSlice;
export const {up} = counterSlice.actions;
