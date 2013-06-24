<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<title>Search book</title>
<link rel="stylesheet" type="text/css" href="style.css" />

<script type="text/javascript">

function validateForm()
{
var x=document.forms["search"]["author_FirstName"].value;
var x1=document.forms["search"]["author_LastName"].value;
if (x==null || x=="")
  {
   if (x1==null || x1=="")
  {
  alert("First or Last name must be filled out");
  return false;
  }
  return true;
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
               <div class="title">
               
       	<div class="contact_form">
                <div class="form_subtitle">Search Book</div>
                <form action="search" method="post" >      
               <div class="form_row">
                    <label class="contact"><strong>First name:</strong></label>
                     <input type="text" id="author_FirstName" name="author_FirstName"/>
                     </div>
                    <div class="form_row">
                    <label class="contact"><strong>Last name:</strong></label>
                     <input type="text" id="author_LastName" name="author_LastName"/>
                 </div>
                  <div class="form_row">
                   <input type="submit" class="register" value="Search" onclick="return validateForm()">  
                   </div>
                  </form>     
 </div>  
           </div>	
      </div>  
 
</div>
     
</body>

</html>