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
import model.PActionDao;

/**
 * Servlet implementation class viewproductdescription
 */
@WebServlet("/viewproductdescription")
public class viewproductdescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewproductdescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		System.out.println(request.getParameter("pid"));

		int pid=Integer.parseInt(request.getParameter("pid"));
			
			PActionDao pd=new PActionDao();
			System.out.println(pid);
			
			ArrayList<Adminbean> list=pd.viewProductDescription(pid);
			RequestDispatcher rd=request.getRequestDispatcher("viewProductDescription.jsp");
			request.setAttribute("productDescription",list);
			rd.forward(request, response);
			
		
	
		
	}

}
