<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Route</title>
</head>
<body>
	<form action="addnewroute" method="post">
		 <label for="truckid"><b>Truck ID</b></label>
	    <input type="text" placeholder="Enter Truck ID" name="truckid" required><br>
		
	    <label for="route"><b>Route</b></label>
	    <input type="text" placeholder="Enter Route" name="route" required><br>
	
	    <button type="submit">Add Route</button>
	</form>
	<form action="home" method="get">
		<button type="submit">Home Page</button> 
	</form>

</body>
</html>