import { Button } from "bootstrap";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import PostList from "../list/PostList";
import data from "../../data.json";

const Wrapper = styled.div`
  padding: 16px;
  width: calc(100% - 32px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;
const Container = styled.div`
  width: 100%;
  max-width: 720px;

  :not(:last-child) {
    margin-bottom: 16px;
  }
`;

function MainPage(props) {
  const navigate = useNavigate();

  return (
    <Wrapper>
      <Container>
        <Button
          title="글작성하기"
          onClick={() => {
            navigate("/post-write");
          }}
        ></Button>

        <PostList
          posts={data}
          onClickItem={(item) => {
            navigate(`/post/${item.id}`);
          }}
        ></PostList>
      </Container>
    </Wrapper>
  );
}

export default MainPage;
