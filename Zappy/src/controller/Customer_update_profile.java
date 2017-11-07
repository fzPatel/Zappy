package controller;

import java.io.IOException;

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
 * Servlet implementation class Customer_update_profile
 */
@WebServlet("/Customer_update_profile")
public class Customer_update_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_update_profile() {
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
		
		HttpSession ss =request.getSession();
		ss.setAttribute("CustomerSession", mobile);
	
	DaoCustomer d=new DaoCustomer();
		int y=0;
	y=d.updateCustomer(c);
	if(y!=0)
	{
		RequestDispatcher rd=request.getRequestDispatcher("Customerprofile_Edit");
		request.setAttribute("Profile updated Successfully","profileupdatemsg");
		
		rd.forward(request, response);
		
	}else
	{
		RequestDispatcher rd=request.getRequestDispatcher("Customerprofile_Edit");
	request.setAttribute("Connection error","profileupdatemsg");
	rd.include(request, response);
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
