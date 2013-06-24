package creditCardService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.creditCard;
import dao.searchBook;

@Path("/creditCard")

public class creditCardService {
	
	creditCard dao=new creditCard();
    @GET 
@Produces(MediaType.TEXT_PLAIN)
public String buyBook(@QueryParam("fName") String fName, @QueryParam("lName") String lName,
		@QueryParam("accno") String accno, @QueryParam("price") String price) {
    	System.out.println(fName+" "+lName+" "+ accno+ " "+ price);
    	return dao.processCreditCard(fName, lName, accno, Double.parseDouble(price));
    	
}

}
