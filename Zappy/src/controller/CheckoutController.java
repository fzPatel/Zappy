package controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PActionDao;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutController() {
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
		
		HttpSession ss=request.getSession();
		String session=(String)ss.getAttribute("CustomerSession");

		System.out.println(session);
		PActionDao pd=new PActionDao();
		
		InetAddress addr = InetAddress.getLocalHost();   //Getting inet address from locahost 
		String ipAddress = addr.getHostAddress(); ///get perticular host address
		 
		
		if(session==null)
	{
			//-----insert customer session into cart with ip;
			
			response.sendRedirect("CustomerRedirectCheckoutToBuy.jsp");
			
			//pd.insertSession(session,ipAddress);

	}
		else if(session!=null)
		{
			
		//	dc.insertsessionIntoCart(session,ipAddress);
			
			response.sendRedirect("Customer_pending_list");
			
			pd.insertSession(session,ipAddress);
			
		//	pd.updateIpToCustomerID(session,ipAddress);
		
			
		}
	
	
	
	}

}
