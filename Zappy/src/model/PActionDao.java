package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Adminbean;
import connection.Dbconnection;
public class PActionDao {
	
	
	 Connection con;
	 PreparedStatement ps;;
		Dbconnection d=new Dbconnection();//Dbconnection is a connection class present in connection package
		
 public PActionDao() {
		// TODO Auto-generated constructor stub
	}
 public int delete(String pid){ 			//delete Product --///////
 
int x=0;		
	
try {

	 con=d.start();
	ps=con.prepareStatement("delete from product where id=?");
	ps.setString(1, pid);
 x=ps.executeUpdate();
	  }
	  catch (SQLException e) {
		  System.out.println(e);
		  e.printStackTrace();
	}
		return x;
}
 
 
public int addcart(Adminbean e,String CustomerId)             //---------add to cart method------
{
	int x=0,z=0;
	try {	
		con=d.start();
		ps=con.prepareStatement("insert into cart(pid,pqntity,ipadr,price,product_weight, product_name,product_image,order_date,customerId) value(?,?,?,?,?,?,?,?,?)");//placeholder
  	    ps.setInt(1,e.getPid());
  	    ps.setString(2,e.getQnty());
  	    ps.setString(3,e.getIpAddress());
  	    ps.setDouble(4,e.getPrice());
  	    ps.setString(5,e.getWeight());
	    ps.setString(6,e.getPname());
	    ps.setString(7,e.getImage());
	    ps.setString(8,e.getDate());
	    ps.setString(9, CustomerId);
	 
	    x=ps.executeUpdate();
  	   if(x!=0)
  	   {
  		   z=1;
  		   
  	   }
    }catch(Exception ex)
    {
    	System.out.println(ex);
		  ex.printStackTrace();
   
    }
	return z;
     }


//--------show cart code---------
public ArrayList<Adminbean> showcart(String ipAddress ,String session) 
{
	
	ArrayList<Adminbean> list=new ArrayList<>();

	try {	

		 con=d.start();
		 
 if(session==null) 
 {
	 	ps=con.prepareStatement("select * from cart where ipadr=?");
	    ps.setString(1, ipAddress);
	//   ps.setString(2,CusomerID);
	    }
else if(session!=null)
		 {
	  	  	ps=con.prepareStatement("select * from cart where ipadr=?");
		    ps.setString(1,ipAddress);
	    
	    }
	    ResultSet rs= ps.executeQuery();
		
	while(rs.next())
	{
		Adminbean e=new Adminbean();
		e.setPid(rs.getInt("pid"));
		e.setQnty(rs.getString("pqntity"));
		e.setIpAddress(rs.getString("ipadr"));
		e.setPrice(rs.getDouble("price"));
		e.setWeight(rs.getString("product_weight"));
		e.setPname(rs.getString("product_name"));
		e.setImage(rs.getString("product_image"));			
		e.setDate(rs.getString("order_date"));
		e.setStatus(rs.getString("status"));
		e.setCartid(rs.getInt("cartid"));
		list.add(e);
}
	con.close();
	
		  }catch(SQLException  ex)
		{
			  System.out.println(ex);
			  ex.printStackTrace();
		}
	return list;
	}


// ---------view cart-------------para method contains ip address and session of perticulart id 
public ArrayList<Adminbean> Viewcart(String ipAddress,String session)
{
	ArrayList<Adminbean> list=new ArrayList<>();

	try {	

		 con=d.start();
	  ps=con.prepareStatement("select * from order_table where ipadr=? and customerId=? and status=?");
	    ps.setString(1, ipAddress);
	    ps.setString(2,session);
	    ps.setString(3,"Dispatched");
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
		list.add(e);
}
	con.close();
	
		  }catch(SQLException  ex)
		{
			  System.out.println(ex);
			  ex.printStackTrace();
		}
	return list;
	}


//-----------remove cart code----------

public int removeCart(int cartid,String session,String ipAddress){
	 
int x=0;		
	
try {
	con=d.start();
	
	
	if(session==null) {
		
		System.out.println("Inside model removeCart session null hai so ip se remove krwa rahe hai "+ipAddress);
		
		
	ps=con.prepareStatement("delete from cart where cartid=? and ipadr=?");
ps.setInt(1, cartid);
ps.setString(2, ipAddress);
	}
	else if(session!=null) 
		
	{
		System.out.println("Inside model removeCart session null  nahi * hai so session se remove krwa rahe hai "+session);

		ps=con.prepareStatement("delete from cart where cartid=? and customerId=?");
		ps.setInt(1, cartid);
		ps.setString(2, session);
		
	}
 x=ps.executeUpdate();
	  }
	  catch (SQLException e) {
		  System.out.println(e);
		  e.printStackTrace();
	}
		return x;
}


//---------view customer pending list--------------

public ArrayList<Adminbean> viewCustomerPendinglist(String session)

{
	ArrayList<Adminbean> list=new ArrayList<Adminbean>();
	
	con=d.start();
	
	try {
	ps=con.prepareStatement("select * from cart where status=? and customerId=?");
ps.setString(1,"pending");
ps.setString(2, session);
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
		e.setDate(rs.getString("order_date"));
		e.setStatus(rs.getString("status"));
		e.setCartid(rs.getInt("cartid"));
		e.setWeight(rs.getString("product_weight"));
		list.add(e);
	
	}	}
	
	
	catch (Exception e) {
		System.out.println(e);
		  e.printStackTrace();
	}
	
	return list;
	
}


