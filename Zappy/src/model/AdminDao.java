package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Adminbean;
import bean.Customer;
import connection.Dbconnection;
public class AdminDao {
		Connection con; 
		PreparedStatement ps;
		Dbconnection d=new Dbconnection(); //Dbconnection is a connection class present in connection package
	public AdminDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	//---------------------admin login Check------------------//

	
	
	
public int logincheck(String u,String p)
{
int x=0;
try {	
	
con=d.start(); ///d is a refrence of Dbconnection class and start method and Dbconnection class present inside connection package 
ps=con.prepareStatement("select * from adminlogin where userid=? and pwd=?");
ps.setString(1, u);             //set userid and password in set string method
ps.setString(2, p);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
x=1;              //next method will check till the password  gets correct if not then this will terminate
}
} catch (Exception e) {
System.out.println(e);
}
return x;
}
//---------------------admin viw all product------------------//


public ArrayList<Adminbean> ViewProducts()

{
	ArrayList<Adminbean> list=new ArrayList<>();     //creating object of Generic arraylist 
	try {	
		con=d.start();
			ps=con.prepareStatement("select * from product");
		ResultSet rs= ps.executeQuery();
		
	while(rs.next())
{
		Adminbean e=new Adminbean();
		e.setPid(rs.getInt("id"));
		e.setPname(rs.getString("pname"));
		e.setPrice(rs.getDouble("price"));
		e.setWeight(rs.getString("weight"));
		e.setDetails(rs.getString("details"));
		e.setImage(rs.getString("image"));
		list.add(e);
}
	con.close();
	
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
		}
	return list;
	}



public ArrayList<Adminbean> viewCartBox()

{
	
	int quantity=0;
	double cal=0.0; 
	double price;
	ArrayList<Adminbean> list=new ArrayList<>();     //creating object of Generic arraylist 
	try {	
		con=d.start();
			ps=con.prepareStatement("select * from cart");
		ResultSet rs= ps.executeQuery();
		
	while(rs.next())
{
		Adminbean e=new Adminbean();
		
		e.setPrice(rs.getDouble("price"));
		e.setQnty(rs.getString("pqntity"));
		
				
		
		quantity=Integer.parseInt(rs.getString("pqntity"));
		price=rs.getDouble("pqntity");

		cal=price*quantity;

		
}
	
	System.out.println("Quantity"+quantity);
	System.out.println("total Price"+cal);
	
	con.close();
	
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
		}
	return list;
	}



// Ajax ---Check product Name if already exist alert-----------

public int fatchName(String pname) 
{
int y=0;
	try {
		con=d.start();
		ps=con.prepareStatement("select pname from product where pname=?");
		ps.setString(1,pname);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{	
			y=1;	
		}
		} catch (Exception e) {
		
		System.out.println(e);
		}
	
	return y;
	}


//---------------------admin update product------------------//



public ArrayList<Adminbean> UpdateProduct(String pid)

{
	ArrayList<Adminbean> list=new ArrayList<>();
	try {	

		con=d.start();
	    ps=con.prepareStatement("select * from product where id=?");
	    ps.setString(1, pid);
	    
	    ResultSet rs= ps.executeQuery();
	while(rs.next())
{
		Adminbean e=new Adminbean();
		e.setPid(rs.getInt("id"));
		e.setPname(rs.getString("pname"));
		e.setPrice(rs.getDouble("price"));
		e.setWeight(rs.getString("weight"));
		e.setDetails(rs.getString("details"));
		e.setImage(rs.getString("image"));
	System.out.println("image name at dao"+e.getImage());
		list.add(e);
}
	con.close();
	
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
		}
	return list;
	}

////-----------------orrder list--------------


public ArrayList<Adminbean>orderHistory()
{
	ArrayList<Adminbean> list=new ArrayList<>();

	try {	
		con=d.start();
		
	   ps=con.prepareStatement("select * from order_table");
	  
	   ResultSet rs= ps.executeQuery();
		
	while(rs.next())

	{
		
		Adminbean e=new Adminbean();
		e.setPid(rs.getInt("pid"));
		e.setQnty(rs.getString("pqntity"));
		e.setIpAddress(rs.getString("ipadr"));
		e.setPrice(rs.getDouble("price"));
		e.setPname(rs.getString("product_name"));
		e.setImage(rs.getString("product_image"));			
		e.setDate(rs.getString("order_date"));
		e.setStatus(rs.getString("status"));
		e.setCustomerId(rs.getString("customerId"));
		
		
		list.add(e);
}
	con.close();
	
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
		}
	return list;
	}
////-----------------admin dispatched order--------------


public int dispatchorder(int orderid,String customerid)
{
	
	int y=0;
	try {			
		con=d.start();
		 ps=con.prepareStatement("UPDATE order_table SET status =? where orderid=? and customerId=?");
		ps.setString(1,"Dispatched");
		ps.setInt(2, orderid);
		ps.setString(3,customerid);
		
	    y=ps.executeUpdate();
  }catch(Exception e)
  {
	  System.out.println(e);
  }
	return y;
  
	}

