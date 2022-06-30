<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trucker Tracker</title>
</head>
	<body>
		<div class="container">
			<form action="login" method="post">
			    <label for="uname"><b>Username</b></label>
			    <input type="text" placeholder="Enter Username" name="uname" required><br>
			
			    <label for="psw"><b>Password</b></label>
			    <input type="password" placeholder="Enter Password" name="psw" required><br>
			
			    <button type="submit">Login</button>
			</form><br>
			<form action="signup" method="get">
				<b>Not a Member?</b><button type="submit">Sign Up</button> 
			</form>
		</div>
		
		
	</body>
</html>