package modele;

import java.net.URL;
import java.net.URLConnection;
import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

public class PaiementDAO implements IPaiementDAO{

	

	private String rootLink = "http://gti525.herokuapp.com/transactions";
	
	
	
	@Override
	public ReponseSystemePaiementTO approuverTransaction(RequeteAuthorisationTO requeteAutorisationTO) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
        URL url = null;
        reponse.setMessage("Passed");//pour tester le reste
       
		return reponse;	
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(InformationsPaiementTO informationPaiementTO) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
        URL url = null;
        
        reponse.setMessage("Passed");//pour tester le reste
        
        
		return reponse;
	}
	
	

	
	
	
}
