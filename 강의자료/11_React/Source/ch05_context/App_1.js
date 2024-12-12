import './style.css';
import React,{createContext, useContext} from 'react';

const themeDefault = {border: '10px solid green'};
const themeContext = createContext(themeDefault);

function Sub1(){
  return (
    <div >
      <h1>Sub1</h1>
      <Sub2></Sub2>
    </div>
  );
}
function Sub2(){
  const theme = useContext(themeContext);
  return (
    <div style={theme}>
      <h1>Sub2</h1>
      <Sub3></Sub3>
    </div>
  );
}
function Sub3(){
  return (
    <div >
      <h1>Sub3</h1>
    </div>
  );
}
function App() {
  
  //console.log('theme', theme);
  return (
    <div className='root'>
      <h1>hello World! App</h1>
      <Sub1></Sub1>
    </div>
  );
}

export default App;
