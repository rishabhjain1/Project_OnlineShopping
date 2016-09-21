<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER</title>
</head>
<style>body {background-color:black; color : white;} h1 {text-align:center} table {text-align: center}
#srch
{ }
#Sbmt
{
background: transparent;
    border:solid;
    color: white; 
    font-size:20px;
    font-weight:700;}
    p{font-size:20px;}
#s1{background: transparent;
    border:solid;
    color: white; 
    font-size:20px;
    font-weight:700;}
    #s2{background: transparent;
    border:solid;
    color: white; 
    font-size:20px;
    font-weight:700;}
</style>

<body>
<% 
String ID = (String) session.getAttribute("UserID");
%>
<p>
<%=ID%>!
</p>
<h1>ShoppingSpree</h1>
<p style="text-align:right">
<input type="submit" id = "s1" name= "Cart" value="Cart" style="background-color:black; color:white;"/>
<input type="submit" id = "s2" name= "OrderHistory" value="OrderHistory" style="background-color:black; color:white;"/>
</p>

<form action="SearchServlet" method="POST" >
<br>
<br>
<p align="center">
<input type="search" name="search" id ="srch" placeholder = "Search" style = "color:black ; font-size : 0.4in ; text-align:center;" />
<br>
<br>

<input type="submit" id="Sbmt" value = "Go" style=" text-align:center";>
</p>
</form>

</body>
</html>