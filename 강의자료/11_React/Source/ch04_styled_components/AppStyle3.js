import styled from 'styled-components'

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

function AppStyle3(){
    return (
        <div>
            <Button color="green" background="pink">  Green Button </Button>;
        </div>
    )
}

export default AppStyle3;
