package modele;

import java.util.ArrayList;



public class DelegateSpectacles {

	
	SpectacleDAO daoSpectacle =  new SpectacleDAO(); 
	ArrayList<BeanSpectacle> listeSpectacles = new ArrayList<>();
	
	
	public ArrayList<BeanSpectacle> getSpectacles(){
		
		return this.daoSpectacle.getSpectacles();
		
		
	
	}
	
	
	
}
