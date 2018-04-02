<%@ page import ="java.util.List" %>
<%@ page import ="fr.epsi.myEpsi.beans.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mes utilisateurs</title>
</head>
<body>
	<table>
		<th>USERS</th>
		<% List <Utilisateur> myUsers = (List)request.getAttribute("USERS");
			for(Utilisateur user : myUsers){
				out.print("<tr><td>");
				out.print("Nom : " + user.getNom());
				out.print("</td><td>");
				out.print("Password : " + user.getPassword());
				out.print("</td></tr>");
			}%>
	</table>
</body>
</html>