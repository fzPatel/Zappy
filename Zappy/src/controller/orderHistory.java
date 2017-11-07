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
 * Servlet implementation class OrderList
 */
@WebServlet("/orderHistory")
public class orderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao ad=new AdminDao();
	      
	      ArrayList<Adminbean>orderlist=ad.orderHistory();
   
	      RequestDispatcher rd=request.getRequestDispatcher("OderHistory.jsp");
	  		request.setAttribute("orderHistory",orderlist);
	  		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		  		
		  		

}}