public int orderproduct(int cartid,String customerid,Adminbean e)
{
	
	int x,y=0,z=0;
	try {			
		con=d.start();
		
		 System.out.println(e.getQnty());
		ps=con.prepareStatement("insert into order_table(pid,pqntity,ipadr,price,product_name,product_image,product_weight,order_date,status,customerId) values(?,?,?,?,?,?,?,?,?,?)");
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
		
		PreparedStatement ps2=con.prepareStatement("delete from cart where cartid=? and customerId=?");
		ps2.setInt(1,cartid);
		ps2.setString(2,customerid);
		
		con.setAutoCommit(false);
		
		x=ps.executeUpdate();
		y=ps2.executeUpdate();
		
		con.commit();
		
		
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


public ArrayList<Adminbean> viewCustomer_order_status(String session,String ipAddress)

{
	System.out.println(session);
	System.out.println(ipAddress);	
	
	ArrayList<Adminbean> list=new ArrayList<Adminbean>();
	
	con=d.start();
	
	try {
	ps=con.prepareStatement("select * from order_table where ipadr=? and customerId=?");
	ps.setString(1,ipAddress);
	ps.setString(2,session);

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
		e.setDate(rs.getString("order_date"));
		e.setStatus(rs.getString("status"));
	
		list.add(e);
		
	
	}	}
	
	
	catch (Exception e) {
		System.out.println(e);
		  e.printStackTrace();
	}
	
	
	
	return list;

	
	}



public ArrayList<Adminbean> viewProductDescription(int pid)
{
	ArrayList<Adminbean> list=new ArrayList<Adminbean>();
	con=d.start();
	try{
	ps=con.prepareStatement("select * from product where id=?");
	ps.setInt(1, pid);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		Adminbean ab=new Adminbean();
		ab.setPid(rs.getInt("id"));
		ab.setPname(rs.getString("pname"));
		ab.setPrice(rs.getDouble("price"));
		ab.setWeight(rs.getString("weight"));
		ab.setDetails(rs.getString("details"));
		ab.setImage(rs.getString("image"));
		list.add(ab);
		
	}
	}catch (Exception e) {
		
		System.out.println(e);
		e.printStackTrace();
	}
	
	
return list;	
}



public int updateCartQuantity(String pquantity,int cartid,String ipAddress,String customerId) 
{
	int x=0;
try {
	con=d.start();
	
if(customerId==null) 
{
	ps=con.prepareStatement("Update cart set pqntity=? where cartid=? and ipadr=?");
	ps.setString(1,pquantity);
	ps.setInt(2,cartid);
	ps.setString(3,ipAddress);
}
else if(customerId!=null) 
{
	ps=con.prepareStatement("Update cart set pqntity=? where cartid=? and customerId=?");
	ps.setString(1,pquantity);
	ps.setInt(2,cartid);
	ps.setString(3,customerId);
}
	
	
	x=ps.executeUpdate();
	
} catch (Exception e) {
	// TODO: handle exception
}
	return x;
	
}


public int checkSameidForUpend(String pid,String qnty,String ipAddress) 
{
	int x=0;
	int insidePquantity = 0;
	try {
		con=d.start();
		ps=con.prepareStatement("select * from cart where pid=? and ipadr=?");
		ps.setString(1,pid);
		ps.setString(2,ipAddress);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
	{
			
			x=1;
			
		insidePquantity=Integer.parseInt(rs.getString("pqntity"));
		
		insidePquantity=insidePquantity + Integer.parseInt(qnty);
}
		
		if(x!=0) 
		{
			
			updatecartIfExist(pid,insidePquantity,ipAddress);
		}
	
		System.out.println("x in dao"+x);
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return x;
	}


public int updatecartIfExist(String pid,int insidePquantity,String ipAddress)
{
	
int x=0;
	try {
	con=d.start();
	
	System.out.println("data in dao");
	System.out.println(insidePquantity);
	System.out.println(pid);
	
	ps=con.prepareStatement("Update cart set pqntity=? where pid=? and ipadr=?");
	ps.setInt(1,insidePquantity);
	ps.setString(2,pid);
	ps.setString(3,ipAddress);
	x=ps.executeUpdate();
	
	System.out.println("Updated cart"+x);
	
	
} catch (Exception e) {
	
	System.out.println(e);
}
return x;
}


public int updateIpToCustomerID(String session,String ipAddress)
{
	
	int x=0;
	
	try {
	con=d.start();
	
	System.out.println("data in dao");
	System.out.println(session);
	System.out.println(ipAddress);
	
	ps=con.prepareStatement("Update cart set ipadr=? where ipadr=?");
	ps.setString(1,session);
	ps.setString(2,ipAddress);
	
	x=ps.executeUpdate();
	
	System.out.println("Updated Ip to Session"+x);
	
	
} catch (Exception e) {
	
	System.out.println(e);
}
return x;
}

public int insertSession(String mobile,String ipAddress)
{
	
	int x=0;
	
	try {
	con=d.start();
	
	System.out.println("data in dao");
	System.out.println(mobile);
	System.out.println(ipAddress);
	
	ps=con.prepareStatement("Update cart set customerId=? where ipadr=?");
	ps.setString(1,mobile);
	ps.setString(2,ipAddress);
	
	x=ps.executeUpdate();
	
	System.out.println("insert Session on checkout "+x);
	
	
} catch (Exception e) {
	
	System.out.println(e);
}
return x;
}





}
