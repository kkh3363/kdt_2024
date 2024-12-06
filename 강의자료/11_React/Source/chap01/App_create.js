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
//-----------------------------------------------------------
//  Create()
function Create( props){
  return (
    <article>
      <h2>Create</h2>
      <form onSubmit={event =>{
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value;
        props.onCreate(title, body);
      }}>
        <p><input type='text' name='title' placeholder='제목' /></p>
        <p>
        <textarea name='body' placeholder='내용'></textarea></p>
        <p ><input type="submit" value="Create" /></p>
      </form>
    </article>
  )
}
//-----------------------------------------------------------
//  App()
function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  const [nextId, setNextId] = useState(4);
  const [topics, setTopics] =useState([
    {id:1 , title:'html', body:'html is ...'},
    {id:2, title:'css', body:'css is ...'},
    {id:3, title:'javascript', body:'javascript is ...'}
  ]);

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
  } else if ( mode === 'CREATE'){
    content = <Create onCreate={(_title, _body)=>{
      const newTopic = { id:nextId, title:_title, body:_body};
      const newTopics = [...topics]; // {...topics}
      newTopics.push(newTopic);
      setTopics(newTopics );
      setMode('READ');
      setId(nextId);
      setNextId(nextId+1);
    }}></Create>
  }
  return (
    <div>
      <Header title="World Wide Web" onChangeMode={ () =>{
        setMode('WELCOME');
      }}></Header>
      <hr></hr>
      <Nav topics={topics} onChangeMode={ (id) =>{
        setMode('READ');
        setId(id);
      }}></Nav>
      <hr></hr>
      {content}
      <a href="/create" onClick={event=>{
        event.preventDefault();
        setMode('CREATE');
      }}>Create</a>
     </div>
  )
}

export default App;
