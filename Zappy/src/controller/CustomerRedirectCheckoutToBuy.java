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
 * Servlet implementation class CustomerRedirectCheckoutToBuy
 */
@WebServlet("/CustomerRedirectCheckoutToBuy")
public class CustomerRedirectCheckoutToBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRedirectCheckoutToBuy() {
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
	

	response.sendRedirect("Customer_pending_list");
	}
else {
		RequestDispatcher rd=request.getRequestDispatcher("CustomerRedirectCheckoutToBuy.jsp");
			request.setAttribute("msg", "Login Failed try Again");
			rd.forward(request, response);

		}
	}}
