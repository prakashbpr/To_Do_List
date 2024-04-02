<%@page import="java.util.Base64"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%User u = (User)request.getSession().getAttribute("user"); %>
<h1>Welcome <%=u.getUsername() %></h1>
<h2>Name :<%=u.getUsername() %></h2>
<h2>Email :<%=u.getUseremail() %></h2>
<h2>Contact :<%=u.getUsercontact() %></h2>
<%String image = new String(Base64.getEncoder().encode(u.getUserimage())); %>
<img alt="" src="data:image/jpeg;base64,<%= image  %>" width="200px" height="200px">

</body>
</html>