import logo from './logo.svg';
import './App.css';
import {useState} from 'react';

function Article(props){
  return (
    <article>
      <h2>{props.title}</h2> 
        {props.body} 
    </article>
  )
}
function Nav( props){
  const list = [];
  for (let i=0; i < props.topics.length; i++){
    let t = props.topics[i];
    list.push(<li key={t.id} ><a id={t.id} href={'/read/'+t.id} onClick={event=>{
      event.preventDefault();
      props.onChangeMode( event.target.id );
    }}>{t.title}</a></li>)
  }
  return   <nav>
    <ol className='liclass'>
    {list}
    </ol>
  </nav>
  
}
function InputBox(){
  return (
    <>
      <label htmlFor='name'>이름 : </label>
      <input id='name' type='text'></input>
    </>
  )
}
function Header( props){
  const clickEvnet = (event) =>{
    event.preventDefault();
    props.onChangeMode();
  };
  return  <header>
      <h1><a href="/" onClick={clickEvnet}>{props.title}</a></h1>
    </header>
}
function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);

  
  const topics =[
    {id:1 , title:'html', body:'html is ...'},
    {id:2, title:'css', body:'css is ...'},
    {id:3, title:'javascript', body:'javascript is ...'}
  ]
  let content = null;
  if ( mode === 'WELCOME'){ 
    content = <Article title="WelCome" body="Hello , Web"></Article>
  } else if (mode === 'READ'){
    let title, body = null;
    for(let i=0; i<topics.length; i++){
      //console.log(topics[i].id, id);
      if(topics[i].id === Number(id) ){
        title = topics[i].title;
        body = topics[i].body;
        //console.log(topics[i].id, id);
      }
    }
    content = <Article title={title} body={body}></Article>
    console.log({title});
  }
  return (
    <div>
      <Header title="World Wide Web" onChangeMode={ () =>{
        setMode('WELCOME');
      }}></Header>
      <Nav topics={topics} onChangeMode={ (id) =>{
        setMode('READ');
        setId(id);
      }}></Nav>
      {content}
     </div>
  )
}

export default App;
