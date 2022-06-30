<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>
	<div class="card">
		<div class = "container">
			<h3>USER PROFILE</h3>
			<b><%= session.getAttribute("username") %></b><br>
			<%= session.getAttribute("company") %><br>
			<%= session.getAttribute("email") %>
			
			<form action="login" method="get">
				<button type="submit">Log Out</button> 
			</form>
		</div>
		
		
		<div class = "container">
			<h3>TRUCKS</h3>
			<table>
				<tr>
					<th>ID</th>
					<th>Location</th>
				</tr>
				<c:forEach items="${trucklist}" var="t">
					<tr>
						<td><c:out value="${t.id}"/></td>
						<td><c:out value="${t.location}"/></td>
					</tr>
				</c:forEach>	
			</table>
			<form action="addnewtruck" method="get">
				<button type="submit">Add Truck</button> 
			</form>
		</div>
		
		<div class="container">
			<form action="routeslookup" method="get">
				<button type="submit">Look Up Truck Routes</button> 
			</form>
		</div>
		
	</div>
</body>
</html>