/*
 * Nom de fichier: Controleur.java
 * Créé par: Alexandru Marinescu
 * Date de création: 01-03-2012
 * Modifications:
 */
package controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class Controleur {

	private static final long serialVersionUID = 2579846315782156987L;
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response){		
		
		
		
		if (request.getParameterMap().size() < 1){	
				
			
			System.out.println("Mangez mon sushi3");
				return "index.jsp";
			}
			
		else if (request.getParameter("action").equals("chercheSpectacles")){

			
			System.out.println("Mangez mon sushi");
				return "erreur.jsp";}else
					
					return "erreur.jsp";
			
		
}
}