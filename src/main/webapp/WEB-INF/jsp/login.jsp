<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<h2>User login</h2>
<form action="/login" method="post">
    <label for="username">Username:</label><br>
  <input type="text" id="user_name" name="username"><br>
    <label for="password">Password:</label><br>
  <input type="text" id="password" name="password"><br>
  <input type="submit" value="Login">
</form>
</body>
</html>