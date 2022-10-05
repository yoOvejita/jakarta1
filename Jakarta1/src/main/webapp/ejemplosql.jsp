<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*, com.pepe.Jakarta1.BaseDeDatos.Conexion" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>obteniendo registros con WHERE</h1>
	
	<%
		Conexion c = new Conexion();
		//c.insertarEmpleado(6, "Raul", "Roca");
		//out.println("Registro exitoso.");
		String emps = c.getEmpleado("Roca");
		
		out.println(emps);
	%>
	<br/>JSTL
	<br/>
	
	
	<c:out value="${emps}"/>
	
	<c:import url="https://ww.google.com"></c:import>
	
	<c:set value="abc" var="nom_de_variable"></c:set>
	<c:out value="${nom_de_variable}"/>
	<br/>
	<h1>Modificando un registro</h1>
	<%
		//c.actualizarEmpleado(5, "Samanta", "Barrios");
	%>
	<h1>Eliminando un registro</h1>
	<%
		//c.borrarEmpleado(6);
	%>
	<h1>Listando registros</h1>
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
		con.close();
		st.close();
		rs.close();
		
	%>
	</table>
	
	<h1>Agregando un registro de Venta</h1>
	<%
		//c.agregarVenta(5, "Mermelada", 15.5);
	%>
</body>
</html>