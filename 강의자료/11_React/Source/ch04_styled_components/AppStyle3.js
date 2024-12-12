import styled,{css} from 'styled-components'

const StyledButton = styled.button`
  padding: 6px 12px;
  border-radius: 8px;
  font-size: 1rem;
  line-height: 1.5;
  border: 1px solid lightgray;

  color: ${(props) => props.color || "gray"};
  background: ${(props) => props.background || "white"};
`;
function Button({ children, color, background }) {
    return (
      <StyledButton color={color} background={background} Î>
        {children}
      </StyledButton>
    );
  }
  const StyledButton2 = styled.button`
    padding: 6px 12px;
    border-radius: 8px;
    font-size: 1rem;
    line-height: 1.5;
    border: 1px solid lightgray;
    color: ${(props) => props.color || "gray"};
    background: ${(props) => props.background || "white"};
    ${ (props)  =>{
            props.primary && 
            css`
                color: white;
                background: navy;
                border-color: navy;
            `}
        }
    `;
    
  function Button2({ children, ...props }) {
    return (
      <StyledButton2 {...props} Î>
        {children}
      </StyledButton2>
    );
  }
function AppStyle3(){
    return (
        <div>
            <Button color="green" background="pink">  Green Button </Button>
            <Button2 primary>  Primary Button </Button2>
        </div>
    )
}

export default AppStyle3;
