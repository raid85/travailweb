package modele;

import java.util.ArrayList;

public class Panier {

	//on construit le panier avec une liste d<items achetes
	ArrayList<itemAchete> panier = new ArrayList<itemAchete>();
	
	//constructeur vide pour le controleur a etre utilise
	public Panier(){
		
	}

	public Panier(BeanRepresentation rep, int nbBilletsRep){
		
		panier.add(new itemAchete(rep, nbBilletsRep));
	}
	
	//retourne le panier au complet
	public itemAchete[] getPanier(){
		
		itemAchete[] lepanier = new itemAchete[this.panier.size()];
		
		for(int i=0;i<panier.size();i++){
			
			lepanier[i] = this.panier.get(i);
		}
		
		
		return lepanier;
		
	}
	
	//retourne un item du panier
	public itemAchete getItemAchete(int pos){
		
	return this.panier.get(pos);
	}
	
	//ajoute un item au panier
	public void ajouterItem(BeanRepresentation rep, int nbBilletsRep){
		
		panier.add(new itemAchete(rep, nbBilletsRep));
	}
	
	//returne si le panier est vide
	public boolean estVide(){
		
		boolean bool = true;
		if (this.panier.size()<=1){
			return bool;
		} 
		else{
			bool = false;
			return bool;
		}
		
	}	
		
	public double getTotal(){
		
		double total = 0;
		
		for(int i=0; i<panier.size();i++){

			total = total + panier.get(i).getTotal();
		}
		
		return total;
	}	
		
	
	
}
