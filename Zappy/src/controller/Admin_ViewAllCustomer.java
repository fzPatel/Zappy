package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Customer;
import model.AdminDao;

/**
 * Servlet implementation class Admin_ViewAllCustomer
 */
@WebServlet("/Admin_ViewAllCustomer")
public class Admin_ViewAllCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_ViewAllCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao ad=new AdminDao();
		ArrayList<Customer> list=ad.admin_ViewAllCustomer();
		
		
		RequestDispatcher rd=request.getRequestDispatcher("AdminView_allCustomer.jsp");
		request.setAttribute("allCustomer",list);
		rd.include(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
		
	}

}
