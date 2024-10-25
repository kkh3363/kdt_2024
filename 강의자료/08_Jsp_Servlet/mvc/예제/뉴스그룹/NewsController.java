package mymvc.controllers;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mymvc.models.News;
import mymvc.models.NewsDao;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/news.nhn")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDao newsDao;
	private ServletContext ctx;
	private final String START_PAGE = "view/newsList.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		newsDao = new NewsDao();
		ctx = getServletContext();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		Method m;
		String view =null;
		
		if ( action == null || action=="")
			action = "listNews";
		try {
			// 현재 클래스에서 action 이름과 HttpServletRequest 를 파라미터로 하는 메서드 찾음
			m = this.getClass().getMethod(action , HttpServletRequest.class);
			
			view = (String)m.invoke(this, request);
			System.out.println("view :: "+view);
		}catch(NoSuchMethodException e) {
			e.printStackTrace();
			ctx.log("요청 action 없음!!");
			request.setAttribute("error", "action 파라미터가 잘못 되었습니다!!");
			view = START_PAGE;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(view.startsWith("redirect:/")) {
			String rview = view.substring("redirect:/".length());
			response.sendRedirect(rview);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
	//
	public String listNews(HttpServletRequest request) {
		List<News> list;
		try {
			list = newsDao.getAll();
	    	request.setAttribute("newslist", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다!!");
		}
    	return "views/newsList.jsp";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
