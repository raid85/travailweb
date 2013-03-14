/*
 * Nom de fichier: Controleur.java
 * Créé par: Alexandru Marinescu
 * Date de création: 01-03-2012
 * Modifications:
 */
package controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.DelegateSpectacles;




public class Controleur {

	private static final long serialVersionUID = 2579846315782156987L;
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response){		
		
		
		
		if (request.getParameterMap().size() < 1){	
				
			
				System.out.println("TRACE Controleur: Premier load de la page");
				return "index.jsp";
			}
			
		else if (request.getParameter("action").equals("chercheSpectacles")){

			
				System.out.println("TRACE Controleur: Btn Rechercher Spectacles clicked");
				
				DelegateSpectacles myDelegate = new DelegateSpectacles();
				System.out.println(myDelegate.getSpectacles().get(0).getNom());
				request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());				
				
				
				return "spectacles.jsp";
				}
		else if (request.getParameter("action").equals("voirRepresentations")){

			
			System.out.println("TRACE Controleur: Btn voirRepresentations clicked");
			
			DelegateSpectacles myDelegate = new DelegateSpectacles();
			System.out.println("TRACE: " + myDelegate.getSpectacles().get(0).getNom());
			request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());				
			
			
			return "representations.jsp";}else
					
				return "erreur.jsp";
			
		
}
}