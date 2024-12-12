import React from "react";
import { DataContext } from "./contextApi";

class ContextChildren extends React.Component {
    

    render(){
        console.log(DataContext.displayName);
        return (
            <DataContext.Consumer>
                {contextValue =>
                <button onClick={e =>contextValue.setStateFunc('ReactExample')}>
                    {contextValue.name}
                </button>

                }
            </DataContext.Consumer>
        )
    }
}
export default ContextChildren;
