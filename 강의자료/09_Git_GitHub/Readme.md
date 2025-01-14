## Git 명령어
-Git 설정 확인
```
git config --list
## 또는
git config -l
```
### 계정 설정
- -global를 사용하여 전역으로 설정
```
git config --global user.name "USER_NAME"
git config --global user.email "USER_EMAIL"
```
- Repository마다 다른 사용자(계정) 정보 사용
```
git config --local user.name "USER_NAME"
git config --local user.email "USER_EMAIL"
설정된 user.name, user.email이 있을 때, 삭제 후 설정 진행
```
### 설정된 계정 삭제
```
# global
git config --unset --global user.name
git config --unset --global user.email

# local
git config --unset user.name
git config --unset user.email
```
