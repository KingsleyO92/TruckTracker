<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Register</title>
	</head>
	<body>
		<form action="signup" method="post">
		    <label for="username"><b>Username</b></label>
		    <input type="text" placeholder="Enter Username" name="username" required><br>
		
		    <label for="password"><b>Password</b></label>
		    <input type="password" placeholder="Enter Password" name="password" required><br>
		    
		    <label for="Company"><b>Company</b></label>
		    <input type="text" placeholder="Enter Company" name="company" required><br>
		    
		    <label for="email"><b>Email</b></label>
		    <input type="text" placeholder="Enter Email" name="email" required><br>
		
		    <button type="submit">Create User</button>
		</form>
	</body>
</html>