<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Vetements</title>
</head>
<body>
 <h1 >
 Liste des Vetement
 </h1> 
 <table >
 <tr>
 <th>ID</th><th>Nom Vetememt</th><th>Prix</th><th>Date 
production</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${vetements}" var="v">
 <tr>
 <td>${v.idvetement}</td>
 <td>${v.nomvetement }</td>
 <td>${v.prixvetement }</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${v.dateprod}" /></td>
 <td><a onclick="return confirm('Etes-vous sûr ?')"
href="supprimerVetement?id=${v.idvetement }">Supprimer</a></td>
 <td><a href="modifierVetement?id=${v.idvetement }">Edit</a></td>
 </tr>
 </c:forEach> 
 </table>
</body>
</html>