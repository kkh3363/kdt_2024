package myPortal.pblog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PBlogLoginServlet
 */
@WebServlet("/photoblog/pBlogLogin")
public class PBlogLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		PBlogManager pMgr = new PBlogManager();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = "login.jsp";
		
		if ( pMgr.loginPMember(id, pwd) ) {
			request.getSession().setAttribute("idKey", id);
			url ="home.jsp";
		} else {
			request.getSession().setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다");
		}
		response.sendRedirect(url);
		
	}

}
