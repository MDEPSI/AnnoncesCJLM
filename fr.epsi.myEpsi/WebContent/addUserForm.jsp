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
    <title>Création User</title>
</head>
<body>
<form method="post" action="getOneUserServlet">
    <fieldset>
        <legend>Créer un utilisateur</legend>

        <label for="nom">Nom d'utilisateur</label>
        <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
        <br />

        <label for="motdepasse">Mot de passe </label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
        <br />

        <input type="submit" value="Créer User" class="sansLabel" />
        <br />
    </fieldset>
</form>
</body>
</html>
