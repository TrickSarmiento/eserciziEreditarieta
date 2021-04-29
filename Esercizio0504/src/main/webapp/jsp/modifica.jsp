<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller" method="post">
	<p>
	Codice Fornitore:
	<input type="number" value="${fornitore.codiceFornitore}" name="codiceFornitore"/><br>
	Nome:
	<input type="text" value="${fornitore.nome}" name="nome"/><br>
	Indirizzo:
	<input type="text" value="${fornitore.indirizzo}" name="indirizzo"/><br>
	Città:
	<input type="text" value="${fornitore.citta}" name="citta"/><br><br>
	
	<button type="submit" name="scelta" value="modifica">Modifica</button>
</form>
</body>
</html>