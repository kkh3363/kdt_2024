import React from "react";
import Children from './contextChildren';

const DataContext = React.createContext();
export {DataContext}
DataContext.displayName="dataContext";
class ContextApi extends React.Component {
    constructor(props){
        super(props);
        this.setStateFunc = this.setStateFunc.bind(this);
        
    }
    setStateFunc(value){
        this.setState({name:value});
    }
    render(){
        const content={
            ...this.state, 
            setStateFunc : this.setStateFunc
        }
        return (
            <DataContext.Provider value={content}>
                <Children />
            </DataContext.Provider>
        )
    }
}
export default ContextApi;
