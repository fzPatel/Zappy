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
 * Servlet implementation class ZappyProducts
 */
@WebServlet("/ZappyProductsController")
public class ZappyProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZappyProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminDao ad=new AdminDao();
		ArrayList<Adminbean>list=ad.ViewProducts();	
		RequestDispatcher rd=request.getRequestDispatcher("ZappyProducts.jsp");
		  request.setAttribute("LIST", list);

		  rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	}