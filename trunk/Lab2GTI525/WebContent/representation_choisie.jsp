<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="modele.BeanSpectacle"%>
<%@ page import="modele.Panier"%>
<%@ page import="java.util.ArrayList;"%>
<%
ArrayList<BeanSpectacle> spectacles = (ArrayList<BeanSpectacle>)request.getSession().getAttribute("spectacles");
int posSpectacleChoisi = Integer.valueOf(request.getParameter("spectacleChoisi").toString());
int posRepChoisi = Integer.valueOf(request.getParameter("representationChoisi").toString());
Panier panier  = (Panier)request.getSession().getAttribute("panier");

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

    
 <script Language="JavaScript">
<!-- 
function champVideValidator()
{
	//Code provenant de http://stackoverflow.com/questions/3502354/textbox-empty-check-using-javascript
// Check the value of the element named text_name from the form named text_form
if (formReservation.nbBillets.value == "")
{
  // If null display and alert box
   alert("Vous devez entrer un nombre de billets a acheter");
  // Place the cursor on the field for revision
   formReservation.nbBillets.focus();
  // return false to stop further processing
   return (false);
}
// If text_name is not null continue processing
return (true);
}
-->
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
        <h2>Représentation: <%=spectacles.get(posSpectacleChoisi).getListeRepresentations().get(posRepChoisi).getDate()%></h2>
        <img src=<%=spectacles.get(posSpectacleChoisi).getPoster()%> alt=<%=spectacles.get(posSpectacleChoisi).getNom()%> class="float_l img_float_l" />
             
 <p><em> Duree du spectacle</em></p>
<p>Le spectacle dure environs 3 heures</p>
<p><em>Description</em></p>
<p><%=spectacles.get(posSpectacleChoisi).getDescription()%><br><br><br><br><br><br></p>

</div>
    <div class="col col_13 no_margin_right">
    	<h3>Acheter des billets</h3>
        <div class="testimonial">
            <p>Il restent seulement: <cite><b><%=spectacles.get(posSpectacleChoisi).getListeRepresentations().get(posRepChoisi).getBilletsDispo()%></b></cite>&nbsp billets disponibles pour cette représentation </p>
            <div class="cleaner"></div>
            <cite><b><%=spectacles.get(posSpectacleChoisi).getListeRepresentations().get(posRepChoisi).getPrix()%>$</b> chaque</cite>
			<p></p>
            <p>Entrez le nombre de billets désirés et appuyez sur le bouton continuer</p>
			<p></p>
			<form name="formReservation" action="./" method = "post" onsubmit="return champVideValidator()">
			<input id="txtChar" onkeypress="return isNumberKey(event)" type="text" name="nbBillets"/>
		    <input type="hidden" name="rep" value=<%=posRepChoisi%> />
			<input type="hidden" name="spec"  value=<%=posSpectacleChoisi%> />
		    <input type="submit" name="btnReserver" value=" Réserver " alt="Réserver" title=" Réserver le nombre de billets inscrits, ils seront ajoutés au panier" class="button_cmd"/>
		 	<input type="hidden" name="panier"  value=<%=panier%> />
		 	<input type="hidden" name="action"  value="ajouterDansPanier" />
			
			</form>		

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