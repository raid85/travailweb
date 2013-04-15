package modele;

import java.util.ArrayList;
import java.sql.*;

//la logique pour la bd a ete prise usr le site:
//http://swinbrain.ict.swin.edu.au/wiki/Getting_started_with_SQLite_and_JDBC

public class SpectacleDAO {

	boolean changement=true;

	//public static final String driver = "org.sqlite.JDBC";
	//adresse de la bd locale
	//private static String url = "jdbc:sqlite:C:/bd.sqlite";
	//private static String url = "jdbc:sqlite:F:/EclipseWorkspace/Lab2GTI525/BD/bd.sqlite";
	//private static String url = "jdbc:sqlite:C:/Users/Hani/workspace/Lab2GTI525/BD/bd1.sqlite";
	private static ResultSet resultatBD;

	private BeanSpectacle beanSpectacle;
	private BeanRepresentation beanRepresentation;

	private ArrayList<BeanSpectacle> listeSpectacles = new ArrayList<BeanSpectacle>();
	private ArrayList<BeanRepresentation> listeRepresentations = new ArrayList<BeanRepresentation>();

	ResultSet spectacles;
	ResultSet representations;
	ResultSet factures;

	public SpectacleDAO () {
		//		this.beanSpectacle = new BeanSpectacle() ;
		//		this.listeRepresentations = new ArrayList<BeanRepresentation>();
		//		this.listeSpectacles = new ArrayList<BeanSpectacle>();
		//		try {
		//			populateSpectacles();
		//		} catch (ClassNotFoundException | SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		initBD();
	}

