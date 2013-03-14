<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="modele.BeanSpectacle"%>
<%@ page import="java.util.ArrayList;"%>
<%
ArrayList<BeanSpectacle> spectacles = (ArrayList<BeanSpectacle>)request.getSession().getAttribute("spectacles");
%>

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
  var answer = confirm("Vous Ã©tes sÃ»r de vouloir rÃ©server XXX billets?");
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


<div id="templatemo_main">
	<div class="col col_23">
        <h2>ReprÃ©sentations</h2>
        <img src=<%=spectacles.get(0).getPoster()%> alt=<%=spectacles.get(0).getNom()%> class="float_l img_float_l" />
		  <p><em> Prix du spectacle: 159$</em></p>
          <p><em> DurÃ©e du spectacle</em></p>
<p>Le spectacle dure 2 h 30, incluant un entracte de 30 minutes.</p>
<p><em>Retardataires</em></p>
<p>La reprÃ©sentation commence Ã  l'heure. L'entrÃ©e des retardataires s'effectue lors de moments jugÃ©s opportuns par les placiers. Les personnes en fauteuil roulant qui arrivent en retard ne peuvent entrer qu'Ã  l'entracte.</p>
<p><em>La tente d'entrÃ©e:</em></p>
<p>
La tente d'entrÃ©e ouvre 1 heure avec l'heure de la reprÃ©sentation et le Grand Chapiteau 1/2 heure avant
* Des responsables de la billetterie sont Ã  la disposition des spectateurs jusqu'Ã  la fin de l'entracte.</p>
<p><em>Boissons et nourriture</em></p>
<p>
Pop corn, bonbons et autres gourmandises sont Ã  diposition pour achat dans la tente d'entrÃ©e. Ils sont acompagnÃ©s d'un Ã©ventail de choix de boissons. BiÃ¨re et vins sont diponibles aux comptoirs pour nos visiteurs majeurs (une carte d'identitÃ© peut Ãªtre demandÃ©e). Les paiements en espÃ¨ces, par carte bancaire ou de crÃ©dit sont acceptÃ©s.</p>
<p><em>Divers</em></p>
<p>
La tempÃ©rature est contrÃ´lÃ©e Ã  l'intÃ©rieur du Grand Chapiteau.
Il n'y a pas de vestiaire.
Il est interdit de fumer dans le Grand Chapiteau.
Les tÃ©lÃ©phones cellulaires doivent Ãªtre fermÃ©s pour la durÃ©e de la reprÃ©sentation.
Les camÃ©ras vidÃ©o, appareils photo et magnÃ©tophones ne sont pas admis
Des salles de bain pour personnes handicapÃ©es sont disponibles
Les chiens guides sont autorisÃ©s, veuillez svp le signaler Ã  l'achat des billets.</p>

      
<div class="urbangreymenu">

<h3 class="headerbar">AMALUNA À MONTRÉAL, CANADA</h3>
<ul>

<% for (int i=0; i<spectacles.size();i++){%>
   	 <!-- Une représentation spectacle -->
   	<% if(spectacles.get(0).getNom() == spectacles.get(i).getListeRepresentations().get(i).getNomSpectacle()){%>
   		<li><a href="representation_choisie.jsp"><%=spectacles.get(i).getListeRepresentations().get(i).getDate()%> / 
   												 <%=spectacles.get(i).getListeRepresentations().get(i).getNomSpectacle()%> / Billets Restants:	
   													<%=spectacles.get(i).getListeRepresentations().get(i).getBilletsDispo()%>
   													 </a></li>
   	
       		<!-- fin d'une representation -->
       			<%}%>
   <%}%>



</ul>


</div></p>
	</div>
      
    <div class="cleaner h40"></div>
        
   
    
    <div class="cleaner"></div>
</div> <!-- END of main -->

<div id="templatemo_footer_wrapper">
	<div id="templatemo_footer">
	
		<div class="col col_14">
        	<h5>DiffÃ©rents Sites Utiles</h5>
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
            Copyright Â© 2013 <a href="#">ÃTS</a> Code source par <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a>
        </div>
        
    <div class="cleaner"></div>
    </div>
</div> <!-- END of footer -->

</body>
</html>