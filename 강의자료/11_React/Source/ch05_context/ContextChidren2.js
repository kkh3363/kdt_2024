import React from "react";
import { DataContext } from "./ContextApi";
class contextChildren2 extends React.Component {
    render(){
        return (
            <div >
                <h2>Children 2</h2>
                <DataContext.Consumer>
                    {contextValue=> <h3>{`contextValue : ${contextValue}`}</h3>}
                </DataContext.Consumer>
            </div>
        
        );
    }
}
export default contextChildren2;
