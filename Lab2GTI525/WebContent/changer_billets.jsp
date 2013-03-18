<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="modele.BeanSpectacle"%>
<%@ page import="modele.Panier"%>
<%@ page import="java.util.ArrayList;"%>
<%
ArrayList<BeanSpectacle> spectacles = (ArrayList<BeanSpectacle>)request.getSession().getAttribute("spectacles");
Panier panier  = (Panier)request.getSession().getAttribute("panier");
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BILLETSONLINE</title>
<meta name="keywords" content="billets,en-ligne,online,spectacles,representations,montreal" />
<meta name="description" content="This website serves as an interface for searching and buying show tickets online made for the course GTI525" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/swfobject/swfobject.js"></script>


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
  var answer = confirm("Vous etes surs de vouloir acheter tous ces billets?");
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
<link rel="stylesheet" href="css/lightbox.css" type="text/css" media="screen" />
<script src="js/prototype.js" type="text/javascript"></script>
<script src="js/scriptaculous.js?load=effects,builder" type="text/javascript"></script>
<script src="js/lightbox.js" type="text/javascript"></script>

</head>

<body id="home">



<div id="templatemo_main_top"></div>
<div id="templatemo_main">
		
	<div class="urbangreymenu">

<form method="post" action="nouveauBillets.do">
 <% for (int i=0; i<panier.getPanier().length;i++){;%>

<h3 class="headerbar"><%=panier.getItemAchete(i).getRep().getNomSpectacle()%> / <%=panier.getItemAchete(i).getRep().getDate()%> - Salle: 
<%=panier.getItemAchete(i).getRep().getSalle()%>
 - <em><b><%=panier.getItemAchete(i).getNbBillets()%></b> Billets</em> &nbsp&nbsp<input type="submit" name="btnMoins" value="-" />
<input type="submit" name="btnPlus" value="+" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Total: <%=panier.getItemAchete(i).getTotal()%>$</h3>

  <%}%>

</form>

</body>
</html>