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
	 * HttpServlet impl�mente l'interface serializable, puisqu'il est possible de s�rialiser, soit, de garder en persistance,
	 * l'�tat d'un servlet, par exemple pour conserver toutes les sessions � l'arr�t, et tout reprendre au d�marrage. Afin de
	 * faire le lien entre une classe s�rialis�e et son impl�mentation, on met le champ serialVersionUID. Ce n'est vraiment
	 * pas n�cessaire, mais sans �a, le compilateur va faire un avertissement. Alors bon, il est toujours mieux de le fixer.
	 */
	private static final long serialVersionUID = -8956587436876458937L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirige afin de centraliser les requ�tes
		handle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("TRACE FrontControlerServlet: doPost");
		handle(request, response);
	}
	
	/**
	 * Cette m�thode re�oit toutes les requ�tes du servlet, et fais les redirections n�cessaires
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Redirige au contr�leur de messages. Dans un Front Controller normal, il pourrait y avoir plusieurs servlets!
		Controleur controleur = new Controleur();
		String resultPage = controleur.doHandle(request, response);
		redirect(request, response, resultPage);
	}
	
	/**
	 * Faits la redirection vers les pages demand�es par le sous contr�lleur
	 * @param request
	 * @param response
	 * @param page Le chemin et le nom de la page � afficher
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		//Redirige vers la page, fournie par le sous-contr�leur
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/"+page);
		dispatcher.forward(request, response);

	}   	
	
}
