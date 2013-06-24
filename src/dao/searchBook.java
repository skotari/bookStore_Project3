package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

public class searchBook {
	
 	private Connection connect = null;
private Statement statement = null;
private ResultSet resultSet = null;

 
public List<Book> search(String author_firstname,String author_lastname)
		 {
    List<Book> list = new ArrayList<Book>();
    System.out.println("here1"+author_firstname+" "+author_lastname);

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
	        if(author_firstname.isEmpty())
	        {
	        	if(!author_lastname.isEmpty())
	        	{
	        		 resultSet = statement.executeQuery("select * from books where" +
	        		 		" author_lastname='" + author_lastname+"'");
	 		        
	        		
	        	}
	        }
	       
	        else
	        {
	        	if(author_lastname.isEmpty())
	        	{
	        		 resultSet = statement.executeQuery("select * from books where " +
	 		        		" author_firstname='"+ author_firstname+"'");
	 	
	        		System.out.println(resultSet+"herenlhbnlln");
	        	}
	        	else
	        	{

	        		 resultSet = statement.executeQuery("select * from books where " +
	 		        		" author_firstname='" + author_firstname+
	 		        		"' and author_lastname='"+author_lastname+"'");
	        	}
	        	
	        }
	        while(resultSet.next())
        	{
        	list.add(processRow(resultSet));
        	}
	 

    } catch (Exception e) {
        System.out.println(e);
      } finally {
            close();
        }
    System.out.println(list);
    return list;

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

protected Book processRow(ResultSet rs) throws SQLException {
    Book book = new Book();
    book.setId(rs.getString("id"));
    book.setAuthor_firstname(rs.getString("author_firstname"));
    book.setAuthor_lastname(rs.getString("author_lastname"));
    book.setBook_name(rs.getString("book_name"));
    book.setISBN(rs.getString("isbn"));
    book.setPrice(rs.getDouble("price"));
    return book;
}
}
