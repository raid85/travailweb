package modele;

import java.util.ArrayList;
import java.util.Date;

public class BeanRepresentation {
	
	private int id;
	private String date; //Date deprecated
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String salle;
	private int billetsDispo;
	private double prix;
	private String nomSpectacle;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public int getBilletsDispo() {
		return billetsDispo;
	}
	public void setBilletsDispo(int billetsDispo) {
		this.billetsDispo = billetsDispo;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNomSpectacle() {
		return nomSpectacle;
	}
	public void setNomSpectacle(String nomSpectacle) {
		this.nomSpectacle = nomSpectacle;
	}
	
	
	
	
	

}
