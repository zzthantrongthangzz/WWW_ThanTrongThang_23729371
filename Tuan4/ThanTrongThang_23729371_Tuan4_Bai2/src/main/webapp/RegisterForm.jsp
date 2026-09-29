<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>User Registration Form</title>
</head>
<body>
<h2>User Registration Form</h2>

<form action="${pageContext.request.contextPath}/registerform" method="post">
  <label for="firstname">First Name:</label>
  <input type="text" id="firstname" name="firstname" required><br><br>

  <label for="lastname">Last Name:</label>
  <input type="text" id="lastname" name="lastname" required><br><br>

  <label for="email">Your Email:</label>
  <input type="email" id="email" name="email" required><br><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>

  <label>Birthday:</label>
  <input type="number" name="month" placeholder="Month" required>
  <input type="number" name="day" placeholder="Day" required>
  <input type="number" name="year" placeholder="Year" required><br><br>

  <label>Gender:</label>
  <input type="radio" name="gender" value="Female"> Female
  <input type="radio" name="gender" value="Male"> Male<br><br>

  <input type="submit" value="Sign Up">
</form>
</body>
</html>