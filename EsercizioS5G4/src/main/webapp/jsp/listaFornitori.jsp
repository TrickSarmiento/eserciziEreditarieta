<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="fornitore" items="${CHIAVE_LISTA_FORNITORI}">
				ID: ${fornitore.codiceFornitore} - Nome: ${fornitore.nome} - Indirizzo: ${fornitore.indirizzo} - Cittá: ${fornitore.citta}<br />
		<hr class="separator">
	</c:forEach>

	<form action="listaFornitori.do" method="post">
		<input type="radio" name="azione" value="aggiungi">Aggiungi
		<p>
		<input type="radio" name="azione" value="modifica">Modifica
		<p>
		<input type="radio" name="azione" value="elimina">Elimina
		<p>
		<input type="submit" name="prosegui">
		
	
	
	</form>
</body>
</html>