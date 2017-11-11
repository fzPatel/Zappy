package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDao;

/**
 * Servlet implementation class AdminChangePwdServlet
 */
@WebServlet("/AdminChangePwdServlet")
public class AdminChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession ss=request.getSession();
String u=(String)ss.getAttribute("session");

String oldp=request.getParameter("oldpassword");

String p=request.getParameter("password");

System.out.println("Userid"+u);
System.out.println("New ========"+p);
System.out.println("Old pwd====="+oldp);
		AdminDao ad=new AdminDao();
		
		int x=ad.adminOldpwd(u,oldp);

System.out.println("x======" +x);


System.out.println("inside Ajax servlet where x" +x);
PrintWriter out=response.getWriter();

out.println(x);

/*
if(x==0)

{
	PrintWriter out=response.getWriter();
	
}
if(x!=1) {
	
	System.out.println("x======" +x);

	
	
	doPost(request, response);
*/
}
//
//else if((oldpwd.equals(oldp))) {
//	
//int x=ad.adminPwdChange(u,p);	
//	if(x!=0) {
//		
//request.setAttribute("ChnagepwdMsgSucces","Password Changed successfully");
//rd.include(request, response);
//
//	}
//}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession ss=request.getSession();
String u=(String)ss.getAttribute("session");

String oldp=request.getParameter("oldpassword");
String p=request.getParameter("password");

System.out.println("Userid"+u);
System.out.println("New ========"+p);
System.out.println("Old pwd====="+oldp);


AdminDao ad=new AdminDao();
int x=ad.adminOldpwd(u,oldp);

RequestDispatcher rd=request.getRequestDispatcher("AdminChangePwd.jsp");

//
//	if(!oldpwd.equals(oldp))
//{
//	PrintWriter out=response.getWriter();
//	out.println("Old Password does Not match");
//
//}

if(x!=0)
{
	
int y=ad.adminPwdChange(u,p);	
System.out.println("result in admin change pwd="+y);

if(y!=0) {
		
request.setAttribute("ChnagepwdMsgSucces","Password Changed successfully");
rd.include(request, response);

	}
}
}
	

}