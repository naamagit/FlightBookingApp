<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>User Login</title>
</head>
<body>
<h2>Login:</h2>
<form action="login" method="post">
<pre>
User Name:<input type="text" name="email"/>
Password:<input type="password" name="password"/> 
<input type="submit" value="login"/>
${msg}
</pre>
</form>
</body>
</html>