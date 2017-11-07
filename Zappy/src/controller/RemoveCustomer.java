package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminDao;

/**
 * Servlet implementation class RemoveCustomer
 */
@WebServlet("/RemoveCustomer")
public class RemoveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCustomer() {
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
		
		String mobile=request.getParameter("Cmobile");
		
		AdminDao ad=new AdminDao();
		int x=ad.RemoveCustomer(mobile);
		if(x==1)
		{	
	
		response.sendRedirect("Admin_ViewAllCustomer");
		
//		ArrayList<Customer>list=ad.admin_ViewAllCustomer();
//
//		RequestDispatcher rd=request.getRequestDispatcher("Admin_ViewAllCustomer");
//		rd.forward(request, response);
	}
		
		
		
		
		
	}

}
