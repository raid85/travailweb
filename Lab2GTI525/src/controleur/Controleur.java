/*
 * Nom de fichier: Controleur.java
 * Créé par: Alexandru Marinescu
 * Date de création: 01-03-2012
 * Modifications: Sans arret et tous les jours depuis creation
 */
package controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.BeanSpectacle;
import modele.BeanRepresentation;
import modele.DelegateSpectacles;
import modele.Panier;




public class Controleur {

	private static final long serialVersionUID = 2579846315782156987L;
	
	//methode qui gère l'application web 
	public String doHandle(HttpServletRequest request, HttpServletResponse response){		
		
		
		//Premier load de la page
		if (request.getParameterMap().size() < 1){	
				
			
				System.out.println("TRACE Controleur: Premier load de la page");
				return "index.jsp";
			}
		
		//si on reçoit dans la requête chercheSpectacles
		//Vers page spectacles disponibles
		else if (request.getParameter("action").equals("chercheSpectacles")){

			
				System.out.println("TRACE Controleur: Btn Rechercher Spectacles clicked");
				
				//on va envoyer les spectacles à la session
				DelegateSpectacles myDelegate = new DelegateSpectacles();
				System.out.println(myDelegate.getSpectacles().get(0).getNom());
				request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());				
				
				//on redirige jsp populé
				return "spectacles.jsp";
				}
		//Vers page de laffichage des representations
		else if (request.getParameter("action").equals("afficherRepresentations")){

			
			DelegateSpectacles myDelegate = new DelegateSpectacles();
			System.out.println(myDelegate.getSpectacles().get(0).getNom());
			request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());				
			
			
			
			System.out.println("TRACE Controleur: Btn voirRepresentations clicked");
			
			//System.out.println(((BeanSpectacle)request.getSession().getAttribute("chosenPestacle")).getDescription());			
			
			
			return "representations.jsp";}
		
		//Vers page choisir nbBillets
		else if (request.getParameter("action").equals("afficherRepChoisi")){

			//BeanRepresentation repDummy = new BeanRepresentation();
			
			DelegateSpectacles myDelegate = new DelegateSpectacles();
			System.out.println(myDelegate.getSpectacles().get(0).getNom());
			request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());				
			
			//On initialise le panier vide ici car il sera utile au niveau de representation_choisie.jsp		
			//
			//Panier panier = new Panier(repDummy,1);
			
			
			System.out.println("TRACE Controleur: Btn voirRepChoisi clicked");
			
			//System.out.println(((BeanSpectacle)request.getSession().getAttribute("chosenPestacle")).getDescription());			
			
			
			return "representation_choisie.jsp";}
		
		//Vers page panier
		else if (request.getParameter("action").equals("ajouterDansPanier")){

			
			boolean bool = true;//variable pour des tests
			
			//nb billets capte du jsp
			String nbBilletsReserve = request.getParameter("nbBillets");
			//on capte la position du spectacle choisi dans le arraylist à partir de la page jsp
			int posSpectacle = Integer.valueOf(request.getParameter("spec").toString());
			
			//on capte la position de la representation choisie dans le 
			//tableau de representations pour le spectacle choisi
			int posRepresentation = Integer.valueOf(request.getParameter("rep").toString());
			
			//On va chercher les stub spectacle à l'aide du patron delegate
			DelegateSpectacles myDelegate = new DelegateSpectacles();
			
			
			
		
			//Si le panier est vide(premiere fois qu'on y ajoute quelquechose)
			if(bool){
			
				System.out.println("***Se rend dans est vide*******************");

					//On initialise le panier et on le remplit avec la representation choisie		
					//et le nombre de billets choisi
					Panier panier = new Panier(myDelegate.getSpectacles().get(posSpectacle).getListeRepresentations().get(posRepresentation),Integer.valueOf(nbBilletsReserve.toString()));
					
					//on set l'attribut panier
					request.getSession().setAttribute("panier",panier);	
			}
			//Si le panier contient deja des billets pour un autre spectacle
			else{
				
				System.out.println("***Se rend dans est pas vide*******************");
				
				
				Panier newPanier=(Panier)request.getAttribute("panier");
				newPanier.ajouterItem(myDelegate.getSpectacles().get(posSpectacle).getListeRepresentations().get(posRepresentation),Integer.valueOf(nbBilletsReserve.toString()));
	
				//on set l'attribut panier
				request.getSession().setAttribute("panier",newPanier);	
			}
		
			//on set l'atribut spectacles pour la session
			request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());				
									
			System.out.println("TRACE Controleur: Btn Reserver clicked");
					
			return "panier.jsp";}
		
		//Vers page payement
		else if (request.getParameter("action").equals("afficherPayement")){

			System.out.println("TRACE Controleur: Btn afficherPayement clicked");
			
			return "payement.jsp";}else
					
				return "erreur.jsp";
			
		
}
//Fin doHandle	
	
}