////-----------------admin Not Available oder--------------
public int cancelOrder(int orderid,String Customerid)
{
	int y=0;
	try {
		con=d.start();
		ps=con.prepareStatement("Update order_table set status =? where orderid=? and customerId=?");
		ps.setString(1, "Not available");
		ps.setInt(2, orderid);
		ps.setString(3,Customerid);
		
	y=	ps.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	return y;
	}


//---------------------admin view todays order------------------//


public ArrayList<Adminbean> AdminViewPendingforDispachList()
{
	ArrayList<Adminbean> list=new ArrayList<>();
	try {
		con=d.start();
		ps=con.prepareStatement("select * from order_table where status=?");
		ps.setString(1, "Ordered");
	  
		ResultSet rs=ps.executeQuery();
	    
	    while(rs.next())
	    {
	    	Adminbean e=new Adminbean();
	    	e.setPid(rs.getInt("pid"));
			e.setQnty(rs.getString("pqntity"));
			e.setIpAddress(rs.getString("ipadr"));
			e.setPrice(rs.getDouble("price"));
			e.setPname(rs.getString("product_name"));
			e.setImage(rs.getString("product_image"));
			e.setWeight(rs.getString("product_weight"));
			e.setDate(rs.getString("order_date"));
			e.setStatus(rs.getString("status"));
			e.setCustomerId(rs.getString("customerId"));
			e.setOrderid(rs.getInt("orderid"));
			
   	list.add(e);
   	}
	    }catch(Exception e)
  {
	  System.out.println(e);
  }
	return list;
  
	}

//---------------------admin change pw------------------//
public int adminPwdChange(String u,String p)
{
	int y=0;
	try {
	
		System.out.println(u);
	
		System.out.println(p);
	
		con=d.start();
	ps=con.prepareStatement("Update adminlogin set pwd =? where userid=?");
		ps.setString(1, p);
		ps.setString(2, u);
	y=ps.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return y;
}


//---------------------admin conform old pwd------------------//
public int adminOldpwd(String u ,String oldp)
{int x=0;
try {
	
		System.out.println("userID admin conform old pwd "+u);
	System.out.println("admin conform old pwd"+ oldp);
	
		con=d.start();
	ps=con.prepareStatement("select * from adminlogin where userid=? and pwd=?");
		ps.setString(1, u);
		ps.setString(2, oldp);
		
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
			x=1;
	}	

	} catch (Exception e) {
		System.out.println(e);
	}
	return x;
}




public ArrayList<Customer> admin_ViewAllCustomer()
{
	ArrayList<Customer> list=new ArrayList<Customer>();
	con=d.start();
	try {
		ps=con.prepareStatement("Select * from customer_register");
	
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		Customer ab=new Customer();
		ab.setCname(rs.getString("customer_name"));
		ab.setMobile(rs.getString("customer_mobile"));
		ab.setEmail(rs.getString("customer_email"));
		ab.setAddress(rs.getString("customer_address"));
		ab.setCity(rs.getString("customer_city"));
		ab.setState(rs.getString("customer_state"));
		
		list.add(ab);
	}
	}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return list;
	
}

public int RemoveCustomer(String mobile)
{
	int x = 0;
con=d.start();

try {
	ps=con.prepareStatement("delete from customer_register where customer_mobile=?");
	ps.setString(1, mobile);
	x=ps.executeUpdate();
	
} catch (SQLException e) {
	System.out.println(e);
	e.printStackTrace();
}

return x;
}

////-----------------customer cancel oder--------------
public int customcancelOrder(int pid)
{
int y=0;
try {
	con=d.start();
	ps=con.prepareStatement("Update order_table set status =? where pid=?");
	ps.setString(1, "cancel");
	ps.setInt(2, pid);
	y=ps.executeUpdate();
	
} catch (Exception e) {
	System.out.println(e);
}
return y;
}




public int orderhistory(int pid,String customerid,Adminbean e)
{
	
	int x,y=0,z=0;
	try {			
		con=d.start();
		
		 System.out.println(e.getQnty());
		ps=con.prepareStatement("insert into order_history(pid,pqntity,ipadr,price,product_name,product_image,product_weight,order_date,status,customerId) values(?,?,?,?,?,?,?,?,?,?)");
		 	ps.setInt(1,e.getPid());
	  	    ps.setString(2,	e.getQnty());
	  	    ps.setString(3,	e.getIpAddress());
	  	    ps.setDouble(4,	e.getPrice());
		    ps.setString(5,	e.getPname());
		    ps.setString(6,	e.getImage());
		    ps.setString(7, e.getWeight());
		    ps.setString(8,	e.getDate());
		    ps.setString(9,	"Ordered");
		    ps.setString(10,customerid);
		
		    x=1;
//		PreparedStatement ps2=con.prepareStatement("delete from order_table where pid=? and ipadr=?");
//		ps2.setInt(1,e.getPid());
//		ps2.setString(2,e.getIpAddress());
//		con.setAutoCommit(false);
//		x=ps.executeUpdate();
//		y=ps2.executeUpdate();
//		con.commit();
		
		
		if(x!=0 && y!=0)
		{
			z=1;

		}
		
		
  }catch(Exception ee)
  {
	  System.out.println(ee);	
	  ee.printStackTrace();
  }
	return z;
  
	}



//Admin Check product with name in the table for duplicate entry------------

public int checkproductDuplicateEntry(String pname) 
{
	int x=0;
	
	try {
		con=d.start();
		ps=con.prepareStatement("select pname from product where pname=?");
		ps.setString(1,pname);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
	x=1;			
		}
		
	}catch (Exception e) {
		System.out.println(e);
	}
	

	return x;
}




}
