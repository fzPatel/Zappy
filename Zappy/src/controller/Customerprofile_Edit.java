package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import model.DaoCustomer;

/**
 * Servlet implementation class Customerprofile_Edit
 */
@WebServlet("/Customerprofile_Edit")
public class Customerprofile_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customerprofile_Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss =request.getSession();
		String mobile=(String)ss.getAttribute("CustomerSession");
		
		
	//	InetAddress addr = InetAddress.getLocalHost(); 
		//String ipAddress = addr.getHostAddress();

//				PActionDao pc=new PActionDao();
	
		
		DaoCustomer d=new DaoCustomer();
	//	
		ArrayList<Customer> list=d.ViewCustomDetails(mobile);
//		ArrayList<Emp>productlist=pc.Viewcart(ipAddress);
	//	

		RequestDispatcher rd=request.getRequestDispatcher("Customer_profile_Edit.jsp");
		request.setAttribute("accountEdit", list);
//			request.setAttribute("productdetails",productlist);
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
