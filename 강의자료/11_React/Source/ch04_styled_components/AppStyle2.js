import styled from 'styled-components'



const SimpleButton= styled.button`
    color:blue;
    backgroud-color:green;
`;

const LargeButton= styled(SimpleButton)`
    color: red;
    font-size: 50px;
`;
const ReactButton = (props) =>{
    
    return <button className={props.className}>{props.children}</button>
};
const ReactLargeButton=styled(ReactButton)`
    font-size: 50px;
`;
const PrimaryButton=styled.button`
    color:${function(props){
        if ( props.primary)
            return 'blue';
        else
            return 'black';
    }};
`;
const PrimaryButton2=styled.button`
    color:${(props) =>  props.primary ? 'blue' :'black'};
    background-color:${(props) =>  props.primary ? 'red' :'white'};
`;
function AppStyle2(){
    return (
        <div>
            <SimpleButton>스타일버튼</SimpleButton> &nbsp;&nbsp;
            <LargeButton>라지버튼</LargeButton>
            <ReactLargeButton>리액트 라지 버튼</ReactLargeButton><br />
            <PrimaryButton primary> Primary Button</PrimaryButton>
            <PrimaryButton2 > Primary Button</PrimaryButton2>
        </div>
    )
}

export default AppStyle2;
