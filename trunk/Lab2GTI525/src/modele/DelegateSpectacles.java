package modele;

import java.sql.SQLException;
import java.util.ArrayList;



public class DelegateSpectacles {

	
	SpectacleDAO daoSpectacle =  new SpectacleDAO(); 
	ArrayList<BeanSpectacle> listeSpectacles = new ArrayList<>();
	
	
	public ArrayList<BeanSpectacle> getSpectacles()throws ClassNotFoundException, SQLException {
		
		return this.daoSpectacle.getSpectacles();
		
		
	
	}
	
	
	
}
