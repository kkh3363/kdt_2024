package mymvc.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mymvc.models.Customer;
import mymvc.models.CustomerService;

/**
 * Servlet implementation class DoLoginController
 */
public class DoLoginController extends HttpServlet {
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
			page = "/views/error.jsp";
		else
			page = "/views/success.jsp";
		
		
		RequestDispatcher disp = request.getRequestDispatcher(page);
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
