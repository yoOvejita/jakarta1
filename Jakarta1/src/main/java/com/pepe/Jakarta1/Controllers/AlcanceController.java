package com.pepe.Jakarta1.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AlcanceController
 */
public class AlcanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String var_sesion, var_contexto;

	/**
	 * Default constructor.
	 */
	public AlcanceController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Estamos en doGet()");
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("usuario");
		out.println("Alcance de petición: " + nombre + "<br/>");

		// Ahora con sesión
		HttpSession sesion = request.getSession();
		if (var_sesion == null)// Se asigna una variable de sesión
			sesion.setAttribute("param_sesion", nombre);
		var_sesion = (String) sesion.getAttribute("param_sesion");// Se recibe una variable de sesión
		out.println("Alcance de sesión: " + var_sesion + "<br/>");

		// Ahora con contexto
		ServletContext contexto = request.getSession().getServletContext();
		if (var_contexto == null)// Se escribe una variable de contexto
			contexto.setAttribute("nom", nombre);
		var_contexto = (String) contexto.getAttribute("nom");// Se recibe una variable de contexto
		out.println("Alcance de contexto: " + var_contexto + "<br/>");
		
		//Cuando queremos eliminar un atributo de sesión
		//request.removeAttribute("param_sesion");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
