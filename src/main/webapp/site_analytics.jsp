<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
		
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Web Analytics</title>
  </head>
</head>
<body>
   
   
      <div  style="margin-top: 10px" class="container  text-center">
<!-- Example single danger button -->
<a class='btn btn-dark' href='applyfilter.jsp'>Apply Filter</a>
<div style="margin-top: 40px">
		<div class='text-center alert alert-success ' role="alert">
		Number of users visited : ${fn:length(list)}
		
		</div>
		<table class='table table-stripped table-dark text-center' >
			<tr><th>Unique IP of user</th><th>Browser</th><th>No of visits</th></tr>
			  <c:forEach items="${list}" var="list">
			  <tr><td>  ${list.ip}</td><td>  ${list.browser}</td><td>  ${list.svisits}</td></tr>
			  </c:forEach>
		</table>
 </div>    
      	
      </div>




</body>
</html>