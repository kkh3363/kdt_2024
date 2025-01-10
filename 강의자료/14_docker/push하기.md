### github push
- 토큰 발급
  - setting > develop > personal access tokens > Tokens(classic)
- login
  - docker login ghcr.io -u 아이디 -p 토큰....
    
- 컨테이이너 이미지 만들기
  - docker commit 컨테이너이름  ghcr.io/아이디/이미지:tag 
  - docker commit hello_container ghcr.io/아이디../gs-spring-boot-docker:1.0
- push
  -  docker push ghcr.io/아이디../gs-spring-boot-docker:1.0
