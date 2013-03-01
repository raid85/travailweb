/*
 * Nom de fichier: FrontControlerServlet.java
 * Créé par: Alexandru Marinescu
 * Date de création: 01-03-2012
 * Modifications:
 */
package controleur;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;



public class FrontControlerServlet  extends HttpServlet {

	/**
	 * HttpServlet implémente l'interface serializable, puisqu'il est possible de sérialiser, soit, de garder en persistance,
	 * l'état d'un servlet, par exemple pour conserver toutes les sessions à l'arrêt, et tout reprendre au démarrage. Afin de
	 * faire le lien entre une classe sérialisée et son implémentation, on met le champ serialVersionUID. Ce n'est vraiment
	 * pas nécessaire, mais sans ça, le compilateur va faire un avertissement. Alors bon, il est toujours mieux de le fixer.
	 */
	private static final long serialVersionUID = -8956587436876458937L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirige afin de centraliser les requêtes
		handle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("TRACE FrontControlerServlet: doPost");
		handle(request, response);
	}
	
	/**
	 * Cette méthode reçoit toutes les requêtes du servlet, et fais les redirections nécessaires
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Redirige au contrôleur de messages. Dans un Front Controller normal, il pourrait y avoir plusieurs servlets!
		Controleur controleur = new Controleur();
		String resultPage = controleur.doHandle(request, response);
		redirect(request, response, resultPage);
	}
	
	/**
	 * Faits la redirection vers les pages demandées par le sous contrôlleur
	 * @param request
	 * @param response
	 * @param page Le chemin et le nom de la page à afficher
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		//Redirige vers la page, fournie par le sous-contrôleur
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/"+page);
		dispatcher.forward(request, response);

	}   	
	
}
