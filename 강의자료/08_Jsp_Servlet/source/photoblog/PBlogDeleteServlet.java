package myPortal.pblog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PBlogDeleteServlet
 */
@WebServlet("/photoblog/pBlogDelete")
public class PBlogDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PBlogManager pMgr = new PBlogManager();
		int num = Integer.parseInt(request.getParameter("num"));
		pMgr.deletePBlog(num);
		response.sendRedirect("home.jsp");
	}

}
