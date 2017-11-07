package controller;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Adminbean;
import model.PActionDao;

/**
 * Servlet implementation class RemoveCart
 */
@WebServlet("/RemoveCart")
public class RemoveCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCart() {
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
		
		
		int cartid=Integer.parseInt(request.getParameter("cartid"));
		
		System.out.println("cartid at removeCart controller "+cartid);
		
		InetAddress addr = InetAddress.getLocalHost(); 
		String ipAddress = addr.getHostAddress();

		

		HttpSession ss =request.getSession();
		String session=(String)ss.getAttribute("CustomerSession");
		
		
		System.out.println("ipaddress at removeCart controller "+ipAddress);
		
		PActionDao pd=new PActionDao();
		int z=pd.removeCart(cartid,session,ipAddress);
			

		if(z==1){
			ArrayList<Adminbean>list=pd.showcart(ipAddress ,session);

			RequestDispatcher rd=request.getRequestDispatcher("viewCart.jsp");
		 	request.setAttribute("LIST",list);
		 	
		 	rd.include(request, response); 
	}

}}
