<%@ page import ="java.util.List" %>
<%@ page import ="fr.epsi.myEpsi.beans.Annonce" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mon annonce</title>
</head>
<body>
	<table>
		<th>Annonce</th>
		<% Annonce myAnnonce = (Annonce) request.getAttribute("ANNONCES");
				out.print("<tr><td>");
				out.print(myAnnonce.getTitre());
				out.print("</td></tr>");
			%>
	</table>
</body>
</html>