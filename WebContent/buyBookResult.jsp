<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<br>


<% 
			
		String status= (String)request.getAttribute("status");
        
      %>  
      
	<h2><%=status %></h2>
</div>

</div>


</body>
</html>