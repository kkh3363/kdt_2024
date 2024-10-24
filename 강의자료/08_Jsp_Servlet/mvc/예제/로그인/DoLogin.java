package myapp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myapp.model.Customer;
import myapp.service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String customerId = request.getParameter("customerId");
		
		CustomerService service = new CustomerService();
		String page=null;
		Customer customer  = service.findCustomer(customerId);
		request.setAttribute("customer", customer);
		
		
		if( customerId == null || customerId == "")
			page = "/View/error.jsp";
		else
			page = "/View/success.jsp";
		
		
		RequestDispatcher disp = request.getRequestDispatcher(page);
		disp.forward(request, response);
		
	}

}