	//Retourne le resultat d<une requ[ete de type sqllite
	//Ouvre l'acces a la bd locale.
	private ResultSet sqlQuerry(String sqlRequest){
//				Connection con = null;
//				ResultSet resSet = null;
//		
//				try{
//					//Load the JDBC driver class dynamically.
//					Class.forName(driver);
//					//System.out.println("Driver Enregistre");
//					con = DriverManager.getConnection(url);
//					//System.out.println("Connection etablie");
//					Statement stmt = con.createStatement();
//		//			stmt.close();
//					resSet = stmt.executeQuery(sqlRequest);
//		//			resSet.close();
//					return 	resSet;
//					
//				}catch(SQLException sqlE){ 
//					sqlE.printStackTrace();
//				}catch(ClassNotFoundException cE){
//					cE.printStackTrace();
//				}
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return 	resSet;
		ResultSet rs = null;
		DbClass db = new DbClass();
		try {
			rs = db.executeQuery(sqlRequest);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConnection();
		return rs;
	}

	private void write(String request){

		//		Connection con = null;
		//		try{
		//			//Load the JDBC driver class dynamically.
		//			Class.forName(driver);
		//			//System.out.println("Driver Enregistre");
		//			con = DriverManager.getConnection(url);
		//			//System.out.println("Connection etablie");
		//			Statement stmt = con.createStatement();
		//			stmt.close();
		//			stmt.executeUpdate(request);
		////			resSet.close();
		//			
		//		}catch(SQLException sqlE){ 
		//			sqlE.printStackTrace();
		//		}catch(ClassNotFoundException cE){
		//			cE.printStackTrace();
		//		}
		//		try {
		//			con.close();
		//		} catch (SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		System.out.println("ECRITURE DANS LA BD!!!!");
		DbClass db = new DbClass();
		try {
			//			Thread.sleep(100);

			db.execute(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConnection();

	}

	private void initBD(){

		System.out.println("INITIALISATION DE LA BD");
		ArrayList<String> drop= new ArrayList<String>();
		ArrayList<String> table= new ArrayList<String>();
		ArrayList<String> insert= new ArrayList<String>();
		
		
		drop.add("drop table Spectacle");
		drop.add("drop table Representation");
		drop.add("drop table Facture");
		
		table.add("create table Spectacle (id INTEGER PRIMARY KEY, nom TEXT, thumbnail TEXT, poster TEXT, description TEXT)");
		table.add("create table Representation (nom TEXT, prix NUMERIC, billets NUMERIC, salle TEXT, date TEXT, id INTEGER PRIMARY KEY)");
		table.add("create table Facture (noTransaction NUMERIC, total NUMERIC, vendus NUMERIC, salle TEXT, date TEXT, nom TEXT, id INTEGER PRIMARY KEY)");
		
		insert.add("insert into spectacle (id, nom, thumbnail, poster, description) values (1, 'Georges St-Pierre', './images/templatemo_image_03c.jp', './images/templatemo_image_03.jpg', 'Combat de Georges St-Pierre vs BJ Penn. À ne pas manquer. Lequel survivera????')");
		insert.add("insert into spectacle (id, nom, thumbnail, poster, description) values (2, 'Cirque du soleil: Amaluna', './images/templatemo_image_04c.jpg', './images/templatemo_image_04b.jpg', 'On aime le cirque quand il y a des animaux. Mais ce nest pas gentil pour les animaux, alors ce seront des humains qui remplaceront les singes.')");
		insert.add("insert into representation (nom, prix, billets, salle, date) values ('Georges St-Pierre', 100, 162, 'Bruno Payette Est', '23 Juin 2013')");
		insert.add("insert into representation (nom, prix, billets, salle, date) values ('Cirque du soleil: Amaluna', 190, 234, 'Ti-Guy Clément', '12 Mai 2013')");
		insert.add("insert into representation (nom, prix, billets, salle, date) values ('Cirque du soleil: Amaluna', 200, 18, 'Super Man', '14 MAI 2013')");

		for (int i=0;i<drop.size();i++){
			write(drop.get(i).toString());
		}
		for (int i=0;i<table.size();i++){
			write(table.get(i).toString());
		}
		for (int i=0;i<insert.size();i++){
			write(insert.get(i).toString());
		}


		spectacles=sqlQuerry("select * from spectacle");
		representations=sqlQuerry("select * from representation");
		factures=sqlQuerry("select * from facture");
	}

	//on garde une copie des tables pour en faire une comparaison plus tard


	//classe qui s'occupe de populer la liste de spectacle dans leur liste respectives
	//de spectacles et représentations
	private void populateSpectacles() throws ClassNotFoundException, SQLException {

		//comparaison avec les valeurs plus haut, si il y a eu changement dans la BD
		//on affecte la valeur "changement"

		if(!spectacles.getObject(1).equals(sqlQuerry("select * from spectacle").getObject(1))){
			changement=true;
			System.out.println("CHANGEMENT DE SPECTACLES MIS À FALSE");
		}
		if(!representations.getObject(1).equals(sqlQuerry("select * from representation").getObject(1))){
			changement=true;
			System.out.println("CHANGEMENT DE REPRESENTATIONS MIS À FALSE");
		}

		try {
			if(!factures.getObject(1).equals(sqlQuerry("select * from facture").getObject(1))){
				changement=true;
				System.out.println("CHANGEMENT DE FACTURES MIS À FALSE");
				updateDB(); //s'il y a facture, on met à jour les données des représentations
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("DB: Factures vide.");
		}

		System.out.println("PREMIER ACCÈS");

		//au début, "changement" est a true donc cette condition sera respectée
		//ensuite, s'il y a eu des changements dans la BD, cette condition sera également respectée
		//si la BD n'a pas changée, cette condition ne sera pas respectée
		if(changement){

			System.out.println("DEUXIEME ACCÈS");


			//boucle qui regarde combien de spectacles il y a dans la BD
			for (int j=1; j<=getNbSpectacles(); j++){

				//prend le nom du spectacle actuel
				String spec=sqlQuerry("select nom from spectacle where id="+j).getString(1);

				//prend le id de la représentation qui contient le même nom que le spectacle actuel
				resultatBD =sqlQuerry("select id from representation where representation.nom like '"+spec+"'");

				//tant qu'il y a des représentation du même nom que le spectacle actuel
				while(resultatBD.next()){



					//remplir les beans et l'ajouter à la liste des représentation
					int idREP=resultatBD.getInt(1);
					System.out.println("idREP="+idREP);
					beanRepresentation = new BeanRepresentation();
					beanRepresentation.setId(sqlQuerry("select id from representation where representation.id="+idREP).getInt(1));
					beanRepresentation.setBilletsDispo(sqlQuerry("select billets from representation where representation.id="+idREP).getInt(1));
					beanRepresentation.setNomSpectacle(sqlQuerry("select nom from representation where representation.id="+idREP).getString(1));
					beanRepresentation.setPrix(sqlQuerry("select prix from representation where representation.id="+idREP).getInt(1));
					beanRepresentation.setSalle(sqlQuerry("select salle from representation where representation.id="+idREP).getString(1));
					beanRepresentation.setDate(sqlQuerry("select date from representation where representation.id="+idREP).getString(1));
					listeRepresentations.add(beanRepresentation);
				}

				//traiter le bean du spectacle et l'ajouter à la liste des spectacles
				beanSpectacle = new BeanSpectacle();
				beanSpectacle.setId(sqlQuerry("select id from spectacle where spectacle.id="+j).getInt(1));
				beanSpectacle.setNom(sqlQuerry("select nom from spectacle where spectacle.id="+j).getString(1));
				beanSpectacle.setThumbnail(sqlQuerry("select thumbnail from spectacle where spectacle.id="+j).getString(1));
				beanSpectacle.setPoster(sqlQuerry("select poster from spectacle where spectacle.id="+j).getString(1));
				beanSpectacle.setDescription(sqlQuerry("select description from spectacle where spectacle.id="+j).getString(1));	
				beanSpectacle.setListeRepresentations(listeRepresentations);
				listeSpectacles.add(beanSpectacle);
				System.out.println("J="+j);
				this.listeRepresentations = new ArrayList<BeanRepresentation>();
			}
			//quand on termine le chargement des données de la BD, il n'est plus nécessaire
			//d'y accéder et de recharger le tout à moins d'un changement.
			changement=false;

			//met a jour la copie courante pour vérification ultérieure
			spectacles=sqlQuerry("select * from spectacle");
			representations=sqlQuerry("select * from representation");
			factures=sqlQuerry("select * from facture");
		}

		//		//Instanciation du Bean
		//		beanRepresentation = new BeanRepresentation();
		//
		//		//Création du Bean
		//		beanRepresentation.setId(2);
		//		beanRepresentation.setBilletsDispo(162);
		//		beanRepresentation.setNomSpectacle("Georges St-Pierre");
		//		beanRepresentation.setPrix(100);
		//		beanRepresentation.setSalle("Bruno Payette Est");
		//		beanRepresentation.setDate("23 Juin 2013");
		//
		//		//on ajoute le bean à la liste	
		//		listeRepresentations.add(beanRepresentation);
		//
		//		//***----------------------------*******
		//		//      Exemple comment accéder a la bd
		//		//***----------------------------*******
		//		
		//		resultatBD = sqlQuerry("SELECT Spectacles.Nom FROM Spectacles DSWHERE Spectacles.Id_Spectacle = 1");
		//		System.out.println("TRACE" + resultatBD.getString(1));   
		//
		//		try
		//		 {
		//			
		//				String fName;
		//	            while(resultatBD.next())
		//	            {
		//	                fName = resultatBD.getString(1);
		//	                
		//	                System.out.println("2222 BD ***********/////////-:" + fName);
		//	            }
		//	        }
		//	        catch(Exception e)
		//	        {
		//	            System.out.println("Error processing results: " + e.toString());
		//	        }   
		//		
		//		//******************************************
		//		//****---------------Fin Example-----------
		//		
		//		
		//		//Instanciation du Bean		
		//		beanSpectacle = new BeanSpectacle();
		//
		//		//Création du Bean
		//		beanSpectacle.setId(1);
		//		beanSpectacle.setNom("Georges St-Pierre");
		//		beanSpectacle.setThumbnail("./images/templatemo_image_03c.jpg");
		//		beanSpectacle.setPoster("./images/templatemo_image_03.jpg");
		//		beanSpectacle.setDescription("Combat de Georges St-Pierre vs BJ Penn. À ne pas manquer. Lequel survivera?");	
		//		beanSpectacle.setListeRepresentations(listeRepresentations);
		//
		//		//on ajoute le pbean à la liste	
		//		listeSpectacles.add(beanSpectacle);
		//
		//		//ON RESET LA LISTE À Zéro pour l'utiliser pour le prochain spectacle. 
		//		//Dans le prochain BeanSpectacle
		//		this.listeRepresentations = new ArrayList<BeanRepresentation>();
		//
		//		//Instanciation du Bean
		//		beanRepresentation = new BeanRepresentation();
		//		//Création du Bean
		//		//Representation 1
		//		beanRepresentation.setId(1);
		//		beanRepresentation.setBilletsDispo(234);
		//		beanRepresentation.setNomSpectacle("Cirque du soleil: Amaluna");
		//		beanRepresentation.setPrix(190);
		//		beanRepresentation.setSalle("Ti-Guy Clément");
		//		beanRepresentation.setDate("12 Mai 2013");
		//
		//
		//		listeRepresentations.add(beanRepresentation);	
		//
		//		//Instanciation du Bean
		//		beanRepresentation = new BeanRepresentation();
		//		//Création du Bean
		//		//Representation 2
		//		beanRepresentation.setId(2);
		//		beanRepresentation.setBilletsDispo(18);
		//		beanRepresentation.setNomSpectacle("Cirque du soleil: Amaluna");
		//		beanRepresentation.setPrix(200);
		//		beanRepresentation.setSalle("Super Man");
		//		beanRepresentation.setDate("14 MAI 2013");
		//
		//		//on ajoute le bean à la liste	
		//		listeRepresentations.add(beanRepresentation);	
		//
		//		//Instanciation du Bean
		//		beanSpectacle = new BeanSpectacle();
		//		//Création du Bean
		//		beanSpectacle.setId(1);
		//		beanSpectacle.setNom("Cirque du soleil: Amaluna");
		//		beanSpectacle.setThumbnail("./images/templatemo_image_04c.jpg");
		//		beanSpectacle.setPoster("./images/templatemo_image_04b.jpg");
		//		beanSpectacle.setDescription("On aime le cirque quand il y a des animaux. Mais ce n'est pas gentil pour les animaux, alors ce seront des humains qui remplaceront les singes.");	
		//		beanSpectacle.setListeRepresentations(listeRepresentations);
		//
		//		//on ajoute le bean à la liste	
		//		listeSpectacles.add(beanSpectacle);

		System.out.println("TRACE SpectacleDAO: " + "Liste Spectacles a été populée");

	}

	public void ajouterFacture(int idTransation, String nomSpectacle, String dateSpectacle, String salleSpectacle, int nbBillets, int totalFacture){
		//insert into facture(nom,date,salle,vendus,total,noTransaction) values ('hello','hello','hello',34,55,2345)

		write("insert into facture(nom,date,salle,vendus,total,noTransaction) values ('"+nomSpectacle+"','"+dateSpectacle+"','"+salleSpectacle+"',"+nbBillets+","+totalFacture+","+idTransation+")");

	}

	public void updateDB() throws SQLException{

		//si table facture est pas vide
		if(sqlQuerry("select * from facture")!=null){

			//au nombre de représentation qu'il y a dans la BD
			for (int i=0;i<sqlQuerry("select count (*) from representation").getInt(1);i++){

				//prendre les factures de cette représentation
				String nom =   sqlQuerry("select nom from representation where id="+i).getString(1);
				String date =  sqlQuerry("select date from representation where id="+i).getString(1);
				String salle = sqlQuerry("select salle from representation where id="+i).getString(1);
				ResultSet rs = sqlQuerry("select * from facture where facture.nom like '"+nom+"' and facture.date like '"+date+"' and facture.salle like '"+salle+"'");

				//et mettre a jour le nombre de billets restant pour cette représentation
				while(rs.next()){
					int idFactActuelle=rs.getInt(7);
					int nbBillets=sqlQuerry("select billets from representation where id="+i).getInt(1) - sqlQuerry("select vendus from facture where id="+idFactActuelle).getInt(1);
					//update le nombre de billets
					write("update representation set billets="+nbBillets+" where id="+i);
				}
			}
		}
	}

	private int getNbSpectacles() throws SQLException{
		return sqlQuerry("select count (*) from spectacle").getInt(1);
	}

	public BeanSpectacle getBeanSpectacle() throws ClassNotFoundException, SQLException {
		return beanSpectacle;
	}

	public ArrayList<BeanSpectacle> getSpectacles()throws ClassNotFoundException, SQLException {
		populateSpectacles();
		return listeSpectacles;
	}



}
