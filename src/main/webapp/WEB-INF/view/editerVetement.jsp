<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Modifier un Vetement</title>
</head>
<body>
<form action="updateVetement" method="post">
<pre>
id : <input type="text" name="idvetement" value="${vetement.idvetement}">
nom :<input type="text" name="nomvetement" value="${vetement.nomvetement}">
prix :<input type="text" name="prixvetement" value="${vetement.prixvetement}">
Date production : 
 <fmt:formatDate pattern="yyyy-MM-dd" value="${vetement.dateprod}"
var="formatDate" />
 <input type="date" name="date" value="${formatDate}"></input>
<input type="submit" value="Modifier">
</pre>
</form>
<br/>
<br/>
<a href="ListeVetement">Liste Produits</a>
</body>
</html>