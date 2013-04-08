package modele;


import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sun.net.www.protocol.http.HttpURLConnection;


public class PaiementDAO implements IPaiementDAO{


	private String baseUrl = "http://gti525.herokuapp.com/transactions";
	JSONParser parser = new JSONParser();
	
	
	@Override
	public ReponseSystemePaiementTO approuverTransaction(RequeteAuthorisationTO requeteAutorisationTO) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
        URL url = null;
        String link = baseUrl + "/"+requeteAutorisationTO.getTransaction_id()+".json?" +
				"api_key="		+ requeteAutorisationTO.getApi_key() 		+ 	
				"&store_id=" 	+ requeteAutorisationTO.getStore_id()		;
        System.out.println(link);
				
		try {
				url = new URL(link);
		        URLConnection conn = url.openConnection();
		        ((HttpURLConnection) conn).setRequestMethod("GET");
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		       
		        String jsonString="";
		        String line; while ((line = in.readLine()) != null) {
		            jsonString += line;
		        }
		        JSONObject  jsonObject = (JSONObject) parser.parse( jsonString );	
		        jsonObject =  (JSONObject) jsonObject.get("order");
		        
		        String status = (String) jsonObject.get("status");
		        if (status.equals("Completed")) {
	            	reponse.setMessage(jsonObject.get("messages").toString());	            	
			        reponse.setCode((Integer.valueOf(jsonObject.get("code").toString())));
			        reponse.setTransactionId(Integer.valueOf(jsonObject.get("transaction_id").toString()));
			        reponse.setStatus(jsonObject.get("status").toString());
	            }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return reponse;	
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(InformationsPaiementTO informationPaiementTO) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
        URL url = null;
        String link = baseUrl + ".json?" +
				"api_key="		+ informationPaiementTO.getApi_key() 		+ 	
				"&order_id="		+ informationPaiementTO.getOrder_id() 	+ 	
				"&store_id=" 	+ informationPaiementTO.getStore_id()		+
				"&amount="		+ informationPaiementTO.getAmount()			+
				"&first_name="	+ informationPaiementTO.getFirst_name()		+ 
				"&last_name="	+ informationPaiementTO.getLast_name()		+
				"&card_number="	+ informationPaiementTO.getCard_number()	+
				"&security_code="+ informationPaiementTO.getSecurity_code()	+
				"&year="			+ informationPaiementTO.getYear()		+
				"&month="		+ informationPaiementTO.getMonth();
		try {
				url = new URL(link);
		        URLConnection conn = url.openConnection();
		        ((HttpURLConnection) conn).setRequestMethod("POST");
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		       
		        String jsonString="";
		        String line; while ((line = in.readLine()) != null) {
		            jsonString += line;
		        }
		        JSONObject  jsonObject = (JSONObject) parser.parse( jsonString );	
		        jsonObject =  (JSONObject) jsonObject.get("order");
		        
		        String status = (String) jsonObject.get("status");
		        if (status.equals("Accepted")) {
	            	reponse.setMessage( jsonObject.get("messages").toString());	            	
			        reponse.setCode((Integer.valueOf(jsonObject.get("code").toString())));
			        reponse.setTransactionId(Integer.valueOf(jsonObject.get("transaction_id").toString()));
			        reponse.setStatus( jsonObject.get("status").toString());
	            }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return reponse;
	}
	
	

	
	

}
