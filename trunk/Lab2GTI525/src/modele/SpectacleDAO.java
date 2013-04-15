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
		initBD();
	}

	//Retourne le resultat d<une requ[ete de type sqllite
	//Ouvre l'acces a la bd locale.
	private ResultSet sqlQuerry(String sqlRequest){
		
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

		ArrayList<String> drop= new ArrayList<String>();
		ArrayList<String> table= new ArrayList<String>();
		ArrayList<String> insert= new ArrayList<String>();
		
		
		drop.add("drop table Spectacle");
		drop.add("drop table Representation");
		drop.add("drop table Facture");
		
		table.add("create table Spectacle (id INTEGER PRIMARY KEY, nom TEXT, thumbnail TEXT, poster TEXT, description TEXT)");
		table.add("create table Representation (nom TEXT, prix NUMERIC, billets NUMERIC, salle TEXT, date TEXT, id INTEGER PRIMARY KEY)");
		table.add("create table Facture (noTransaction NUMERIC, total NUMERIC, vendus NUMERIC, salle TEXT, date TEXT, nom TEXT, id INTEGER PRIMARY KEY)");
		
		insert.add("insert into spectacle (id, nom, thumbnail, poster, description) values (1, 'Georges St-Pierre', './images/templatemo_image_03c.jp', './images/templatemo_image_03.jpg', 'Combat de Georges St-Pierre vs BJ Penn. � ne pas manquer. Lequel survivera????')");
		insert.add("insert into spectacle (id, nom, thumbnail, poster, description) values (2, 'Cirque du soleil: Amaluna', './images/templatemo_image_04c.jpg', './images/templatemo_image_04b.jpg', 'On aime le cirque quand il y a des animaux. Mais ce nest pas gentil pour les animaux, alors ce seront des humains qui remplaceront les singes.')");
		insert.add("insert into representation (nom, prix, billets, salle, date) values ('Georges St-Pierre', 100, 162, 'Bruno Payette Est', '23 Juin 2013')");
		insert.add("insert into representation (nom, prix, billets, salle, date) values ('Cirque du soleil: Amaluna', 190, 234, 'Ti-Guy Cl�ment', '12 Mai 2013')");
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
	//de spectacles et repr�sentations
	private void populateSpectacles() throws ClassNotFoundException, SQLException {

		//comparaison avec les valeurs plus haut, si il y a eu changement dans la BD
		//on affecte la valeur "changement"

		if(!spectacles.getObject(1).equals(sqlQuerry("select * from spectacle").getObject(1))){
			changement=true;
			System.out.println("CHANGEMENT DE SPECTACLES MIS � FALSE");
		}
		if(!representations.getObject(1).equals(sqlQuerry("select * from representation").getObject(1))){
			changement=true;
			System.out.println("CHANGEMENT DE REPRESENTATIONS MIS � FALSE");
		}

		try {
			if(!factures.getObject(1).equals(sqlQuerry("select * from facture").getObject(1))){
				changement=true;
				System.out.println("CHANGEMENT DE FACTURES MIS � FALSE");
				updateDB(); //s'il y a facture, on met � jour les donn�es des repr�sentations
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("DB: Factures vide.");
		}

		//System.out.println("PREMIER ACC�S");

		//au d�but, "changement" est a true donc cette condition sera respect�e
		//ensuite, s'il y a eu des changements dans la BD, cette condition sera �galement respect�e
		//si la BD n'a pas chang�e, cette condition ne sera pas respect�e
		if(changement){

			//System.out.println("DEUXIEME ACC�S");


			//boucle qui regarde combien de spectacles il y a dans la BD
			for (int j=1; j<=getNbSpectacles(); j++){

				//prend le nom du spectacle actuel
				String spec=sqlQuerry("select nom from spectacle where id="+j).getString(1);

				//prend le id de la repr�sentation qui contient le m�me nom que le spectacle actuel
				resultatBD =sqlQuerry("select id from representation where representation.nom like '"+spec+"'");

				//tant qu'il y a des repr�sentation du m�me nom que le spectacle actuel
				while(resultatBD.next()){



					//remplir les beans et l'ajouter � la liste des repr�sentation
					int idREP=resultatBD.getInt(1);
					beanRepresentation = new BeanRepresentation();
					beanRepresentation.setId(sqlQuerry("select id from representation where representation.id="+idREP).getInt(1));
					beanRepresentation.setBilletsDispo(sqlQuerry("select billets from representation where representation.id="+idREP).getInt(1));
					beanRepresentation.setNomSpectacle(sqlQuerry("select nom from representation where representation.id="+idREP).getString(1));
					beanRepresentation.setPrix(sqlQuerry("select prix from representation where representation.id="+idREP).getInt(1));
					beanRepresentation.setSalle(sqlQuerry("select salle from representation where representation.id="+idREP).getString(1));
					beanRepresentation.setDate(sqlQuerry("select date from representation where representation.id="+idREP).getString(1));
					listeRepresentations.add(beanRepresentation);
				}

				//traiter le bean du spectacle et l'ajouter � la liste des spectacles
				beanSpectacle = new BeanSpectacle();
				beanSpectacle.setId(sqlQuerry("select id from spectacle where spectacle.id="+j).getInt(1));
				beanSpectacle.setNom(sqlQuerry("select nom from spectacle where spectacle.id="+j).getString(1));
				beanSpectacle.setThumbnail(sqlQuerry("select thumbnail from spectacle where spectacle.id="+j).getString(1));
				beanSpectacle.setPoster(sqlQuerry("select poster from spectacle where spectacle.id="+j).getString(1));
				beanSpectacle.setDescription(sqlQuerry("select description from spectacle where spectacle.id="+j).getString(1));	
				beanSpectacle.setListeRepresentations(listeRepresentations);
				listeSpectacles.add(beanSpectacle);
				this.listeRepresentations = new ArrayList<BeanRepresentation>();
			}
			//quand on termine le chargement des donn�es de la BD, il n'est plus n�cessaire
			//d'y acc�der et de recharger le tout � moins d'un changement.
			changement=false;

			//met a jour la copie courante pour v�rification ult�rieure
			spectacles=sqlQuerry("select * from spectacle");
			representations=sqlQuerry("select * from representation");
			factures=sqlQuerry("select * from facture");
		}


		System.out.println("TRACE SpectacleDAO: " + "Liste Spectacles a �t� popul�e");

	}

	public void ajouterFacture(int idTransation, String nomSpectacle, String dateSpectacle, String salleSpectacle, int nbBillets, int totalFacture){
		//insert into facture(nom,date,salle,vendus,total,noTransaction) values ('hello','hello','hello',34,55,2345)

		write("insert into facture(nom,date,salle,vendus,total,noTransaction) values ('"+nomSpectacle+"','"+dateSpectacle+"','"+salleSpectacle+"',"+nbBillets+","+totalFacture+","+idTransation+")");

	}

	public void updateDB() throws SQLException{

		//si table facture est pas vide
		if(sqlQuerry("select * from facture")!=null){

			//au nombre de repr�sentation qu'il y a dans la BD
			for (int i=0;i<sqlQuerry("select count (*) from representation").getInt(1);i++){

				//prendre les factures de cette repr�sentation
				String nom =   sqlQuerry("select nom from representation where id="+i).getString(1);
				String date =  sqlQuerry("select date from representation where id="+i).getString(1);
				String salle = sqlQuerry("select salle from representation where id="+i).getString(1);
				ResultSet rs = sqlQuerry("select * from facture where facture.nom like '"+nom+"' and facture.date like '"+date+"' and facture.salle like '"+salle+"'");

				//et mettre a jour le nombre de billets restant pour cette repr�sentation
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
