/*
 * Nom de fichier: FrontControlerServlet.java
 * Cr�� par: Alexandru Marinescu
 * Date de cr�ation: 01-03-2012
 * Modifications:
 */
package controleur;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;



public class FrontControlerServlet  extends HttpServlet {

	/**
	 On serialise le servlet pour pouvoir revenir dans une session une fois que celle-ci
	 a ete fermee. 
	 */
	private static final long serialVersionUID = -8956587436876458937L;
	Controleur controleur = new Controleur();;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirige afin de centraliser les requ�tes
		handle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("TRACE FrontControlerServlet: doPost");
		handle(request, response);
	}
	
	/**
	 * Cette m�thode re�oit des requ�tes du servlet, ensuite redirige
	
	 */
	protected void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Redirige au contr�leur de messages. Dans un Front Controller normal, il pourrait y avoir plusieurs servlets!
//		controleur = new Controleur();
		String resultPage = controleur.doHandle(request, response);
		redirect(request, response, resultPage);
	}
	
	/**
	 * redirige vers les pages demand/es dans Controleur.java
	*/
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		//Redirige vers la page que Controleur.java va sp/cifier avec la commande return nomPageDest.jsp;
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/"+page);
		dispatcher.forward(request, response);

	}   	
	
}
