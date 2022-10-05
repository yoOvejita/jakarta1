<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.pepe.Jakarta1.Models.Estudiante, java.util.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@taglib prefix="func" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Estudiante est = new Estudiante();
	est.nombre = "Ana";
	est.apellido = "Sosa";
	request.setAttribute("estudiante", est);
	
	List<Estudiante> ests = Arrays.asList(
			new Estudiante(), est, est
	);
	request.setAttribute("estudiantes", ests);
	%>
	<br/>
	<h1>Recuperar estudiante</h1>
	El estudiante es
	<p>${estudiante.nombre}</p>
	
	<h1>Recuperando varios estudiantes</h1>
	<c:forEach items="${estudiantes}" var="es">
		Nombre: ${es.nombre} <br/>
	</c:forEach>
	
	<h1>Tag para conectarnos a una base  de datos</h1>
	<sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://192.168.1.253/empresay"
	user="postgres" password="123456"/>
	
	<sql:query var="rs" dataSource="${db}">
		SELECT * FROM empleado;
	</sql:query>
	<c:forEach items="${rs.rows}" var="emp">
		<c:out value="${emp.id}"></c:out>
		<c:out value="${emp.nombre}"></c:out>
		<c:out value="${emp.apellido}"></c:out>
	</c:forEach>
	
	<h1>Uso de funciones</h1>
	<c:set var="cadena" value="Esta es una cadena cualquiera"/>
	Longitud: ${func:length(cadena)}
	
	<br/>
	Split:
	<c:forEach items="${func:split(cadena,' ')}" var="elem">
		${elem}<br/>
	</c:forEach>
	<br/>
	Indice: ${func:indexOf(cadena, "na ") } 
	<br/>
	Está en la cadena: ${func:contains(cadena,"todo") }
</body>
</html>