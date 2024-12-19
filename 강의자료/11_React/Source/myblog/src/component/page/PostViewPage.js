import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import styled from "styled-components";
import Button from "../ui/Button";
import data from "../../data.json";
import CommentList from "../list/CommentList";
import TextInput from "../ui/TextInput";
const Wrapper = styled.div`
  padding: 16px;
  width: calc(100%-32px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: cenger;
`;
const Container = styled.div`
  width: 100%;
  max-width: 720px;

  :not(:last-child) {
    margin-botton: 16px;
  }
`;
const PostContainer = styled.div`
  padding: 8px 16px;
  border: 1px solid grey;
  border-radius: 8px;
`;
const TitleText = styled.p`
  font-size: 28px;
  font-weight: 500;
`;
const ContentText = styled.p`
  font-size: 20px;
  line-height: 32px;
  white-space: pre-wrap;
`;
const CommentLabel = styled.p`
  font-size: 16px;
  font-weight: 500;
`;

function PostViewPage(props) {
  const navigate = useNavigate();
  const { postId } = useParams();
  const [comment, setComment] = useState("");

  const post = data.find((item) => {
    return item.id === Number(postId);
  });

  return (
    <Wrapper>
      <Container>
        <Button
          title="뒤로가기"
          onClick={() => {
            navigate("/");
          }}
        />
        <PostContainer>
          <TitleText>{post.title}</TitleText>
          <ContentText>{post.content}</ContentText>
        </PostContainer>

        <CommentLabel>댓글</CommentLabel>
        <CommentList comments={post.comments} />
        {/* 댓글 작성 */}
        <p></p>
        <TextInput
          height={40}
          value={comment}
          onChange={(event) => {
            setComment(event.target.value);
          }}
        />
        <Button
          title="댓글작성"
          onClick={() => {
            console.log("comment : ", comment);
            navigate("/");
          }}
        />
      </Container>
    </Wrapper>
  );
}
export default PostViewPage;
