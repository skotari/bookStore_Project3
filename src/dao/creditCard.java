package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class creditCard {
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null,resultSet1=null;
	String status;
	 
    public String processCreditCard(String first_name, String last_name, String accno,double price)
    		{
        try {
                // This will load the driver, each DB has its own driver
		        Class.forName("org.postgresql.Driver");
		        
        		// Setup the connection with the DB
        		//jdbc:postgresql://host:port/database
		        String url = "jdbc:postgresql://localhost:5432/";
		        String username = "postgres";
		        String password = "priyanka";
		        //Connection connect = DriverManager.getConnection(url, username, password);
		        
		        connect = DriverManager.getConnection(url, username, password);

		        // Statements allow to issue SQL queries to the database
		        statement = connect.createStatement();
		        
		        // Result set get the result of the SQL query
		        resultSet = statement.executeQuery("select * from accounts where" +
		        		 		" bankaccno='" + accno+"'");
		        if(resultSet.next())
		        {
		 		if(resultSet.getString(2).equals(first_name)&&
		 				resultSet.getString(3).equals(last_name))
		 		{
		 			
		 			if(resultSet.getDouble(6)>price)
		 			{
		 			  int rows = statement.executeUpdate("update accounts set balance=" +
		 			   		"balance-" +price+" where bankaccno='" + accno+"'");
		 			  if(rows==1)
		 				  status="Authorized and successful";
		 			  else
		 				  status="Unsuccessful!! Please try again!!";
		 			  
		 			}
		 			else
		 			{
		 			status="Insufficient balance";
		 			}
		 		}
		 		else
		 		{
		 		status="Incorrect username";
		 		}
		        }
		        else
		        {
		 		status="Incorrect and Password";
		        }

		 	
		 	
		      
	
        } catch (Exception e) {
            System.out.println(e);
          } finally {
                close();
            }
    	return status;

	}///////////////////////////////

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
		statement.close();
            }

            if (connect != null) {
		connect.close();
            }
	} catch (Exception e) {
          }
    }/////////////////////

}
