<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<%
		Class.forName("org.postgresql.Driver");
	
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay","postgres","123456");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM empleado");
		
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getInt(1)+"</td><td> " + rs.getString(2) + "</td><td> " + rs.getString(3) +"</td>");
			out.println("</tr>");
			
		}
		
		
	%>
	</table>
</body>
</html>