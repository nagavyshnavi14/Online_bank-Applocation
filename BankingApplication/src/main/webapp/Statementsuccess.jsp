<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success page</title>
</head>
<body>
	<%
		session = request.getSession();
		out.println(session.getAttribute("sal"));
		out.println("Account no(Sender) <br>");
		out.println(session.getAttribute("ral"));
		out.println("Account no(Reciepent) <br>");
		out.println(session.getAttribute("al"));
%>
</body>
</html>