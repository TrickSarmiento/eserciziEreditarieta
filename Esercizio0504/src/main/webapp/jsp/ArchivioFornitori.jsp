<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Fornitori</title>
</head>
<body>
	<c:forEach var = "fornitore" items = "${chiave_lista_fornitori}">
		${fornitore.nome} ${fornitore.codiceFornitore}<br>
	</c:forEach>
	
	<form action="Controller" method="post">
		<input type="radio" name="scelta" value="inserisci" checked />Inserisci 
		<input type="radio" name="scelta" value="modifica" />Modifica
		<input type="radio" name="scelta" value="rimuovi" /> Rimuovi
		<br>
		<button type ="submit" name="prosegui" size="24">Prosegui</button>
	
	</form>
</body>
</html>