<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BILLETSONLINE</title>
<meta name="keywords" content="billets,en-ligne,online,spectacles,representations,montreal" />
<meta name="description" content="This website serves as an interface for searching and buying show tickets online made for the course GTI525" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
<script type="text/javascript" language="JavaScript">
function AskAndSubmit(t)
{
  var answer = confirm("Vous etes surs de vouloir completer votre achat? Cette opération est irréversible");
  if (answer)
  {
    t.form.submit();
  }else{
	  return false;
  }


	
}
//Code pris du site web ci-dessous, pour utiliser dans le cadre de notre cours de GTI525
       //http://stackoverflow.com/questions/293648/display-confirmation-popup-with-javascript-upon-clicking-on-a-link
	   //-->
  </script>
  
  <script type="text/javascript" language="JavaScript">
  function valideChamps() {
	  

  	var nomClient = document.form.nomClient;
	var prenomClient = document.form.prenomClient;
	var emailClient = document.form.emailClient;
	var nrCarte = document.form.nrCarte;
	var moisExp = document.form.moisExp;
	var anExp = document.form.anExp;
	var cvv = document.form.cvv;
	var adresse = document.form.adresse;
	var ville = document.form.ville;
	var prov = document.form.prov;
	var pays = document.form.pays;
	var codep = document.form.codep;

	if ((nomClient.value == "") || (nomClient.value == null)) {
		alert("Veuillez inscrire le nom associe a la carte de credit utilise")
		nomClient.focus();
		return false;
	}
	if ((prenomClient.value == "") || (prenomClient.value == null)) {
		alert("Veuillez inscrire le prenom associe a la carte de credit utilise")
		prenomClient.focus();
		return false;
	}
	if ((emailClient.value == "") || (emailClient.value == null)) {
		alert("Veuillez inscrire une adresse courriel pour vous rejoindre")
		emailClient.focus();
		return false;
	}
	if ((moisExp.value == "") || (moisExp.value == null)) {
		alert("Veuillez inscrire le mois d'expiration de la carte de credit utilise")
		moisExp.focus();
		return false;
	}
	if ((nrCarte.value == "") || (nrCarte.value == null)) {
		alert("Veuillez inscrire le numero de la carte de credit utilise")
		nrCarte.focus();
		return false;
	}
	if ((anExp.value == "") || (anExp.value == null)) {
		alert("Veuillez inscrire l'annee d'expiration de la carte de credit utilise")
		anExp.focus();
		return false;
	}
	if ((cvv.value == "") || (cvv.value == null)) {
		alert("Veuillez inscrire le code cvv de la carte de credit utilise")
		cvv.focus();
		return false;
	}
	if ((adresse.value == "") || (adresse.value == null)) {
		alert("Veuillez inscrire un nom de rue")
		adresse.focus();
		return false;
	}
	if ((ville.value == "") || (ville.value == null)) {
		alert("Veuillez inscrire la ville du titulaire")
		ville.focus();
		return false;
	}
	if ((prov.value == "") || (prov.value == null)) {
		alert("Veuillez inscrire une province")
		prov.focus();
		return false;
	}
	if ((pays.value == "") || (pays.value == null)) {
		alert("Veuillez inscrire une province")
		pays.focus();
		return false;
	}
	if ((codep.value == "") || (codep.value == null)) {
		alert("Veuillez inscrire le code postal")
		codep.focus();
		return false;
	}
	
	//le champ appartement peut �tre null, dans le cas ou le client r�side une maison
	
	return true;
  }
</script>
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script> 
</head>

<body id="home">

<div id="templatemo_header_wrapper">
    <div id="templatemo_header">
        <div id="site_title"><a href="index.jsp" class="selected">BILLETS<span>ONLINE</span></a></div>
        <div id="templatemo_menu" class="ddsmoothmenu">
            <ul>
                      <li><a href="index.jsp" class="selected">Accueil</a></li>
               
                <li><a href="spectacles.jsp">Spectacles</a>
                   
                </li>
                <li><a href="panier.jsp">Panier</a></li>
                <li><a href="contact.jsp">Contact</a></li>
				<li>
				<!--  Code pris sur le site http://www.codingforums.com/archive/index.php/t-40220.html--> 
				
<form method="get" action="http://www.google.com/search">
<input type="text" name="q" size="20" maxlength="255" />
<input type="submit" name="btnG" VALUE="Rechercher" />
<input type="hidden" name="domains" value="YOUR DOMAIN NAME" />
<input type="hidden" name="sitesearch" value="YOUR DOMAIN NAME" />
</form></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of templatemo_menu -->
    </div> <!-- END of header -->
</div>

