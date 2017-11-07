package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Adminbean;
import model.PActionDao;

/**
 * Servlet implementation class OrderProduct
 */
@WebServlet("/OrderProduct")
public class OrderProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderProduct() {
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

		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		String pqntity=request.getParameter("pqntity");
		double pprice=Double.parseDouble(request.getParameter("pprice"));
		String ipaddr=request.getParameter("ipaddr");
		String pimage=request.getParameter("pimage");
		String orderdate=request.getParameter("orderdate");
		String pstatus=request.getParameter("pstatus");
		String weight=request.getParameter("pweight");
		int cartid=Integer.parseInt(request.getParameter("cartid"));
			
		
		System.out.println(pid);
		System.out.println(pname);
		System.out.println(pqntity);
		System.out.println(pprice);
		System.out.println(ipaddr);
		System.out.println(pimage);
		System.out.println(orderdate);
		System.out.println(pstatus);
		System.out.println(weight);
		
		
		
		Adminbean ab=new Adminbean();
		ab.setDate(orderdate);
		ab.setImage(pimage);
		ab.setIpAddress(ipaddr);
		ab.setPid(pid);
		ab.setWeight(weight);
		ab.setStatus(pstatus);
		ab.setQnty(pqntity);
		ab.setPrice(pprice);
		ab.setPname(pname);
		
		System.out.println(ab.getQnty());
		
		
		PActionDao pd=new PActionDao();
		
		
		
		
		HttpSession ss=request.getSession();
		String customerid =(String)ss.getAttribute("CustomerSession");
		
		int x=pd.orderproduct(cartid,customerid,ab);
		
		if(x!=0) 
		{
			response.sendRedirect("Customer_pending_list");
			
		}
		
	}

}
