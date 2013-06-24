package controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.*;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Servlet implementation class search
 */
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String authorFirstname = request.getParameter("author_FirstName");
		String authorLastname = request.getParameter("author_LastName");
				out.println("<center>");
			out.println("<br><br><br>");
			System.out.println(authorFirstname+" dnsnx bfk"+authorLastname);
			String requestquery = "http://localhost:8080/bookStore_Project3";
			ClientConfig config = new DefaultClientConfig();
		    Client client = Client.create(config);
		    WebResource service = client.resource(getBaseURI(requestquery));
		    // Fluent interfaces
//		    System.out.println(service.path("rest").path("searchBook/").path(authorFirstname).
//		    		path(authorLastname).accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
//		    // Get plain text
//		    System.out.println(service.path("rest").path("searchBook").path(authorFirstname).
//		    		path(authorLastname).accept(MediaType.TEXT_PLAIN).get(String.class));
//		    // Get XML
//		    System.out.println(service.path("rest").path("searchBook").
//		    		path(authorFirstname).
//		    		path(authorLastname).accept(MediaType.TEXT_XML).get(String.class));
		    // The HTML
		    System.out.println(service.path("rest").path("searchBook").
		    		queryParam("author_FirstName", authorFirstname).
		    		queryParam("author_LastName", authorLastname).
		    		accept(MediaType.APPLICATION_JSON).get(String.class));
		    System.out.println(service.path("rest").path("searchBook").
		    		queryParam("author_FirstName", authorFirstname).
		    		queryParam("author_LastName", authorLastname).
		    		accept(MediaType.APPLICATION_XML).get(String.class));
		    List<Book> lists = service.path("rest").path("searchBook").
		    		queryParam("author_FirstName", authorFirstname).
		    		queryParam("author_LastName", authorLastname)
		            .accept(MediaType.APPLICATION_XML)
		                .get(new GenericType<List<Book>>(){});
		        System.out.println(lists.size());
	        	out.println("<table>");
		        for(int i=0;i<lists.size();i++)
		        {
		        	Book bk=lists.get(i);
		        	out.println("<tr><td>"+bk.getAuthor_firstname()+"</td><td>"+bk.getAuthor_lastname()
		        			+"</td><td>"+bk.getBook_name()+"</td><td>"+bk.getId()+"</td><td>"+
		        			bk.getISBN()+"</td><td>"+bk.getPrice()+"</td></tr>");
		        	System.out.println(lists.get(i).getAuthor_firstname());
		        }
	        	out.println("</table>");
	        	
	        	request.setAttribute("books", lists);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchResult.jsp");

	        	  if (dispatcher != null){

	        	  dispatcher.forward(request, response);

	        	  } 

		        
//			HttpClient client = new HttpClient();
//			GetMethod method = new GetMethod(requestquery);
//			int statusCode = client.executeMethod(method);
//			if (statusCode != HttpStatus.SC_OK) {
//				System.err.println("Method failed: " + method.getStatusLine());
//			}
//			InputStream rstream = null;
//			rstream = method.getResponseBodyAsStream();
//			Document queryresponse = null;
//			try {
//				queryresponse = DocumentBuilderFactory.newInstance()
//						.newDocumentBuilder().parse(rstream);
//				out.println(queryresponse);
//
//			} catch (SAXException e) {
//				e.printStackTrace();
//			} catch (ParserConfigurationException e) {
//				e.printStackTrace();
//			}
//
//			XPathFactory factory = XPathFactory.newInstance();
//			XPath xPath = factory.newXPath();
//			NodeList nodes = null;
//			try {
//				nodes = (NodeList) xPath.evaluate("/return", queryresponse,
//						XPathConstants.NODESET);
//							} catch (XPathExpressionException e) {
//				e.printStackTrace();
//			}
//			int nodeCount = nodes.getLength();
//			for (int i = 0; i < nodeCount; i++) {
//				// Get each xpath expression as a string
//				String rupees = null;
//				String euros = null;
//				try {
//					rupees = (String) xPath.evaluate("dollarToRupeesResponse",
//							nodes.item(i), XPathConstants.STRING);
//					euros = (String) xPath.evaluate("rupeesToEurosResponse",
//							nodes.item(i), XPathConstants.STRING);
//
//				} catch (XPathExpressionException e) {
//					e.printStackTrace();
//				}
//				//out.println(query + " Dollars equals to " + rupees + " Rupees");
//				//out.println("<br>");
//				///out.println(rupees + " Rupees equals to " + euros + " Euros");
//			}
//			out.println("</center>");
		}
	

   private static URI getBaseURI(String uri) {
    return UriBuilder.fromUri(uri).build();
  }
	}


