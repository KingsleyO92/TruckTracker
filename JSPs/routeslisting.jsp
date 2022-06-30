<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Routes List</title>
</head>
<body>
	<div class="card">
		<div class = "container">
			<h3>ROUTES</h3>
			<table>
				<tr>
					<th>ID</th>
					<th>Time</th>
					<th>Route Taken</th>
				</tr>
				<c:forEach items="${routeslist}" var="r">
					<tr>
						<td><c:out value="${r.id}"/></td>
						<td><c:out value="${r.time}"/></td>
						<td><c:out value="${r.route}"/></td>
					</tr>
				</c:forEach>	
			</table>
			<form action="addnewroute" method="get">
				<button type="submit">Add Route</button> 
			</form>
			
			<form action="home" method="get">
				<button type="submit">Home Page</button> 
			</form>
		</div>		
	</div>
</body>
</html>