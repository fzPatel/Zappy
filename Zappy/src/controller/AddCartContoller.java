package controller;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Adminbean;
import model.AdminDao;
import model.PActionDao;

/**
 * Servlet implementation class AddCartContoller
 */
@WebServlet("/AddCartContoller")
public class AddCartContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PActionDao pc=new PActionDao();   //create object of PActionDao;
 		
		InetAddress addr = InetAddress.getLocalHost();   //Getting inet address from locahost 
		String ipAddress = addr.getHostAddress(); ///get perticular host address
		 
		HttpSession ss =request.getSession();//getting session from httpsession
		String session=(String)ss.getAttribute("CustomerSession");   
		
		
		ArrayList<Adminbean>list=pc.showcart(ipAddress,session);

			//ArrayList<Adminbean>list=pc.showcart(ipAddress,cid);
			
				RequestDispatcher rd=request.getRequestDispatcher("viewCart.jsp");//request dispature will include the data and forward to another page
			 	request.setAttribute("LIST",list);
			 	
			 	rd.include(request, response); 
		 
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int day, month, year;
		GregorianCalendar date = new GregorianCalendar();   //creating object of GregorianCalendar to get current time and date
		day = date.get(Calendar.DAY_OF_MONTH);		//getting day from same calendar
		month = date.get(Calendar.MONTH);			////getting date from same month
		year = date.get(Calendar.YEAR);			//getting year from same calendar
		String order_date= (year+"/"+(month+1)+"/"+day);  //concate day date and time in a same variable
	
		String pid=request.getParameter("pid");    //getting product id from jsp page and assigning in a variable
		System.out.println(pid);
	
String qnty=request.getParameter("addcartfield");          //getting cart filed from jsp page and assigning in a variable

double price=Double.parseDouble(request.getParameter("price"));     //getting price from jsp page and assigning in a variable

String pname=request.getParameter("pname");    //getting product name from jsp page and assigning in a variable
String pimage=request.getParameter("pimage");     // //getting product image from jsp page and assigning in a variable
String pweight=request.getParameter("pweight");   //getting product weight from jsp page and assigning in a variable

String btn=request.getParameter("cartbtn");    // getting button id from jsp page and assigning in a variable

InetAddress addr = InetAddress.getLocalHost();   // //getting IPaddress from jsp page and assigning in a variable
String ipAddress = addr.getHostAddress();


PActionDao pc=new PActionDao();
 		
Adminbean e=new Adminbean();

int p=Integer.parseInt(pid);

e.setPid(p);
 	e.setIpAddress(ipAddress);
 	e.setQnty(qnty);
 	e.setPrice(price);
 	e.setImage(pimage);
 	e.setPname(pname);
 	e.setDate(order_date);
 	e.setWeight(pweight);
 	
	HttpSession ss=request.getSession();
String CustomerId=(String)ss.getAttribute("CustomerSession");

 if(btn.equals("Add to cart"))
 	
 {
//	if(CustomerId==null)
//{

		// response.sendRedirect("check_session.jsp");
		 
		// int y=pc.addcart(e,CustomerId);
// 			
//		 	if(y==1)
//		 {
//		 		AdminDao ad=new AdminDao();
//				ArrayList<Adminbean>list=ad.ViewProducts();	 
//				
//				RequestDispatcher rd=request.getRequestDispatcher("ZappyProducts.jsp");
//				  request.setAttribute("LIST", list);
//				  request.setAttribute("cardadded", "card added");
//				  rd.include(request, response);
//		 		 	}
//	
	//}
	
		// else if (CustomerId!=null){
			
			 
	int c=pc.checkSameidForUpend(pid,qnty,ipAddress);
															//check the product id if exist so update the quantity
	System.out.println("Product Id is Exist "+c);

if(c!=0)
		
{
				AdminDao ad=new AdminDao();
				ArrayList<Adminbean>list=ad.ViewProducts();	
				
				
				ArrayList<Adminbean>list1=ad.viewCartBox();			

				RequestDispatcher rd=request.getRequestDispatcher("ZappyProducts.jsp");
				request.setAttribute("LIST", list);
				  request.setAttribute("LIST1", list1);

			//	request.setAttribute("cardadded", "cart added");
				rd.forward(request, response);
	}
if(c==0) 
		
{
	int y=pc.addcart(e,CustomerId);
	
	System.out.println("cart added"+y);
		
	 		
	 		if(y==1)
			 {
			 		AdminDao ad=new AdminDao();
					ArrayList<Adminbean>list=ad.ViewProducts();	 
					ArrayList<Adminbean>list1=ad.viewCartBox();			

					RequestDispatcher rd=request.getRequestDispatcher("ZappyProducts.jsp");
					  request.setAttribute("LIST", list);
					  request.setAttribute("LIST1", list1);

				//	  request.setAttribute("cardadded", "card added");
					  rd.include(request, response);
			 		 	}
			 }

			 
		 }}
	
}