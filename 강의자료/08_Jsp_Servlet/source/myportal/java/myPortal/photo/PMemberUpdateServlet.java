package myPortal.photo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class PMemberUpdateServlet
 */
public class PMemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PMemberManager pMgr = new PMemberManager();
		pMgr.updatePMember(request);
		HttpSession session = request.getSession();
		PMemberBean bean = pMgr.getPMember((String)session.getAttribute("idKey"));
		session.setAttribute("bean", bean);
		response.sendRedirect("index.jsp");
	}

}
