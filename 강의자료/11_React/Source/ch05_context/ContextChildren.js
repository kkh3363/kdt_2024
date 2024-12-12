import React from "react";
import Children2 from './ContextChidren2'
import ContextFunc from "./ConextFunc1";
class contextChildren extends React.Component {
    render(){
        return (
            <div>
                <h1>Children 1</h1>
                <Children2 />
                <hr />
                <ContextFunc />
            </div>
            
        );
    }
}
export default contextChildren;
