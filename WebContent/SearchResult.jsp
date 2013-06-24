<%@page import="java.util.Iterator"%>
<%@page import="controller.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search Result book</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<br>
<body>
<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="index.html"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="index.html">home</a></li>
            <li><a href="buyBookPage.jsp">buy books</a></li>
            <li><a href="SearchPage.jsp">search books</a></li>
           </ul>
        </div>     
            
            
       </div> 
       
       
       <div class="center_content">

<%

   List<Book> books= (List<Book>)request.getAttribute("books");
  

   	 %>
        	 <table border="1">
             <tr>
            
              <th> ID </th>
             <th> Name </th>
             <th> Author FirstName </th>
             <th> Author LastName </th>   
             <th> ISBN </th>   
              </tr>
              <%
              for(int i=0;i<books.size();i++)
              {
              	Book bk=books.get(i);
              
          
        
      %>  
      

      <tr>
      <td> <%=bk.getAuthor_firstname()%> </td>
      <td> <%=bk.getAuthor_lastname()%> </td>
      <td> <%=bk.getBook_name()%> </td>
      <td> <%=bk.getId()%> </td>
      <td> <%=bk.getISBN()%> </td>
       <td><a href="buyBookPage.jsp?isbn=<%=bk.getISBN()%>">Buy Book</a> </td>
      </tr>
	<% 
	}
        
%>


</table>
</div>
</div>
</body>
</html>