<div id="templatemo_main_top"></div>
<div id="templatemo_main">
	
	
    <div class="col_12 float_c">
    	<h4>Informations Carte de credit</h4>
				
        <div id="contact_form">
           <form method="post" name="form" action="./" onSubmit="return valideChamps()">
                        
                        <label for="author">Nom:</label> <input type="text"  name="nomClient" class="required input_field" value="Lagrais"/>
                        <div class="cleaner h10"></div>
                         <label for="author">Prenom:</label> <input type="text" name="prenomClient" class="required input_field" value="Bernard"/>
                        <div class="cleaner h10"></div>
                         <label for="author">Courriel:</label> <input type="text" name="emailClient" class="required input_field" value="bernardlagrais@Domaine.com"/>
                        <div class="cleaner h10"></div>
                        <label for="nrCarte">Numero de carte de credit</label> <input type="text"  name="nrCarte" class="validate-email required input_field" value="8675309000000000" />
                        <div class="cleaner h10"></div>
                        
						<label for="moisExp">Mois d'expiration</label><input type="text" name="moisExp" value="10" class="required input_field" />
						<label for="anneeExp">Annee d'expiration</label><input type="text" name="anExp" value="2018" class="required input_field" />
						<div class="cleaner h10"></div>
				
                        <label for="cvv">Code CVV</label> <input type="text" name="cvv" class="validate-email required input_field" value="123"/>
                        <div class="cleaner h10"></div>
                        <div class="cleaner h10"></div>
           
			 <h4>Informations livraison</h4>
        	
                        
						
						
						<label for="subject">Adresse</label> <input type="text" name="adresse" class="input_field" value="Saint-Urbain" />
						
						<div class="cleaner h10"></div>
						
						 <label for="subject">Ville</label> <input type="text" name="ville" class="required input_field" value="Montreal"/>
						 
                        <div class="cleaner h10"></div>
						
                        <label for="subject">Province</label> <input type="text" name="prov" class="validate-email required input_field" value="Quebec"/>
						
                        <div class="cleaner h10"></div>
                        
                        <label for="subject">Province</label> <input type="text" name="pays" class="required input_field" value="Canada"/>
						
                        <div class="cleaner h10"></div>
                        
						<label for="subject">Code postal</label> <input type="text" name="codep" class="input_field" value="J8T2R8"/>

						<div class="cleaner h10"></div>
						
               
                        <input type="hidden" name="action" value="preAuthorisation"/>
                      															
                        <input type="submit"  class="button_cmd" value="Acheter" /><!-- onclick="AskAndSubmit(this)" -->
                      
               
						
            </form>
        </div>
     
	
        
	</div>
    
    
    <div class="cleaner"></div>
</div> <!-- END of main -->

<div id="templatemo_footer_wrapper">
	<div id="templatemo_footer">
	
		<div class="col col_14">
        	<h5>Différents Sites Utiles</h5>
            <ul class="footer_list">
                <li><a href="http://www.templatemo.com/page/1">Free CSS Templates</a></li>
                <li><a href="http://www.webdesignmo.com/blog">Web Design Resources</a></li>
            	<li><a href="http://www.flashmo.com">Free Flash Templates</a></li>
                <li><a href="http://www.templatemo.com">Website Templates</a></li>
                <li><a href="http://www.koflash.com">Free Web Gallery</a></li>
			</ul>   
        </div>
        <div class="col col_14">
        	<h5>Pages</h5>
            <ul class="footer_list">
            	<li><a href="index.html">Accueil</a></li>
                <li><a href="spectacles.html">Spectacles</a></li>
                <li><a href="panier.html">Panier</a></li>
                <li><a href="contact.html">Contact</a></li>
			</ul>
        </div>
        <div class="col col_14">
        	<h5>Suivez nous</h5>	
            <ul class="footer_list">
                <li><a href="#" class="social facebook">Facebook</a></li>
                <li><a href="#" class="social twitter">Twitter</a></li>
                <li><a href="#" class="social feed">Feed</a></li>
			</ul>
            
        </div>
        
           
        <div class="col col_14 no_margin_right">
        	<h5>Recevez nos nouvelles</h5>
            <form action="#" method="get">
              <input type="text" value="Inscription" name="email" id="email" title="email" onfocus="clearText(this)" onblur="clearText(this)" class="newsletter_txt" />
              <input type="submit" name="Inscription" value=" Inscription" alt="Inscription" id="subscribe_button" title="Inscription" class="subscribe_button"  />
            </form>
            <div class="cleaner h30"></div>
            Copyright © 2013 <a href="#">ÉTS</a> Code source par <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a>
        </div>
        
    <div class="cleaner"></div>
    </div>
</div> <!-- END of footer -->
</body>
</html>