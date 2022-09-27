package com.pepe.Jakarta1.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class paraMapeoController
 */
@WebServlet (name = "abc", urlPatterns = {"/mapeo"}, initParams= {@WebInitParam(name="prueba", value="algo")})
public class paraMapeoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public paraMapeoController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Sesión
		HttpSession sesion = request.getSession();
		String valor = "Hola a todos, desde la sesión";
		sesion.setAttribute("un_parametro", valor);
		
		String recibido = (String)sesion.getAttribute("un_parametro");
		
		//Contexto
		ServletContext contexto = request.getSession().getServletContext();
		contexto.setAttribute("un_param", valor);
		
		String recibido2 = (String) contexto.getAttribute("un_param");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
