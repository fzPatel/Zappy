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
 * Servlet implementation class Customer_pending_list
 */
@WebServlet("/Customer_pending_list")
public class Customer_pending_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_pending_list() {
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
	
	InetAddress addr = InetAddress.getLocalHost();   //Getting inet address from locahost 
	String ipAddress = addr.getHostAddress(); ///get perticular host address
	 
	
		ArrayList<Adminbean> list=pd.viewCustomerPendinglist(session);
	
		RequestDispatcher rd=request.getRequestDispatcher("Customer_viewPendinglist.jsp");
		request.setAttribute("CustomerPendinglist", list);
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
