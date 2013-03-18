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
</head>



 <% for (int i=0; i<panier.getPanier().length;i++){;%>

		
<h3 class="headerbar"><%=panier.getItemAchete(i).getRep().getNomSpectacle()%> / <%=panier.getItemAchete(i).getRep().getDate()%> - Salle: <%=panier.getItemAchete(i).getRep().getSalle()%>- <em><b><%=panier.getItemAchete(i).getNbBillets()%></b> Billets</em> &nbsp&nbsp 
<table border="1" >
<tr>
<td>
<form action="./" method = "post" ">
		<input type="hidden" name="posItem" value=<%=i%>  />
		<input type="hidden" name="nbBilletsAchete" value=<%=panier.getItemAchete(i).getNbBillets()%>  />
		<input type="hidden" name="action" value="ajouterBillet"/>
		<input type="submit" name="btnPlus" value=" Ajouter un billet " />
</form>
</td>
<td>
<form action="./" method = "post">
		<input type="hidden" name="posItem" value=<%=i%>  />
		<input type="hidden" name="nbBilletsAchete" value=<%=panier.getItemAchete(i).getNbBillets()%>  />
		<input type="hidden" name="action" value="enleverBillet"/>
		<input type="submit" name="btnMoins" value=" Enlever un billet " />
		</form>
		</td>
<tr style="float:right;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Sous-Total: <%=panier.getItemAchete(i).getTotal()%>$
</tr>
</tr>
</table>
</h3>
	
  <%}%>


</body>
</html>