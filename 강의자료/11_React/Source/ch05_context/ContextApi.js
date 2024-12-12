import React from "react";
import Children from './ContextChildren';

const DataContext = React.createContext();
export {DataContext}

class ContextApi extends React.Component {
    render(){
        return (
            <DataContext.Provider value='React_Example'>
                <Children />
            </DataContext.Provider>
        );
    }
}
export default ContextApi;
