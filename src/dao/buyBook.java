package dao;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class buyBook {
	
	private Connection connect = null;
    private Statement statement = null;
    private Statement statement1 = null;

    private ResultSet resultSet = null,resultSet1=null;
	 
	 
    public String processPayment(String ISBN,String ID) 
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
		        statement1 = connect.createStatement();

		        
		        // Result set get the result of the SQL query
		       
		 		        
		        resultSet1 = statement.executeQuery("select * from customer where " +
		 		        		" ID='"+ ID+"'");
		        if(resultSet1.next())
		        {
		        resultSet = statement1.executeQuery("select price from books where" +
		        		 		" isbn='" + ISBN+"'");
		        if(resultSet.next())
		        {
		        	System.out.println(resultSet1.getString("first_name"));
		        	creditCard cre=new creditCard();
		        	String requestquery = "http://localhost:8080/bookStore_Project3";
					ClientConfig config = new DefaultClientConfig();
				    Client client = Client.create(config);
				    WebResource service = client.resource(getBaseURI(requestquery));

				    String output=service.path("rest2").path("creditCard").
				    		queryParam("fName", resultSet1.getString("first_name")).
				    		queryParam("lName", resultSet1.getString("last_name")).
				    		queryParam("accno", resultSet1.getString("bankaccno")).
				    		queryParam("price", Double.toString(resultSet.getDouble("price"))).
				    		accept(MediaType.TEXT_PLAIN).get(String.class);
		        		       
				return output;
		        }
		        else
		        {
		        	return "Book ID doesn't exist!!!";
		        }
		        }
		        else
		        {
		        	return "Customer ID doesn't exist!!";
		        }
		      
	
        } catch (Exception e) {
    		e.printStackTrace();
    		return "Error";
          } finally {
                close();
            }

	}
    
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

private static URI getBaseURI(String uri) {
    return UriBuilder.fromUri(uri).build();
  }
}
