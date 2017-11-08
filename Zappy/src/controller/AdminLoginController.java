package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDao;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")

public class AdminLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
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
	
		String u=request.getParameter("uid");
		String p=request.getParameter("pwd");
		
		AdminDao id=new AdminDao();
		
		int y=id.logincheck(u, p);
		if (y==1) {
			
			HttpSession ss=request.getSession();
			ss.setAttribute("session",u);
			response.sendRedirect("AdminHome.jsp");
			System.out.println("Admin session stablished "+u);
		
		} else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Login Failed try Again");
			rd.forward(request, response);

		}
	}
	}

