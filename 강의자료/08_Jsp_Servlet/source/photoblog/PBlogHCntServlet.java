package myPortal.pblog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PBlogHCntServlet
 */
@WebServlet("/photoblog/pBlogUpHCnt")
public class PBlogHCntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PBlogManager pMgr = new PBlogManager();
		int num = Integer.parseInt(request.getParameter("num"));
		pMgr.upHCnt(num);
		String gid = request.getParameter("gid");
		if(gid==null)
			response.sendRedirect("home.jsp");
		else 
			response.sendRedirect("guest.jsp?gid="+gid);
	}

}
