package modele;

import java.util.ArrayList;




public class BeanSpectacle implements java.io.Serializable {
	private static final long serialVersionUID =2564879856102345789L;

	private int id;
	private String nom;
	private String thumbnail;
	private String poster;
	private String description;
	private ArrayList<BeanRepresentation> listeRepresentations = new ArrayList<BeanRepresentation>(); //popupléée par plusieurs BeanRepresentation
	
	public int getId() {
		return id;
	}
	public void setId(int iden) {
		id = iden;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public ArrayList<BeanRepresentation> getListeRepresentations() {
		return listeRepresentations;
	}
	public void setListeRepresentations(ArrayList<BeanRepresentation> listeRepresentations) {
		this.listeRepresentations = listeRepresentations;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
