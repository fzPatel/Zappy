package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PActionDao;

/**
 * Servlet implementation class PActionController
 */
@WebServlet("/PActionController")
public class PActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PActionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid=request.getParameter("pid");
		String btn=request.getParameter("xyz");

		PActionDao pd=new PActionDao();
		if(btn.equals("Update"))
	{
			RequestDispatcher rd=request.getRequestDispatcher("UpdateController");
			request.setAttribute("msg",pid);
		rd.forward(request, response);
	
		}
		else if (btn.equals("Delete")) {
			
			System.out.println(pid);
			
			int z=pd.delete(pid);
			if(z==1)
				
		   {
					RequestDispatcher rd=request.getRequestDispatcher("ViewProductContoller");
		  	    	request.setAttribute("delete","Product succuessfully Deleted");
		  	    	rd.include(request,response);
		  	    }
			
		}
	}

}
