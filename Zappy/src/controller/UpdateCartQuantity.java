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

import model.PActionDao;

/**
 * Servlet implementation class UpdateCartQuantity
 */
@WebServlet("/UpdateCartQuantity")
public class UpdateCartQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartQuantity() {
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
	
	String pquantity=request.getParameter("pquantity");
	int cartid=Integer.parseInt(request.getParameter("cartid"));
	
	

	InetAddress addr = InetAddress.getLocalHost();   //Getting inet address from locahost 
	String ipAddress = addr.getHostAddress(); ///get perticular host address
	 
	
	System.out.println(pquantity);
	System.out.println(cartid);
	
HttpSession ss=request.getSession();
 String customerId=(String)ss.getAttribute("CustomerSession");
	
	PActionDao pd=new PActionDao();
	
	int x=pd.updateCartQuantity(pquantity,cartid, ipAddress,customerId);
	

	response.sendRedirect("AddCartContoller");
//	RequestDispatcher rd=request.getRequestDispatcher("");
//	rd.forward(request, response);
	}

}
