/*
 * Nom de fichier: Controleur.java
 * Créé par: Alexandru Marinescu
 * Date de création: 01-03-2012
 * Modifications: Sans arret et tous les jours depuis creation
 */
package controleur;

import java.util.ArrayList;

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
		
		DelegateSpectacles myDelegate = null;
		Panier panier = null;
		//on va envoyer les spectacles à la session
		
		//Premier load de la page
		if (request.getParameterMap().size() < 1){	
				
			
			myDelegate = new DelegateSpectacles();
			System.out.println(myDelegate.getSpectacles().get(0).getNom());
			request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());	
			
				//initialisation du panier
				 panier = new Panier(); 
			
				request.getSession().setAttribute("panier", panier);
				System.out.println("TRACE Controleur: Premier load de la page");
				return "index.jsp";
			}
		
		//si on reçoit dans la requête chercheSpectacles
		//Vers page spectacles disponibles
		else if (request.getParameter("action").equals("chercheSpectacles")){

			
				System.out.println("TRACE Controleur: Btn Rechercher Spectacles clicked");
	
				
				//on redirige jsp populé
				return "spectacles.jsp";
				}
		//Vers page de laffichage des representations
		else if (request.getParameter("action").equals("afficherRepresentations")){

		
			
			System.out.println("TRACE Controleur: Btn voirRepresentations clicked");
		
			
			return "representations.jsp";}
		
		//Vers page choisir nbBillets
		else if (request.getParameter("action").equals("afficherRepChoisi")){

			
			System.out.println("TRACE Controleur: Btn voirRepChoisi clicked");
		
			return "representation_choisie.jsp";}
		
		//Vers page panier
		else if (request.getParameter("action").equals("ajouterDansPanier")){

			
			//nb billets capte du jsp
			String nbBilletsReserve = request.getParameter("nbBillets");
			//on capte la position du spectacle choisi dans le arraylist à partir de la page jsp
			int posSpectacle = Integer.valueOf(request.getParameter("spec").toString());
			
			//on capte la position de la representation choisie dans le 
			//tableau de representations pour le spectacle choisi
			int posRepresentation = Integer.valueOf(request.getParameter("rep").toString());
			
			//On va chercher les stub spectacle à l'aide du patron delegate
			myDelegate = new DelegateSpectacles();
			request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());
			
	
			System.out.println("***Se rend ici ***");

			//On initialise le panier et on le remplit avec la representation choisie		
			//et le nombre de billets choisi
			ArrayList<BeanSpectacle> monTableau =(ArrayList<BeanSpectacle>)request.getSession().getAttribute("spectacles");
//			System.out.println("MontTABLE   "+monTableau.size());
//			System.out.println(""+posSpectacle+" : "+posRepresentation);
			Panier myPanier = (Panier) request.getSession().getAttribute("panier");
			myPanier.ajouterItem(monTableau.get(posSpectacle).getListeRepresentations().get(posRepresentation),Integer.valueOf(nbBilletsReserve.toString()));		
			//on set l'attribut panier
			request.getSession().setAttribute("panier",myPanier);	
								
			System.out.println("TRACE Controleur: Btn Reserver clicked");
					
			return "panier.jsp";}
		
		//Vers page payement
		else if (request.getParameter("action").equals("afficherPayement")){

			System.out.println("TRACE Controleur: Btn afficherPayement clicked");
			
			return "payement.jsp";}
		
		else if (request.getParameter("action").equals("acheter")){

			System.out.println("TRACE Controleur: Btn acheter clicked");
			
			return "confirmation.jsp";}
		//Si le bouton Ajax ajouterBillet a été poussé
		else if (request.getParameter("action").equals("ajouterBillet")){

			
			Panier myPanier = (Panier) request.getSession().getAttribute("panier");
			//nb billets reserv/s qu'on veux modifier
			int nbBilletsReserve =  Integer.valueOf((request.getParameter("nbBilletsAchete")).toString());
			//position de l'item dans lepanier surlequel on veux modifier le nombre de billets
			int posItem =  Integer.valueOf((request.getParameter("posItem")).toString());
			
			//On ne laisse pas au client le choix d'acheter plus de billets
			if(nbBilletsReserve < 6 && nbBilletsReserve >=0){
				myPanier.getItemAchete(posItem).setNbBillets(nbBilletsReserve+1) ;			
				 }
						
			request.getSession().setAttribute("panier",myPanier);	
			
						
//			System.err.println("ajouterBilletClicked");
//			System.err.println(nbBilletsReserve);
			
			return "panier.jsp";}
		else if (request.getParameter("action").equals("enleverBillet")){

			
			Panier myPanier = (Panier) request.getSession().getAttribute("panier");
			//nb billets reserv/s qu'on veux modifier
			int nbBilletsReserve =  Integer.valueOf((request.getParameter("nbBilletsAchete")).toString());
			//position de l'item dans lepanier surlequel on veux modifier le nombre de billets
			int posItem =  Integer.valueOf((request.getParameter("posItem")).toString());
			
			//On ne laisse pas au client le choix d'acheter mois de billets que 0
			if(nbBilletsReserve < 7 && nbBilletsReserve >0){
				myPanier.getItemAchete(posItem).setNbBillets(nbBilletsReserve-1) ;			
				 }
							
						
			if(nbBilletsReserve == 0){
				myPanier.removeItemAchete(posItem);			
				 }
			request.getSession().setAttribute("panier",myPanier);	
						
//			System.err.println("ajouterBilletClicked");
//			System.err.println(nbBilletsReserve);
			
			return "panier.jsp";}
		else if (request.getParameter("action").equals("revenirAccueil")){

			System.out.println("TRACE Controleur: Btn revenir a laccueil");
			
			Panier myPanier = (Panier) request.getSession().getAttribute("panier");
			//On Vide le panier pour une autre transaction et on retourne a l<accueil
			for(int i=0;i<myPanier.getPanier().length;i++){
			myPanier.removeItemAchete(i);
			}
			
			request.getSession().setAttribute("panier",myPanier);	

			return "index.jsp";}else
					
				return "erreur.jsp";
			
		
}
//Fin doHandle	
	
}