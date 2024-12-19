import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import styled from "styled-components";
import MainPage from "./component/page/Main";
import PostWritePage from "./component/page/PostWrite";

const MainText = styled.p`
  font-size: 24px;
  font-weight: bold;
  text-align: center;
`;
function App() {
  return (
    <BrowserRouter>
      <MainText> 리액트 미니 블로그</MainText>
      <Routes>
        <Route index element={<MainPage />} />
        <Route path="post-write" element={<PostWritePage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
