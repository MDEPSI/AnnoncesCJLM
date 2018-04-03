<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 03/04/2018
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Création Annonce</title>
</head>
<body>
<form method="post" action="getOneAnnonceServlet">
    <fieldset>
        <legend>Créer une annonce</legend>

        <label for="titre">Titre de l'annonce</label>
        <input type="text" id="titre" name="titre" value="" size="20" maxlength="20" />
        <br />

        <input type="submit" value="Créer Annonce" class="sansLabel" />
        <br />
    </fieldset>
</form>
</body>
</html>
