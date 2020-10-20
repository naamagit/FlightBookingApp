<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<title>User Registration</title>
<head>
<meta charset="windows-1255">
<title>Register User</title>
</head>
<body>
<form action="registerUser" method="post">
<pre>
<h2>User Registration:</h2>
First Name: <input type="text" name="firstName"/>
Last Name: <input type="text" name="lastName"/>
User Name: <input type="text" name="email" />
Password: <input type="password" name="password"/>
Confirm Password: <input type="password" name="Confirmpassword"/>
<input type="submit" value="register"/>
</pre>
</form>

</body>
</html>