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
  var answer = confirm("Vous étes sûr de vouloir réserver XXX billets?");
  if (answer)
  {
    t.form.submit();
  }
}
//Code pris du site web ci-dessous, pour utiliser dans le cadre de notre cours de GTI525
       //http://stackoverflow.com/questions/293648/display-confirmation-popup-with-javascript-upon-clicking-on-a-link
	   //-->

</script>

 <SCRIPT language=Javascript>
       <!--
       function isNumberKey(evt)
       {
          var charCode = (evt.which) ? evt.which : event.keyCode;
          if (charCode != 46 && charCode > 31 
            && (charCode < 48 || charCode > 57))
             return false;

          return true;
       }
	   //Code pris du site web ci-dessous, pour utiliser dans le cadre de notre cours de GTI525
       //http://stackoverflow.com/questions/2808184/restricting-input-to-textbox-allowing-only-numbers-and-decimal-point
	   //-->
    </SCRIPT>
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
        <div id="site_title"><a href="index.html" class="selected">BILLETS<span>ONLINE</span></a></div>
        <div id="templatemo_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="index.jsp" class="selected">Accueil</a></li>
                <li><a href="spectacles.jsp">Spectacles</a>     </li>
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
	<div class="col col_23">
        <h2>Représentation: SAMEDI, MAI 16, 2013</h2>
        <img src="images/templatemo_image_04b.jpg" alt="Amaluna" class="float_l img_float_l" />
                <p><em> Durée du spectacle</em></p>
<p>Le spectacle dure 2 h 30, incluant un entracte de 30 minutes.</p>
<p><em>Retardataires</em></p>
<p>La représentation commence à l'heure. L'entrée des retardataires s'effectue lors de moments jugés opportuns par les placiers. Les personnes en fauteuil roulant qui arrivent en retard ne peuvent entrer qu'à l'entracte.</p>
<p><em>La tente d'entrée:</em></p>
<p>
La tente d'entrée ouvre 1 heure avec l'heure de la représentation et le Grand Chapiteau 1/2 heure avant
* Des responsables de la billetterie sont à la disposition des spectateurs jusqu'à la fin de l'entracte.</p>
<p><em>Boissons et nourriture</em></p>
<p>
Pop corn, bonbons et autres gourmandises sont à diposition pour achat dans la tente d'entrée. Ils sont acompagnés d'un éventail de choix de boissons. Bière et vins sont diponibles aux comptoirs pour nos visiteurs majeurs (une carte d'identité peut être demandée). Les paiements en espèces, par carte bancaire ou de crédit sont acceptés.</p>
<p><em>Divers</em></p>
<p>
La température est contrôlée à l'intérieur du Grand Chapiteau.
Il n'y a pas de vestiaire.
Il est interdit de fumer dans le Grand Chapiteau.
Les téléphones cellulaires doivent être fermés pour la durée de la représentation.
Les caméras vidéo, appareils photo et magnétophones ne sont pas admis
Des salles de bain pour personnes handicapées sont disponibles
Les chiens guides sont autorisés, veuillez svp le signaler à l'achat des billets.</p>
	</div>
    <div class="col col_13 no_margin_right">
    	<h3>Acheter des billets</h3>
        <div class="testimonial">
            <p>Il restent seulement: <cite><b>12</b></cite>&nbsp billets disponibles pour cette représentation </p>
            <div class="cleaner"></div>
            <cite><b>159$</b> chaque</cite>
			<p></p>
            <p>Choisisez le nombre de billets désirés et appuyez sur le bouton continuer</p>
			<p></p>
			 <INPUT id="txtChar" onkeypress="return isNumberKey(event)" 
           type="text" name="txtChar">
		   <a href="panier.html"><input type="submit" name="Reserver" value=" Réserver " alt="Réserver" id="reserver_button" title=" Réserver le nombre de billets inscrits, ils seront ajoutés au panier" class="reserver_button" onclick="AskAndSubmit(this)" /></a>
		 

		</div>
	</div>    
    <div class="cleaner h40"></div>
        
   
    
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