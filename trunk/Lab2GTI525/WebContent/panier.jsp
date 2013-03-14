<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BILLETSONLINE</title>
<meta name="keywords" content="billets,en-ligne,online,spectacles,representations,montreal" />
<meta name="description" content="This website serves as an interface for searching and buying show tickets online made for the course GTI525" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/swfobject/swfobject.js"></script>

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
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
<script type="text/javascript" language="JavaScript">
function AskAndSubmit(t)
{
  var answer = confirm("Vous étes sûr de vouloir acheter tous ces billets?");
  if (answer)
  {
    t.form.submit();
  }
}
//Code pris du site web ci-dessous, pour utiliser dans le cadre de notre cours de GTI525
       //http://stackoverflow.com/questions/293648/display-confirmation-popup-with-javascript-upon-clicking-on-a-link
	   //-->

</script>
<link rel="stylesheet" href="css/lightbox.css" type="text/css" media="screen" />
<script src="js/prototype.js" type="text/javascript"></script>
<script src="js/scriptaculous.js?load=effects,builder" type="text/javascript"></script>
<script src="js/lightbox.js" type="text/javascript"></script>

</head>

<body id="home">

<div id="templatemo_header_wrapper">
    <div id="templatemo_header">
        <div id="site_title"><a href="index.html" class="selected">BILLETS<span>ONLINE</span></a></div>
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
		<h2>Panier</h2>
	<div class="urbangreymenu">

<h3 class="headerbar">CIRQUE DU SOLEIL - AMALUNA À SEATTLE, WA
WASHINGTON, SAMEDI, MAI 16, 2013 - <em><b>8</b> Billets </em><input type="submit" name="btnMoins" VALUE="-" />
<input type="submit" name="btnPlus" VALUE="+" /></h3>


<h3 class="headerbar">ST-PIERRE vs PENN, AB
ALBERTA, CANADA, DIMANCHE, MAI 17, 2013 - <em><b>12</b> Billets</em><input type="submit" name="btnMoins" VALUE="-" />
<input type="submit" name="btnPlus" VALUE="+" /></h3>
<div class="cleaner h10"></div>
<form> <div class="float_r"><a href="payement.html"><input type="button" class="button_cmd" value="Finaliser commande" onclick="AskAndSubmit(this)"/></a> </div></form>

</div>
        <p></p>
        <div class="cleaner"></div>
        <div class="pagging">
            <ul>
                <li><a href="panier.html" target="_parent">Précédent</a></li>
                <li><a href="panier.html" target="_parent">1</a></li>
                <li><a href="panier.html" target="_parent">2</a></li>
                <li><a href="panier.html" target="_parent">3</a></li>
                <li><a href="panier.html" target="_parent">4</a></li>
                <li><a href="panier.html" target="_parent">5</a></li>
                <li><a href="panier.html" target="_parent">6</a></li>
                <li><a href="panier.html" target="_parent">Suivant</a></li>
            </ul>
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