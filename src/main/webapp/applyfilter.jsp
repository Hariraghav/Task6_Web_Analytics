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
    <script type="text/javascript">
    	function toggleLocation(e){
    		document.getElementById("location").style.display = e.checked ? "grid" : "none";
    		//alert("hello");
    	}
     	function toggleBrowser(e){
    		document.getElementById("browser").style.display =  e.checked ? "grid" : "none";
    		//alert("hello");
    	}
     	function toggleDate(e){
    		document.getElementById("date").style.display =  e.checked ? "grid" : "none";
    		//alert("hello");
    	}
    	
    </script>
  </head>
</head>
<body>
   
   
      <div  style="margin-top: 10px" class="container  ">
      <div class='row'>
      <div class='col-sm-3'></div>
      <div class='col-sm-6'>
      
      <form class='d-grid gap-3' action='Filter'>
      <div class="form-check d-flex justify-content-center " >
  <input style="margin-right: 10px" class="form-check-input " type="checkbox" value="" id="flexCheckDefault" onclick="toggleDate(this)" checked>
  <label class="form-check-label" for="flexCheckDefault">
    Date
  </label>
</div>
<div class='gap-3' id = 'date' style="display: grid;">
Enter the Range
    <input class='form-control' name='from' placeholder="From(YYYY-MM-DD)"/>
     <input class='form-control' name='to' placeholder="To(YYYY-MM-DD)"/>
</div>
<div class="form-check d-flex justify-content-center">
  <input style="margin-right: 10px" class="form-check-input" type="checkbox" value="" id="flexCheckChecked"  onclick="toggleBrowser(this)">
  <label class="form-check-label" for="flexCheckChecked">
    Browser
  </label>
</div>
<div class=' gap-3' id = 'browser' style="display: none">
   Enter the Browser Name
    <input class='form-control' name='browser' placeholder="Browser Name"/>
</div>
<div class="form-check d-flex justify-content-center">
  <input style="margin-right: 10px" class="form-check-input" type="checkbox" value="" id="flexCheckChecked" onclick="toggleLocation(this)">
  <label class="form-check-label" for="flexCheckChecked">
    Location
  </label>
</div>
<div class='gap-3' id = 'location' style="display: none">
   Enter the Location
    <input class='form-control' name='location' placeholder="Location"/>
</div>
<button class='btn btn-dark'type='submit'>Done</button>
</form>
</div>
<div class='col-sm-3'></div>

</div>
	</div>