<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Current Tasks</title>
	</head>
	
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">${userName}'s Tasks</h2>
		<p style="text-align:center"></p><br>
		
		<table style="text-align:left;width:70%; cellpadding:2px" >
		<tr><th>Task Name</th><th>Start Date</th><th>End Date</th><th>Description</th><th>Severity</th></tr>  
		   <c:forEach items="${list}" var="tsk">   
		   <tr>  
		   <td>${task.name}</td>  
		   <td>${task.start}</td>  
		   <td>${task.end}</td>  
		   <td>${task.desc}</td> 
		   <td>${tsk.severity}</td> 
		   </tr>  
		   </c:forEach>
		   </table>  
		   <br/> 
		   <p>${e}
		   <form style="text-align:center" action="home" method="get">
		   		<input type="hidden" id="userName" name="userName" value="${userName}">
				
				<input type="submit" value="Home">
		   </form>
		   <p style="text-align:center"><a href="/">Go Homer</a></p>
	</body>
</html>