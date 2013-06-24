<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<title>Buy book</title>
<link rel="stylesheet" type="text/css" href="style.css" />

<script type="text/javascript">
function validateForm()
{
var x=document.forms["search"]["isbn"].value;
var x1=document.forms["search"]["custId"].value;
if (x==null || x=="")
  {
  alert("ISBN must be filled out");
  return false;
  }
if (x1==null || x1=="")
{
alert("Cust ID must be filled out");
return false;
}
return true;
}
</script>
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
	<div class="contact_form">
                <div class="form_subtitle">Buy Book</div>
                 <form method="POST" action="buy">        
                  <div class="form_row">
                    <label class="contact"><strong>ISBN:</strong></label>
                   <% 
                   if(request.getParameter("isbn")!=null)
                    {
                    %> 
                    <input type="text" name="isbn" value=<%=request.getParameter("isbn") %>>
                    <%
                    }
                    else
                    {
                    %>
                      <input type="text" name="isbn" >
                    <%
                    }
                    %>
                   </div> 
                       <div class="form_row">
                    <label class="contact"><strong>Customer ID:</strong></label>
                <input type="text" name="custId">
          </div>  
        
                    <div class="form_row">
                    <input type="submit" class="register" value="Submit" onclick="return validateForm()"/>
                    </div>
                  </form>     
               
   </div>  
           </div>	
      </div>  



</body>

</html>