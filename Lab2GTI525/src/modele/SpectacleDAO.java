package modele;

public class SpectacleDAO {

	

	private BeanSpectacle beanSpectacle ;
	

	public SpectacleDAO (){
		this.beanSpectacle = new BeanSpectacle() ;
		
	}


////À revérifier
	
	public BeanSpectacle createSpectacle (int id, String nom, String thumbnail ,String poster, String description, BeanRepresentation[] listeRepresentations) {
	
		beanSpectacle.setId(id);
		beanSpectacle.setNom(nom);
		beanSpectacle.setThumbnail(thumbnail);
		beanSpectacle.setPoster(poster);
		beanSpectacle.setDescription(description);
		beanSpectacle.setListeRepresentations(listeRepresentations);
	
		//		System.out.println("TRACE nom du spectacle : " + beanSpectacle.getNom());

		
		return beanSpectacle ;

		
	}

	public BeanSpectacle getBeanSpectacle() {
		return beanSpectacle;
	}


	
}
