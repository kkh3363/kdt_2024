import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
//import App from './App';
import reportWebVitals from './reportWebVitals';
import { HashRouter,Route, Routes, NavLink, useParams } from 'react-router-dom';

function Home() {
  return (
    <div>
      <h2>Home</h2>
      Home...
    </div>
  );
}

function Contact() {
  return (
    <div>
      <h2>Contact</h2>
      Contact...
    </div>
  );
}
function NotFound(){
  return (<div>
    <h2>Not Fount</h2>
    </div>
  );
}
var contents =[
  { id:1, title:'HTML', description:'Html is ...'},
  { id:2, title:'JS', description:'JS is ...'},
  { id:3, title:'React', description:'React is ...'},
  { id:4, title:'CSS', description:'css is ...'},
]
function Topic(){
  var params= useParams();
  var topic_id = params.topic_id;
  //console.log(params);
  var selected_topic = {
    title:'Sorry',
    description:'Not Found'
  };
  for(var i=0; i < contents.length; i++ ){
    if ( contents[i].id == topic_id){
      selected_topic  = contents[i];
    }
  }
  return (
    <div>
      <h3>{selected_topic.title}</h3>
      {selected_topic.description}
    </div>

  );
}
function Topics() {
  var list =[];
  for (var i=0; i <contents.length; i++){
    list.push(
      <li key={contents[i].id}><NavLink to={"/topics/"+contents[i].id}>{contents[i].title}</NavLink></li>
    )
  }
  return (
    <div>
      <h2>Topics</h2>
      <ul>
        {list}
      </ul>
      <Routes>
        <Route path="/:topic_id" element={<Topic />}/>
      </Routes>
    </div>
  );
}
function App(){
  return (
    <div>
      <h1>Hello React Router Dom</h1>
      <ul>
        <li><NavLink to="/">Home</NavLink></li>
        <li><NavLink to="/topics">Topics</NavLink></li>
        <li><NavLink to="/contact">Contact</NavLink></li>
      </ul>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/topics/*" element={<Topics />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/*"  element={<NotFound />} />
      </Routes>
    </div>
  );
}
const root = ReactDOM.createRoot(document.getElementById('root')).render(<HashRouter><App /></HashRouter>);
// root.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>
// );

reportWebVitals();
