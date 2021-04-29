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
	
	<button type="submit" name="scelta" value="rimuovi">Rimuovi</button>
</p>
</body>
</html>