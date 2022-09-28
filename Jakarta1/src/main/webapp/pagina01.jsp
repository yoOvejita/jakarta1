<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="com.pepe.Jakarta1.Models.Estudiante" import="java.util.Date"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor='yellow'>
	<h1>Hola desde JSP</h1>
	<br/>
	<%
		String nom = request.getParameter("nombre");
		Double num = Math.pow(2,3);
		
	%>
	<h2>Este es un titulo cualquiera</h2>
	<br/>
	<%
		out.println(nom);
	%>
	<br/>
	<%= nom %>
	<br/>
	La potencia es: <%= Math.pow(2,5) %>
	<%! 
		int numero;
		Estudiante est;
	%>
	<h1>Atributos disponibles para la directiva page</h1>
	<p>language="nombre_lenguaje"</p>
	<p>extends="nombre_clase"</p>
	<p>import="lista de librerias"</p>
	<p>session="true/false"</p>
	<p>autoFlush="true/false"</p>
	<p>contentType="htmnl/archivo de video/imagen/etc"</p>
	<p>errorPage="url_error"</p>
	<p>isErrorPage="true/false"</p>
	<p>info="blablabla"</p>
	<%-- comentarios
	otra linea...
	 --%>
</body>
</html>