package modele;

import java.util.ArrayList;
import java.sql.*;

//la logique pour la bd a ete prise usr le site:
//http://swinbrain.ict.swin.edu.au/wiki/Getting_started_with_SQLite_and_JDBC

public class SpectacleDAO {



	//FIXME: Ceci devrait [etre fourni dans un config file et no pas harcode
	public static final String driver = "org.sqlite.JDBC";
	//adresse de la bd locale
	private static String url = "jdbc:sqlite:C:/Users/Hani/workspace/Lab2GTI525/BD/bd.sqlite";
	private static ResultSet resultatBD;
	
	private BeanSpectacle beanSpectacle ;
	private BeanRepresentation beanRepresentation;

	private ArrayList<BeanSpectacle> listeSpectacles;
	private ArrayList<BeanRepresentation> listeRepresentations;

	public SpectacleDAO () {
		this.beanSpectacle = new BeanSpectacle() ;
		this.listeRepresentations = new ArrayList<BeanRepresentation>();
		this.listeSpectacles = new ArrayList<BeanSpectacle>();
		try {
			populateSpectacles();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Retourne le resultat d<une requ[ete de type sqllite
	//Ouvre l'acces a la bd locale.
	private static ResultSet sqlQuerry(String sqlRequest){
		
		ResultSet resSet = null;
		
		try{
		//Load the JDBC driver class dynamically.
		Class.forName(driver);
		System.out.println("Driver Enregistre");
		Connection con = DriverManager.getConnection(url);
		System.out.println("Connection etablie");
		Statement stmt = con.createStatement();
		stmt.close();
		resSet = stmt.executeQuery(sqlRequest);
		return 	resSet;
		}catch(SQLException sqlE){ sqlE.printStackTrace();}
		catch(ClassNotFoundException cE){cE.printStackTrace();}
		try {
			System.out.println(resSet.getObject(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 	resSet;
		
	}




	//Vu que c<est un stub, c<est ici que noupopulerons manuellement les beans BeansSpectacle
	//Dans un Bean Spectacle il y a un tableau de BeanRepresentation
	//Tous les beans sont crée manuellement "HARCODE" en attendant le lab 3

	private void populateSpectacles() throws ClassNotFoundException, SQLException {

		//Instanciation du Bean
		beanRepresentation = new BeanRepresentation();

		//Création du Bean
		beanRepresentation.setId(2);
		beanRepresentation.setBilletsDispo(162);
		beanRepresentation.setNomSpectacle("Georges St-Pierre");
		beanRepresentation.setPrix(100);
		beanRepresentation.setSalle("Bruno Payette Est");
		beanRepresentation.setDate("23 Juin 2013");

		//on ajoute le bean à la liste	
		listeRepresentations.add(beanRepresentation);

		//***----------------------------*******
		//      Exemple comment accéder a la bd
		//***----------------------------*******
		
//		resultatBD = sqlQuerry("SELECT Spectacles.Nom FROM Spectacles WHERE Spectacles.Id_Spectacle = 1");
//		System.out.println("TRACE" + resultatBD.getString(1));   
		
		try
		 {
			
				String fName;
	            while(resultatBD.next())
	            {
	                fName = resultatBD.getString(1);
	                
	                System.out.println("2222 BD ***********/////////-:" + fName);
	            }
	        }
	        catch(Exception e)
	        {
	            System.out.println("Error processing results: " + e.toString());
	        }   
		
		//******************************************
		//****---------------Fin Example-----------
		
		
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
		beanRepresentation.setBilletsDispo(18);
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
		beanSpectacle.setNom("Cirque du soleil: Amaluna");
		beanSpectacle.setThumbnail("./images/templatemo_image_04c.jpg");
		beanSpectacle.setPoster("./images/templatemo_image_04b.jpg");
		beanSpectacle.setDescription("On aime le cirque quand il y a des animaux. Mais ce n'est pas gentil pour les animaux, alors ce seront des humains qui remplaceront les singes.");	
		beanSpectacle.setListeRepresentations(listeRepresentations);

		//on ajoute le bean à la liste	
		listeSpectacles.add(beanSpectacle);

		System.out.println("TRACE SpectacleDAO: " + "Liste Spectacles a été populéee");

	}

	public BeanSpectacle getBeanSpectacle() throws ClassNotFoundException, SQLException {
		return beanSpectacle;
	}

	public ArrayList<BeanSpectacle> getSpectacles()throws ClassNotFoundException, SQLException {

		return listeSpectacles;
	}



}
