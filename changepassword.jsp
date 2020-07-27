

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
            <h2>PASSWORD CHANGE</h2>
			<form action="changepassword">
			    Enter customer id           - <input type="text" name="cid"/><br>
			    Enter old password           - <input type="text" name="cpassword"/><br>
				Enter new password           - <input type="text" name="newpassword"/><br>
				Confirm new password         - <input type="text" name="confirmpassword"/><br>
			    <input type="submit" name="btn" value="changepassword">
			</form>
</body>
</html>
