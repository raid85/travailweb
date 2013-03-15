package modele;

import java.util.ArrayList;

public class SpectacleDAO {


	private BeanSpectacle beanSpectacle ;
	private BeanRepresentation beanRepresentation;

	private ArrayList<BeanSpectacle> listeSpectacles;
	private ArrayList<BeanRepresentation> listeRepresentations;

	public SpectacleDAO (){
		this.beanSpectacle = new BeanSpectacle() ;
		this.listeRepresentations = new ArrayList<BeanRepresentation>();
		this.listeSpectacles = new ArrayList<BeanSpectacle>();
		populateSpectacles();
	}



	//Vu que c<est un stub, c<est ici que noupopulerons manuellement les beans BeansSpectacle
	//Dans un Bean Spectacle il y a un tableau de BeanRepresentation
	//Tous les beans sont crée manuellement "HARCODE" en attendant le lab 3
	
	private void populateSpectacles() {

		//Instanciation du Bean
		beanRepresentation = new BeanRepresentation();
		
		//Création du Bean
		beanRepresentation.setId(2);
		beanRepresentation.setBilletsDispo(234);
		beanRepresentation.setNomSpectacle("Georges St-Pierre");
		beanRepresentation.setPrix(100);
		beanRepresentation.setSalle("Bruno Payette Est");
		beanRepresentation.setDate("23 Juin 2013");
		
		//on ajoute le bean à la liste	
		listeRepresentations.add(beanRepresentation);
	
		//Instanciation du Bean		
		beanSpectacle = new BeanSpectacle();
		
		//Création du Bean
		beanSpectacle.setId(1);
		beanSpectacle.setNom("Georges St-Pierre");
		beanSpectacle.setThumbnail("./images/templatemo_image_03c.jpg");
		beanSpectacle.setPoster("./images/templatemo_image_03.jpg");
		beanSpectacle.setDescription("Combat de Georges St-Pierre vs BJ Penn. À ne pas manquer. Lequel survivera?");	
		beanSpectacle.setListeRepresentations(listeRepresentations);
		
		//on ajoute le pbean à la liste	
		listeSpectacles.add(beanSpectacle);
		
		//ON RESET LA LISTE À Zéro pour l'utiliser pour le prochain spectacle. 
		//Dans le prochain BeanSpectacle
		this.listeRepresentations = new ArrayList<BeanRepresentation>();
		
		//Instanciation du Bean
		beanRepresentation = new BeanRepresentation();
		//Création du Bean
		//Representation 1
		beanRepresentation.setId(1);
		beanRepresentation.setBilletsDispo(234);
		beanRepresentation.setNomSpectacle("Cirque du soleil: Amaluna");
		beanRepresentation.setPrix(190);
		beanRepresentation.setSalle("Ti-Guy Clément");
		beanRepresentation.setDate("12 Mai 2013");
		

		listeRepresentations.add(beanRepresentation);	
		
		//Instanciation du Bean
		beanRepresentation = new BeanRepresentation();
		//Création du Bean
		//Representation 2
		beanRepresentation.setId(2);
		beanRepresentation.setBilletsDispo(234);
		beanRepresentation.setNomSpectacle("Cirque du soleil: Amaluna");
		beanRepresentation.setPrix(200);
		beanRepresentation.setSalle("Super Man");
		beanRepresentation.setDate("14 MAI 2013");
		
		//on ajoute le bean à la liste	
		listeRepresentations.add(beanRepresentation);	
		
		//Instanciation du Bean
		beanSpectacle = new BeanSpectacle();
		//Création du Bean
		beanSpectacle.setId(1);
		beanSpectacle.setNom("Amaluna");
		beanSpectacle.setThumbnail("./images/templatemo_image_04c.jpg");
		beanSpectacle.setPoster("./images/templatemo_image_04b.jpg");
		beanSpectacle.setDescription("On aime le cirque quand il y a des animaux. Mais ce n'est pas gentil pour les animaux, alors ce seront des humains qui remplaceront les singes.");	
		beanSpectacle.setListeRepresentations(listeRepresentations);
		
		//on ajoute le bean à la liste	
		listeSpectacles.add(beanSpectacle);

		System.out.println("TRACE SpectacleDAO: " + "Liste Spectacles a été populéee");

	}

	public BeanSpectacle getBeanSpectacle() {
		return beanSpectacle;
	}

	public ArrayList<BeanSpectacle> getSpectacles(){

		return listeSpectacles;
	}



}
