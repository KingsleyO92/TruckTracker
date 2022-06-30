<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Truck Routes Search</title>
</head>
<body>
	<form action="routeslookup" method="post">
	    <label for="truckid"><b>Truck ID</b></label>
	    <input type="text" name="truckid" required><br>
	    
	    <button type="submit">Search</button>
	</form>
	<form action="home" method="get">
		<button type="submit">Home Page</button> 
	</form>
</body>
</html>