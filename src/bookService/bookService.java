package bookService;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;

import com.sun.rowset.CachedRowSetImpl;

import dao.Book;
import dao.searchBook;


@Path("/buyBook")

public class bookService {

		searchBook dao=new searchBook();
		dao.buyBook dao1=new dao.buyBook();
		
	    @GET 
    @Produces(MediaType.TEXT_PLAIN)
    public String buyBook(@QueryParam("isbn") String isbn,
    		@QueryParam("custID") String custID) {
	    	return dao1.processPayment(isbn, custID);
	    	
    }
		    
//		    @POST 
//		    @Path("/buyBook")
//	    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	    public String buyBook(@FormParam("isbn") String isbn,
//	    		@FormParam("custID") String custID) {
//		    	return dao1.processPayment(isbn, custID);
//		    	
//	    }
	  
//		@GET
//		  @Produces(MediaType.TEXT_PLAIN)
//		  public String sayPlainTextHello() {
//		    return "Hello Jersey";
//		  }
//
//		  // This method is called if XML is request
//		  @GET
//		  @Produces(MediaType.TEXT_XML)
//		  public String sayXMLHello() {
//		    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
//		  }
//
//		  // This method is called if HTML is request
//		  @GET
//		  @Produces(MediaType.TEXT_HTML)
//		  public String sayHtmlHello() {
//		    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
//		        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
//		  }
//	    
//	    @POST 
//	    @Path("/buyBook")
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public String buyBook(@FormParam("isbn") String isbn,
//    		@FormParam("custID") String custID) {
//	    	return dao1.processPayment(isbn, custID);
//	    	
//    }
  
//    @GET 
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public Wine findById(@PathParam("id") String id) {
//        return dao.findById(Integer.parseInt(id));
//    }
// 
//    @POST
//    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public Wine create(Wine wine) {
//        return dao.create(wine);
//    }
// 
//    @PUT 
//    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public Wine update(Wine wine) {
//        return dao.update(wine);
//    }
// 
//    @DELETE
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public void remove(@PathParam("id") int id) {
//        dao.remove(id);
//    }
}
