<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Truck</title>
</head>
<body>
	<form action="addnewtruck" method="post">
			 <label for="owner"><b>Owner</b></label>
		    <input type="text" value=<%=session.getAttribute("username")%> name="owner" required><br>
			
		    <label for="location"><b>Location</b></label>
		    <input type="text" placeholder="Enter Location" name="location" required><br>
		
		    <button type="submit">Add Truck</button>
		</form>
		<form action="home" method="get">
			<button type="submit">Home Page</button> 
		</form>

</body>
</html>