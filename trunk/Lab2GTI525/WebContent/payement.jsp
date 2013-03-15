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
  var answer = confirm("Vous étes sûr de vouloir compléter votre achat? Cette opération est irréversible");
  if (answer)
  {
    t.form.submit();
  }
}
//Code pris du site web ci-dessous, pour utiliser dans le cadre de notre cours de GTI525
       //http://stackoverflow.com/questions/293648/display-confirmation-popup-with-javascript-upon-clicking-on-a-link
	   //-->

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
    	<h4>Informations Carte de crédit</h4>
				
        <div id="contact_form">
           <form method="post" name="contact" action="#">
                        
                        <label for="author">Nom:</label> <input type="text" id="author" name="author" class="required input_field" />
                        <div class="cleaner h10"></div>
                        <label for="email">Numéro de carte de crédit</label> <input type="text" id="nrcredit" name="nrcredit" class="validate-email required input_field" />
                        <div class="cleaner h10"></div>
                        
						<label for="subject">Date d'expiration</label> 	
						<!-- Code des combo box pris sur 
						http://www.glodev.com/script_view.php?ScriptID=29
						-->
								<select name="month">
									<option value="1">January
									<option value="2">February
									<option value="3">March
									<option value="4">April
									<option value="5">May
									<option value="6">June
									<option value="7">July
									<option value="8">August
									<option value="9">September
									<option value="10">October
									<option value="11">November
									<option value="12">December
								</select>
								<select name="day">
									<option value="1">1
									<option value="2">2
									<option value="3">3
									<option value="4">4
									<option value="5">5
									<option value="6">6
									<option value="7">7
									<option value="8">8
									<option value="9">9
									<option value="10">10
									<option value="11">11
									<option value="12">12
									<option value="13">13
									<option value="14">14
									<option value="15">15
									<option value="16">16
									<option value="17">17
									<option value="18">18
									<option value="19">19
									<option value="20">20
									<option value="21">21
									<option value="22">22
									<option value="23">23
									<option value="24">24
									<option value="25">25
									<option value="26">26
									<option value="27">27
									<option value="28">28
									<option value="29">29
									<option value="30">30
									<option value="31">31
								</select>
								<select name="year">
									<option value="2002">2002
									<option value="2003">2003
									<option value="2004">2004
									<option value="2005">2005
								</select>
						<div class="cleaner h10"></div>
						<div class="cleaner h10"></div>
                        <label for="email">Code CVV</label> <input type="text" id="cvv" name="cvv" class="validate-email required input_field" />
                        <div class="cleaner h10"></div>
                        
            </form>
			 <h4>Informations livraison</h4>
        <div id="contact_form">
           <form method="post" name="contact" action="#">
                        
                        <label for="author">Nom:</label> <input type="text" id="author" name="author" class="required input_field" />
						
                        <div class="cleaner h10"></div>
						
                        <label for="email">Numéro appartement:</label> <input type="text" id="app" name="app" class="validate-email required input_field" />
                        <div class="cleaner h10"></div>
                        
						<label for="subject">Numéro rue:</label> <input type="text" name="nrrue" id="nrrue" class="input_field" />

						<div class="cleaner h10"></div>
						
						<label for="subject">Nom de rue:</label> <input type="text" name="nomrue" id="nomrue" class="input_field" />
						
						<div class="cleaner h10"></div>
						
						 <label for="author">Ville</label> <input type="text" id="ville" name="ville" class="required input_field" />
						 
                        <div class="cleaner h10"></div>
						
                        <label for="email">Province</label> <input type="text" id="prov" name="prov" class="validate-email required input_field" />
						
                        <div class="cleaner h10"></div>
                        
						<label for="subject">Code postal</label> <input type="text" name="codep" id="codep" class="input_field" />

						<div class="cleaner h10"></div>
						
                        <form> <div class="float_r"><a href="confirmation.html"><input type="button" class="button_cmd" value="Acheter" onclick="AskAndSubmit(this)"/></a> </div></form>
						
            </form>
        </div>
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