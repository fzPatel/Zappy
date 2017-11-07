package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Adminbean;
import model.AdminDao;

/**
 * Servlet implementation class AdminOrderAction
 */
@WebServlet("/AdminOrderAction")
public class AdminOrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderAction() {
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

	
	
	String btn=(String)request.getParameter("btn");
	AdminDao ad =new AdminDao();
	
	int pid=Integer.parseInt(request.getParameter("pid"));
	String pname=request.getParameter("pname");
	String pqntity=request.getParameter("pqntity");
	double pprice=Double.parseDouble(request.getParameter("pprice"));
	String ipaddr=request.getParameter("ipaddr");
	String pimage=request.getParameter("pimage");
	String orderdate=request.getParameter("orderdate");
	String status=request.getParameter("status");
	
	String weight=request.getParameter("pweight");
	String Customerid=request.getParameter("Customerid");
	int orderid=Integer.parseInt(request.getParameter("orderid"));

	
	System.out.println(pid);
	System.out.println(pname);
	System.out.println(pqntity);
	System.out.println(pprice);
	System.out.println(ipaddr);
	System.out.println(pimage);
	System.out.println(orderdate);
	System.out.println(status);
	System.out.println(weight);
	
	Adminbean ab=new Adminbean();
	ab.setDate(orderdate);
	ab.setImage(pimage);
	ab.setIpAddress(ipaddr);
	ab.setPid(pid);
	ab.setWeight(weight);
	ab.setStatus(status);
	ab.setQnty(pqntity);
	ab.setPrice(pprice);
	ab.setPname(pname);
	
	System.out.println(ab.getQnty());
	
	if(btn.equals("Not Available"))
	{
		int x=ad.cancelOrder(orderid,Customerid);
		if(x!=0)

		{
			RequestDispatcher rd=request.getRequestDispatcher("AdminViewPendingforDispachList");
			rd.forward(request, response);

		}
		
	}
	else if(btn.equals("Dispatch")){
	
	System.out.println("session on dipached click"+ Customerid);
	
	int y=ad.dispatchorder(orderid,Customerid);
//	int x=ad.orderhistory(pid,customerid,ab);

	//if(x!=0 && y!=0)
		if(y!=0)

	{
		RequestDispatcher rd=request.getRequestDispatcher("AdminViewPendingforDispachList");
		rd.forward(request, response);

	}}


	}

}
