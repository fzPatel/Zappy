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
 * Servlet implementation class Customer_order_status
 */
@WebServlet("/Customer_order_status")
public class Customer_order_status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_order_status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PActionDao pd=new PActionDao();
		HttpSession ss=request.getSession();
	String session=(String)ss.getAttribute("CustomerSession");
	InetAddress addr = InetAddress.getLocalHost(); 
	String ipAddress = addr.getHostAddress();
		
		ArrayList<Adminbean> list=pd.viewCustomer_order_status(session,ipAddress);
	
		
		if(!list.isEmpty()) {
			
			System.out.println("not empty");
		}
		else
			{System.out.println("empty");}
		
		RequestDispatcher rd=request.getRequestDispatcher("Customer_order_status.jsp");
		request.setAttribute("Customerorderstatus", list);
		rd.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
