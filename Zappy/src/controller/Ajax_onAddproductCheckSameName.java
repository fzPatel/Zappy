package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDao;
/**
 * Servlet implementation class Ajax_onAddproductCheckSameName
 */
@WebServlet("/Ajax_onAddproductCheckSameName")
public class Ajax_onAddproductCheckSameName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax_onAddproductCheckSameName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pname=request.getParameter("pname"); 
//		String pid=request.getParameter("pid"); 
		
		AdminDao ad=new AdminDao();
	
		
		int z=ad.fatchName(pname);
		System.out.println("inside Ajax servlet");

		if(z!=0) 
		{
			
			System.out.println("already exist");
			
			
			PrintWriter out=response.getWriter();
			out.println("Product already exist");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 	String pname=request.getParameter("pname");
		 
			AdminDao ad=new AdminDao();
			int y=ad.fatchName(pname);
			
			System.out.println("inside Ajax servlet");
			
			if(y!=0) 
			{
		
				PrintWriter out=response.getWriter();
				out.println("Product already exist");
					
				}
			
			
	}

}
