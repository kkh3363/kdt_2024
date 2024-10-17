<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("idKey"); 
%>    
<div class="user-info">
<%  if ( id == null) { %>
    <a href="<%=request.getContextPath()%>/member/login.jsp" class="btn btn-primary"  >로그인</a>
    <a href="<%=request.getContextPath()%>/member/member.jsp" class="btn btn-primary"  >회원가입</a>
<%  } else { %>    
    <span class="welcome"  ><%=id %></span>님 환영합니다!
    <form   method="post" style="display: inline;">
          <input type="submit" class="btn btn-logout" value="로그아웃"/>
    </form>
<%  }   %>    
</div>
