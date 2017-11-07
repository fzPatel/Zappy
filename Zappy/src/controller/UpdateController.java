package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Adminbean;
import model.AdminDao;

/**
 * Servlet implementation class Update1
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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

		String pid=request.getParameter("pid");
		
		AdminDao ad=new AdminDao();
		 ArrayList<Adminbean>list=ad.UpdateProduct(pid);

		 for(Adminbean ab:list){
			 
				System.out.println("image name at Controller"+ab.getImage());

		 }
		 
		  RequestDispatcher rd=request.getRequestDispatcher("UpdateProduct.jsp");
		  request.setAttribute("LIST", list);
		  rd.forward(request, response);
	}
}
