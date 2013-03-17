package modele;

import java.util.Date;

public class itemAchete {

	private BeanRepresentation rep;
	private int nbBillets;
	
	public BeanRepresentation getRep() {
		return rep;
	}
	public void setRep(BeanRepresentation rep) {
		this.rep = rep;
	}
	public int getNbBillets() {
		return nbBillets;
	}
	public void setNbBillets(int nbBillets) {
		this.nbBillets = nbBillets;
	}
	
	public itemAchete(BeanRepresentation beanRep, int nbBilletsAchete){
		
		this.rep = beanRep;
		this.nbBillets = nbBilletsAchete;
		
	}
	

	public double getTotal(){
		
		return nbBillets * rep.getPrix();
	}
}
