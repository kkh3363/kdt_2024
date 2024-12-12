import React, { useContext } from "react";
import { DataContext } from "./ContextApi";

function ContextFunc(){
    const dataContext = useContext(DataContext);
    return (
        <div >
                <h2>function 1</h2>
                <h3>{dataContext}</h3>
            </div>  
    );
}

export default ContextFunc;
