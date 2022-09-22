package com.pepe.Jakarta1.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerController
 */
public class PrimerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrimerController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estamos en el metodo doGet()");
		PrintWriter escritor = response.getWriter();
		String nombre = request.getParameter("usuario");
		escritor.println("<h1>Hola querido " + nombre + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estamos en el metodo doPost()");
		PrintWriter escritor = response.getWriter();
		String nombre = request.getParameter("usuario2");
		escritor.println("<h1>Hola querida " + nombre + " [POST]</h1>");
	}

}
