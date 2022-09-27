package com.pepe.Jakarta1.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesController
 */
@WebServlet("/abcde")
public class CookiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CookiesController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("La cookie de telefono ha sido creada.");
		Cookie cookie = new Cookie("telefono","55566677");
		response.addCookie(cookie);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] galletas = request.getCookies();
		
		for(Cookie c : galletas) {
			if(c.getName().equals("telefono"))
				response.getWriter().append("Cookie encontrada! el telefono es: " + c.getValue());
			else
				response.getWriter().append("Cookie no encontrada! no existe la cookie de telefono.");
			
		}
		
		ServletContext context = getServletContext();
		
		String nom = context.getInitParameter("usuario");
		String pass = context.getInitParameter("password");
		
	}

}
