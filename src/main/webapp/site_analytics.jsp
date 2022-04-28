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
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>   
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
  <div style="margin: auto;display: flex; flex-direction:  column; justify-content: center;align-content: center;align-items: center;">
 			<canvas id="myChart" style="width:100%;max-width:600px"></canvas>
 			<canvas id="myChart1" style="width:100%;max-width:600px"></canvas>
 			<canvas id="myChart2" style="width:100%;max-width:600px"></canvas>
 </div>
      	 
      	  <script>
      
        var xValues = [];
        var yValues = [];
    	<c:forEach items="${list1}" var="list1">
    
		   xValues.push('${list1.country}'); 
		   yValues.push('${list1.count}');

		  </c:forEach>
        var barColors = "skyblue";
        console.log(xValues.toString());
        new Chart("myChart", {
          type: "bar",
          data: {
            labels: xValues,
            datasets: [{
             backgroundColor: barColors,
              data: yValues
            }]
          },
          options: {
            legend: {display: false},
            title: {
              display: true,
              text: "Count of Users by Country"
            }
          }
        });
        </script>
         <script>
      
        var xValues = [];
        var yValues = [];
    	<c:forEach items="${list2}" var="list2">
    
		   xValues.push('${list2.date}'); 
		   yValues.push('${list2.count}');

		  </c:forEach>
		  console.log(xValues.toString());
		  console.log(yValues.toString());
        var barColors = "#b75fd4";
        new Chart("myChart1", {
          type: "bar",
          data: {
            labels: xValues,
            datasets: [{
              backgroundColor: barColors,
              data: yValues
            }]
          },
          options: {
            legend: {display: false},
            title: {
              display: true,
              text: "Count of Users by Date"
            }
          }
        });
        </script>
        <script>
      
        var xValues = [];
        var yValues = [];
    	<c:forEach items="${list3}" var="list3">
    
		   xValues.push('${list3.browser}'); 
		   yValues.push('${list3.count}');

		  </c:forEach>
		  console.log(xValues.toString());
		  console.log(yValues.toString());
        var barColors = "#d45fb9";
        new Chart("myChart2", {
          type: "bar",
          data: {
            labels: xValues,
            datasets: [{
              backgroundColor: barColors,
              data: yValues
            }]
          },
          options: {
            legend: {display: false},
            title: {
              display: true,
              text: "Count of Users by Browser"
            }
          }
        });
        </script>
      </div>




</body>
</html>