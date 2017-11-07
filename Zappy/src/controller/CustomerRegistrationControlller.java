package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Customer;
import model.DaoCustomer;

/**
 * Servlet implementation class CustomerRegistrationControlller
 */
@WebServlet("/CustomerRegistrationControlller")
public class CustomerRegistrationControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistrationControlller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("Cname");
		String email=request.getParameter("email");
		String address =request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String Cpwd=request.getParameter("password");
		
		Customer c=new Customer();
		c.setCname(name);
		c.setMobile(mobile);
		c.setEmail(email);
		c.setAddress(address);
		c.setCity(city);
		c.setState(state);
		c.setCpwd(Cpwd);
		
	DaoCustomer d=new DaoCustomer();
	
	int x=d.fatchMobile(mobile);
	
if(x!=0) {
			PrintWriter out=response.getWriter();
			out.println("Mobile Number already registerd");
				
		}
//if(x==0) 
//
//{
//	
//int y=d.registration(c);
//	
//	if(y==1)
//{
//		RequestDispatcher rd=request.getRequestDispatcher("CustomerRegistration.jsp");
//		request.setAttribute("Registermsg","Register succesfull");
//		rd.forward(request, response);
//		
//
//}
			//}
	

		
		
		
		
		
		
}
		
		
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("Cname");
		String email=request.getParameter("email");
		String address =request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String Cpwd=request.getParameter("password");
		
		Customer c=new Customer();
		c.setCname(name);
		c.setMobile(mobile);
		c.setEmail(email);
		c.setAddress(address);
		c.setCity(city);
		c.setState(state);
		c.setCpwd(Cpwd);
		
	DaoCustomer d=new DaoCustomer();
	
	int x=d.fatchMobile(mobile);
	
if(x!=0) {
			PrintWriter out=response.getWriter();
			out.println("Mobile Number already registerd");
				
		}
if(x==0) 

{
	
int y=d.registration(c);
	
	if(y==1)
{
		RequestDispatcher rd=request.getRequestDispatcher("CustomerRegistration.jsp");
		request.setAttribute("Registermsg","Register successful");
		rd.forward(request, response);
		

}
			}
	}
}
