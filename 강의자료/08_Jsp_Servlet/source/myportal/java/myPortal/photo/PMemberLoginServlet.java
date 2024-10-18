package myPortal.photo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PMemberLoginServlet
 */
public class PMemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PMemberManager pMgr = new PMemberManager();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = "index.jsp";
		if(pMgr.loginPMember(id, pwd)) {
			request.getSession().setAttribute("idKey", id);
			PMemberBean bean = pMgr.getPMember(id);
			request.getSession().setAttribute("bean", bean);
		}else {
			request.getSession().setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다");
		}
		response.sendRedirect(url);
	}

}
