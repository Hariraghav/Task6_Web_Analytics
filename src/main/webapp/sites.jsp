<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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

 <div style="margin: 30px">   
      <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <div class="container-fluid justify-content-center">
            <a class="navbar-brand" href="/">Web Analytics</a> 
          </div>
        </nav>
      </header>    
      <div  style="margin-top: 10px" class="container w-50 text-center">
		<table class="table table-stripped">
			  <c:forEach items="${list}" var="list">
			   <tr>
			     <td><form class='text-center' action="details">
			     <button class='btn' name = 'url'type="submit" value=${list.url}>
			     ${list.url}
			     </button>
			     </form></td>
			   </tr>
			  </c:forEach>
		</table>
     
      	
      </div>
</div>



</body>
</html>