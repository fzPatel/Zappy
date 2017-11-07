package controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoCustomer;
import model.PActionDao;


/**
 * Servlet implementation class CustomerLoginController
 */
@WebServlet("/CustomerLoginController")
public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mobile=request.getParameter("Cid");
		String Cpwd=request.getParameter("Cpwd");
		DaoCustomer id=new DaoCustomer();
		PActionDao pd=new PActionDao();
		int y=id.check(mobile, Cpwd);
		if (y==1)
	{	
		
	HttpSession ss =request.getSession();
	ss.setAttribute("CustomerSession", mobile);
	
//	
	InetAddress addr = InetAddress.getLocalHost(); 
	String ipAddress = addr.getHostAddress();
	
	HttpSession s =request.getSession();
	s.setAttribute("CustomerIp", ipAddress);
	
	
	pd.insertSession(mobile,ipAddress);
	

response.sendRedirect("ZappyProductsController");
	}
else {
		RequestDispatcher rd=request.getRequestDispatcher("CustomerLogin.jsp");
			request.setAttribute("msg", "Login Failed try Again");
			rd.forward(request, response);

		}
	}}
