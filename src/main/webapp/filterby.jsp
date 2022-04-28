<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



	 
      <div  style="margin-top: 10px" class="container  text-center">
  
            <div class='text-center alert alert-success ' role="alert">
            <c:if test="${not empty from && not empty to && empty browser && empty location}">  
  				 Date : ${from} to ${to}
			</c:if> 
            <c:if test="${ empty from &&  empty to && not empty browser &&  empty location}">  
  				  Browser: ${browser} 
			</c:if>
            <c:if test="${ empty from && empty to && empty browser && not empty location}">  
  				Country : ${location}
			</c:if>
            <c:if test="${not empty from && not empty to && not empty browser && empty location}">  
  				 Date : ${from} to ${to} , Browser: ${browser}
			</c:if>
            <c:if test="${empty from && empty to && not empty browser && not empty location}">  
  				Browser: ${browser}, Country : ${location}
			</c:if>
            <c:if test="${not empty from && not empty to && empty browser && not empty location}">  
  				 Date : ${from} to ${to} , Country : ${location}
			</c:if>
            <c:if test="${not empty from && not empty to && not empty browser && not empty location}">  
  				 Date : ${from} to ${to} , Browser: ${browser}, Country : ${location}
			</c:if>

		
		</div>
	<div class='text-center alert alert-success ' role="alert">
		Number of visits : ${fn:length(list)}
		
		</div>
		<table class='table table-stripped table-dark text-center' >
			<tr><th>Unique IP of user</th><th>Browser</th><th>Country</th><th>Date</th></tr>
			  <c:forEach items="${list}" var="list">
			  <tr><td>  ${list.ip}</td><td>  ${list.browser}</td><td>  ${list.country}</td><td>  ${list.date}</td></tr>
			  </c:forEach>
		</table>
 
      	
      </div>
      
