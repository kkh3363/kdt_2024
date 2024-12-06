import React, {Component} from "react";

class ImportClass extends Component{
    // 2
    static getDerivedStateFromProps(props, state){
        console.log("2. getDerivedStateFromProps call : " + props.p_value);
        return {tmp_state:props.p_value};
    }
    // 1
    constructor(props){
        super(props);
        this.state = {};
        console.log("1. constructor call");
    }
    // 4 : 생성단계 맨 마지막....
    componentDidMount(){
        console.log("4. componentDidMount call");
        console.log('5. tmp_state: ' + this.state.tmp_state);
        this.setState({tmp_state2:true});
    }
    // 6
    shouldComponentUpdate(props, state){
        console.log('6. shouldComponentUpdate / tmp_state2 =' + this.state.tmp_state2);
        return state.tmp_state2;
    }
    // 3
    render(){
        console.log("3. render call");
        return <>
            <h2>[ 클래스 컴포넌트 ] </h2>
        </>
    }
}

export default ImportClass;
