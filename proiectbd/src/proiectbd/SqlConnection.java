package proiectbd;

import java.sql.*;

import javax.swing.JOptionPane;

public class SqlConnection {
static Connection conn;
public static int k=0;
public static Connection dbConnector(int i) {
	 try 
	 {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firma2", "root", ""); 
	    String user1="admin";
	    String pass1="12345";
	
	    if(i==1) 
	    {
	    if(user1.equals(Login.user.getText())&&pass1.equals(Login.pass.getText())) {
	    	JOptionPane.showMessageDialog(null, "Login Sucessfuly...");
	        k=1;
	    	return conn;
	   
	    }
	    else
        {
	    	JOptionPane.showMessageDialog(null, "Incorrect username or password...");
			 k=0;
	    }
	    }
	    if(i==0) {
	    	k=1;
	    	 return conn;	
	    }
	    
	   return conn;
	 }
	 catch (Exception ex)
	 {
		 System.out.println(ex);
		 return null;
	 }
	
}
}
