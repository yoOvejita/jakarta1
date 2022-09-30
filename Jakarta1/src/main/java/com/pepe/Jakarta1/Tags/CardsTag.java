package com.pepe.Jakarta1.Tags;

import java.io.IOException;
import java.io.StringWriter;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class CardsTag  extends SimpleTagSupport{
	StringWriter sw = new StringWriter();
	private String titulo;
	private String valor;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
		
	}
	

	public void setValor(String valor) {
		this.valor = valor;
	}


	public void doTag() throws JspException, IOException {
		String aux = valor != null ? valor : "CLICK";
		
		if(titulo != null) {//Se le pas´ço un valor a la propiedad
			getJspBody().invoke(sw);
			getJspContext().getOut().println("<div class=\"card\" style=\"width: 18rem;\">" +
					   "<img src=\"...\" class=\"card-img-top\" alt=\"...\">" +
					   "<div class=\"card-body\">" +
					   "<h5 class=\"card-title\">"+titulo+"</h5>" +
					   "<p class=\"card-text\">" + sw.toString() +"</p>" +
					   "<a href=\"#\" class=\"btn btn-primary\">"+aux+"</a>" +
					   "</div></div>");
		}else {
			//sw.append("<h1>Finjamos que es un card</h1>");
			getJspBody().invoke(sw);
		   getJspContext().getOut().println("<div class=\"card\" style=\"width: 18rem;\">" +
				   "<img src=\"...\" class=\"card-img-top\" alt=\"...\">" +
				   "<div class=\"card-body\">" +
				   "<h5 class=\"card-title\">Card title</h5>" +
				   "<p class=\"card-text\">" + sw.toString() +"</p>" +
				   "<a href=\"#\" class=\"btn btn-primary\">"+aux+"</a>" +
				   "</div></div>");
		}
		
			
		   
		   /*
	      JspWriter out = getJspContext().getOut();//nuestro writer
	      out.println("<div class=\"card\" style=\"width: 18rem;\">");
	      out.println("<img src=\"...\" class=\"card-img-top\" alt=\"...\">");
	      out.println("<div class=\"card-body\">");
	      out.println("<h5 class=\"card-title\">Card title</h5>");
	      out.println("<p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>");
	      out.println("<a href=\"#\" class=\"btn btn-primary\">Go somewhere</a>");
	      out.println("</div></div>");
	      */
	   }
}


/*
 * <pepe>
 * 
 */