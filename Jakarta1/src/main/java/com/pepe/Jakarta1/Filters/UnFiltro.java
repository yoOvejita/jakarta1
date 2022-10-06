package com.pepe.Jakarta1.Filters;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UnFiltro
 */
public class UnFiltro extends HttpFilter implements Filter {
       private String estado = "";
    /**
     * @see HttpFilter#HttpFilter()
     */
    public UnFiltro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if(estado.equals("no"))
		// pass the request along the filter chain
			chain.doFilter(request, response);
		else {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("error.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		estado =fConfig.getInitParameter("enMantenimiento");
	}

}
