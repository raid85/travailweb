/*
 * Nom de fichier: Controleur.java
 * Créé par: Alexandru Marinescu
 * Date de création: 01-03-2012
 * Modifications: Sans arret et tous les jours depuis creation
 */
package controleur;

import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.BeanClient;
import modele.BeanSpectacle;
import modele.BeanRepresentation;
import modele.DelegateSpectacles;
import modele.PaiementDAO;
import modele.Panier;




public class Controleur {
	
	private static final int stubStoreID = 1234 ;
	private static final String stubApiKey = "f0d19ab1af1963ad1a73";
	private DelegateSpectacles myDelegate = new DelegateSpectacles();
	//methode qui gère l'application web 
	public String doHandle(HttpServletRequest request, HttpServletResponse response){		

//		DelegateSpectacles myDelegate = null;/
		Panier panier = null;

		//Instanciation des objets qui serviront a authoriser un paiement pour le client
		InformationsPaiementTO infosClient = new InformationsPaiementTO () ;
		PaiementDAO payerDAO = new PaiementDAO () ;
//		myDelegate = new DelegateSpectacles();
		//on va envoyer les spectacles à la session

		//Premier load de la page
		if (request.getParameterMap().size() < 1){	


			
			try {
				System.out.println(myDelegate.getSpectacles().get(0).getNom());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

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
			
			try {
				request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

			//int totalBillets=Integer.valueOf(request.getParameter("totalBillets").toString());

			//On va chercher les stub spectacle à l'aide du patron delegate
//			myDelegate = new DelegateSpectacles();
			//Ici on ajuste le nombre total de billets disponibles suite à une reservation
			//myDelegate.getSpectacles().get(posSpectacle).getListeRepresentations().get(posRepresentation).setBilletsDispo(totalBillets - Integer.valueOf(nbBilletsReserve.toString()));	
			try {
				request.getSession().setAttribute("spectacles",myDelegate.getSpectacles());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//System.out.println("***Se rend ici ***");

			//On initialise le panier et on le remplit avec la representation choisie		
			//et le nombre de billets choisi
			ArrayList<BeanSpectacle> monTableau =(ArrayList<BeanSpectacle>)request.getSession().getAttribute("spectacles");
			//			System.out.println("MontTABLE   "+monTableau.size());
			//			System.out.println(""+posSpectacle+" : "+posRepresentation);

			//On ajoute un item au panier
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

		//vers page de confirmation d'achat
		else if (request.getParameter("action").equals("preAuthorisation")){
			
			System.out.println("TRACE Controleur: Btn preAuthorisation clicked");
			Panier unPanier = (Panier) request.getSession().getAttribute("panier");
			BeanClient client = new BeanClient();
	
			//on obtient nos valeurs du formulaire d'achat du client
			//ensuite on construit notre objet client avec ces parametres
			client.setNomClient(request.getParameter("nomClient"));
			client.setPrenomClient(request.getParameter("prenomClient"));
			client.setAddrClient(request.getParameter("adresse"));
			client.setEmailClient(request.getParameter("emailClient"));
			client.setNrCarteClient(request.getParameter("nrCarte"));
			client.setCvvClient(request.getParameter("cvv"));
			client.setMoisExpClient(request.getParameter("moisExp"));
			client.setAnExpClient(request.getParameter("anExp"));
			client.setPaysClient(request.getParameter("pays"));
			client.setProvClient(request.getParameter("prov"));
			client.setVilleClient(request.getParameter("ville"));
			client.setCodePostal(request.getParameter("codep"));
			
			System.out.println("----------Objet Client------------");
			System.out.println("Nom:" + client.getNomClient());
			System.out.println("Prenom:" + client.getPrenomClient());
			System.out.println("Numero Carte:" + client.getNrCarteClient());
			System.out.println("Annee exp:" + client.getAnExpClient());
			System.out.println("Mois Exp:" + client.getMoisExpClient());
			System.out.println("Cvv:" + client.getCvvClient());
			System.out.println("Ville:" + client.getVilleClient());
			System.out.println("Pays:" + client.getPaysClient());
			System.out.println("Adresse:" + client.getAddrClient());
			System.out.println("CodeP:" + client.getCodePostal());
		
			//on set l'attribut de la session client
			request.getSession().setAttribute("Client",client);	

	
			//On remplit l'objet InformationsPaiementTO requis par le service de transactions			
			infosClient.setApi_key(stubApiKey);					
			infosClient.setStore_id(stubStoreID);
			infosClient.setOrder_id((long) ((Math.random()*100)));	
			infosClient.setFirst_name(client.getPrenomClient());
			infosClient.setLast_name(client.getNomClient());
			infosClient.setCard_number(Long.valueOf(client.getNrCarteClient()));
			infosClient.setSecurity_code(Integer.valueOf(client.getCvvClient()));
			infosClient.setYear(Integer.valueOf(client.getAnExpClient()));
			infosClient.setMonth(Integer.valueOf(client.getMoisExpClient()));
			infosClient.setAmount(BigDecimal.valueOf(unPanier.getTotal()));
		
			
			System.out.println("----------InformationsPaiementTo Client------------");
			System.out.println("Api_Key:" + infosClient.getApi_key());
			System.out.println("StoreId:" + infosClient.getStore_id());
			System.out.println("Prenom:" + infosClient.getFirst_name());
			System.out.println("Nom:" + infosClient.getLast_name());
			System.out.println("Numero Carte:" + infosClient.getCard_number());
			System.out.println("Cvv:" + infosClient.getSecurity_code());
			System.out.println("Annee:" + infosClient.getYear());
			System.out.println("Mois:" + infosClient.getMonth());
			System.out.println("Prix:" + infosClient.getAmount());
		
			
			ReponseSystemePaiementTO reponsePre = new ReponseSystemePaiementTO ();
			System.out.println("----------Preauthorisation en cours------------");
			//on préauthorise les informations du client
			reponsePre = payerDAO.effectuerPreauthorisation(infosClient);			
			System.out.println("transaction Id:" + reponsePre.getTransactionId());
			System.out.println("transaction code:" + reponsePre.getCode());
			
			if (reponsePre.getCode() == 10200){
				
				//On envoie les paramètres à la session pour les garder en buffer
				//pour ensuite pouvoir confirmer le payement
				request.getSession().setAttribute("reponseCode",reponsePre.getCode());
				request.getSession().setAttribute("transactionId", reponsePre.getTransactionId());
				
				return "confPayement.jsp";
			}else


			return "erreurAuthorisation.jsp";
			}
		//si l'achat est confirmé on redirige vers la page de confirmation
		else if (request.getParameter("action").equals("achatConfirme")){

			System.out.println("TRACE Controleur: Btn achatConfirme clicked");
			
			//on vérifie si la carte a été préauthorisée ou non
			int codeAuthorisation = (int) request.getSession().getAttribute("reponseCode");
			int idTransation = (int) request.getSession().getAttribute("transactionId");
			
			if (codeAuthorisation == 10200){
				
				
				
				return "confirmation.jsp";
			}else

			return "erreurAuthorisation.jsp";}
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
		//Si toutes les transactions de la session sont complétés on reviens a l'accueil
		else if (request.getParameter("action").equals("revenirAccueil")){

			System.out.println("TRACE Controleur: Btn revenir a laccueil");
			
			//-----------------Entrer la transaction dans la BD------------------------
			
			
			//doit avoir cree table IdTransactions avec une foreign key vers table Billets
			//pour un idTransation on va possiblement avoir plusieurs spectacles diff/rents.
			int idTransation = (int) request.getSession().getAttribute("transactionId");
			Panier lePanier = (Panier)request.getSession().getAttribute("panier");
			
			//on itere dans le panier achete et on rentre les informations de la facture
			//dans la bd pour garder des traces des transactions client.
			for(int i=0;i<panier.getPanier().length;i++){
				
				String nomSpectacle = panier.getItemAchete(i).getRep().getNomSpectacle();
				String dateSpectacle = panier.getItemAchete(i).getRep().getDate();
				String salleSpectacle = panier.getItemAchete(i).getRep().getSalle();
				int nbBillets = (int)panier.getItemAchete(i).getNbBillets();
				int totalFacture = (int)panier.getTotal();
							
				//inserer dans BD dans table IDTransaction le idTransaction
				//inserer dans BD dans table BilletsAchete sur une ligne avec foreign Key le idTransaction
				//inserer dans BD dans table BilletsAchete le nomSpectacle
				//inserer dans BD dans table BilletsAchete le dateSpectacle
				//inserer dans BD dans table BilletsAchete le salleSpectacle
				//inserer dans BD dans table BilletsAchete le nbBillets
				//inserer dans BD dans table BilletsAchete le totalFacture
									
			}
			
			
			//------------------------------------------------------------------------

			//On Vide le panier pour une autre transaction et on retourne a l'accueil
			Panier myPanier = new Panier();
			request.getSession().setAttribute("panier",myPanier);	

			return "index.jsp"
					
					;}
		//si on désire annuler l'achat
		else if (request.getParameter("action").equals("annuler")){

			System.out.println("TRACE Controleur: Btn annuler clicker");

			//On Vide le panier pour une autre transaction et on retourne a l'accueil
			Panier myPanier = new Panier();
			
			request.getSession().setAttribute("panier",myPanier);	

			return "index.jsp";}else

				return "erreur.jsp";


	}
	//Fin doHandle	

}