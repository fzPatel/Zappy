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
import bean.Customer;
import model.DaoCustomer;
import model.PActionDao;

/**
 * Servlet implementation class CustomerBill
 */
@WebServlet("/CustomerBill")
public class CustomerBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss =request.getSession();
		String mobile=(String)ss.getAttribute("CustomerSession");
	
		InetAddress addr = InetAddress.getLocalHost(); 
		String ipAddress = addr.getHostAddress();
		
	
		PActionDao pc=new PActionDao();
		DaoCustomer d=new DaoCustomer();
		
		ArrayList<Customer> list=d.ViewCustomDetails(mobile);
		
		ArrayList<Adminbean>productlist=pc.Viewcart(ipAddress,mobile);
		
		RequestDispatcher rd=request.getRequestDispatcher("Customer_bill.jsp");
		request.setAttribute("accountDetails", list);
		request.setAttribute("productdetails",productlist);
	rd.include(request, response);	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
