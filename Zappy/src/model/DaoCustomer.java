package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import bean.Customer;
import connection.Dbconnection;
import java.sql.Connection;

public class DaoCustomer {

	
	 Connection con;
	 PreparedStatement ps;;
		Dbconnection d=new Dbconnection();//Dbconnection is a connection class present in connection package

	public int check(String mobile,String Cpwd)//customer login check---------
	{
	int x=0;
	try {
		
		con=d.start();     //connection stablished------------
	 ps=con.prepareStatement("select * from customer_register where customer_mobile=? and customer_pwd=?");
	ps.setString(1, mobile);
	ps.setString(2, Cpwd);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
	x=1;
	}
	} catch (Exception e) {
	System.out.println(e);
	}
	return x;
	}

	
	
	
	
	
	

	// Ajax ---Check customer Mobile if already exist alert-----------

	public int fatchMobile(String mobile) 
	{
	int y=0;
		try {
			con=d.start();
			ps=con.prepareStatement("select customer_mobile from customer_register where customer_mobile=?");
			ps.setString(1,mobile);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				y=1;	
			}
			} catch (Exception e) {
			
			System.out.println(e);
		System.out.println(y);
			}
		
		return y;
		}

	
	
	
	
	
	
	
	
	
public int registration(Customer c){           // customer registration method
	 int y=0;
	 
	try {		
		con=d.start();
		ps=con.prepareStatement("insert into customer_register(customer_name,customer_mobile,customer_email,customer_address,customer_city,customer_state,customer_pwd) value(?,?,?,?,?,?,?)");//placeholder
  	  
		ps.setString(1,c.getCname());
  	    ps.setString(2,c.getMobile());
  	    ps.setString(3,c.getEmail());
  	  ps.setString(4,c.getAddress());
  	ps.setString(5,c.getCity());
  	ps.setString(6,c.getState());
  	ps.setString(7, c.getCpwd());
  y=ps.executeUpdate();
 
 String mobile=c.getMobile();
 String email= c.getEmail();
 String pwd= c.getCpwd();
  
  if(y!=0)
  {
	 sendMail(email, pwd, mobile);////------mail send to perticular customer---------
  }
  
 }
  catch(Exception e)
    {
    	
  	  System.out.println(e);
    }
 
	return y;
}

public ArrayList<Customer> ViewCustomDetails(String mobile) //Customer Details code

{
	ArrayList<Customer> list=new ArrayList<>();        ////creating object of Generic arraylist 

	try {
		con=d.start();
		ps=con.prepareStatement("select * from customer_register where customer_mobile=?");
		ps.setString(1, mobile);
	    ResultSet rs= ps.executeQuery();
		
	while(rs.next())
{
		Customer c=new Customer();
		c.setCname(rs.getString("customer_name"));
		c.setMobile(rs.getString("customer_mobile"));
		c.setEmail(rs.getString("customer_email"));
		c.setAddress(rs.getString("customer_address"));
		c.setCity(rs.getString("customer_city"));
		c.setState(rs.getString("customer_state"));
		c.setCpwd(rs.getString("customer_pwd"));
		
		list.add(c);
}
	con.close();
	
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
		}
	return list;
	}



public void sendMail(String email,String pwd, String mobile )
{
	String to = email;
      String sub="Zappy Food Registraion Account Creation";
      
      
//      String msg="Welcome at out site and your user id="+userid1+", password="+password1+", designation="+designation1;
      // Sender's email ID needs to be mentioned
      String msg="Welcome at our site and your user id="+mobile+", password="+pwd+", Email="+email+" ";
      String from = "firozpatel@gmail.com";
      final String username = "firozpatel3210@gmail.com";//change accordingly
      final String password ="Camelion@fz@007@123";//change accordingly
     // final String designation=designation1;

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject(sub);

         // Now set the actual message
         message.setText(msg);

         // Send message
         
         Transport.send(message);
        System.out.println("Sent message successfully....");
         } catch (MessagingException e) {
    	  e.printStackTrace();
    	     }

}

//Update Customer /////////////////////

public int updateCustomer(Customer c){
	 int y=0;
	 
	try {		
		con=d.start();
		ps=con.prepareStatement("update customer_register set customer_name = ?,customer_mobile = ?,customer_email = ?,customer_address = ?,customer_city = ?,customer_state = ?,customer_pwd = ? where customer_mobile = ?");//placeholder
  	  	ps.setString(1,c.getCname());
  	    ps.setString(2,c.getMobile());
  	    ps.setString(3,c.getEmail());
  	    ps.setString(4,c.getAddress());
	  	ps.setString(5,c.getCity());
	  	ps.setString(6,c.getState());
	  	ps.setString(7, c.getCpwd());
		ps.setString(8,c.getMobile());
		y=ps.executeUpdate();
 

 String mobile=c.getMobile(); 
 String email= c.getEmail();
 String pwd= c.getCpwd();
  
  if(y!=0)
  {
	 sendMail(email, pwd, mobile);
  }
  
 }
    catch(Exception e)
    {
    	
  	  System.out.println(e);
    }
 
	return y;
}

//
//public int insertsessionIntoCart(String session,String ipAddress){
//	 int y=0;
//	 try {
//		 
//		 System.out.println(session);
//		 System.out.println(ipAddress);
//			
//		con=d.start();
//		ps=con.prepareStatement("update cart set customerId = ? where ipadr = ?");//placeholder
//  	  
//		ps.setString(1,session);
//  	    ps.setString(2,ipAddress);
//  	    y=ps.executeUpdate();
//  	  
//	 
//	   
// 
//if(y==1)
//{
//System.out.println("execute");	
//}	 }
//	 
//    catch(Exception e)
//    {
//    	
//  	  System.out.println(e);
//    }
// 
//	return y;
//}

//
//public int customerActivationLink(){
//	 int y=0;
//	 
//	try {		
//		con=d.start();
//		ps=con.prepareStatement("update customer_register set customer_status = ? where customer_mobile = ?");//placeholder
//		ps.setString(1,"Activate");
//  	    y=ps.executeUpdate();
//  
//  if(y!=0)
//  {
//
//  }
//  
// }
//    catch(Exception e)
//    {
//    	
//  	  System.out.println(e);
//    }
// 
//	return y;
//}
//
//





}