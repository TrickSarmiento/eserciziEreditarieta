<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Benvenuto.
	Scegli l'archivio che vuoi visualizzare.
	
		<%
		
		String scelta = request.getParameter("scelta");
		
		if ("archivioFornitori".equals(scelta)) {
			RequestDispatcher disp = request.getRequestDispatcher("jsp/archivioFornitori.jsp");
			disp.forward(request, response);
		}
		else {
			
		}%>
		
	<form action="Controller" method="post">
	
	<p>
	<input type="radio" name="scelta" value="archivioFornitori" checked>
	<input type="radio" name="scelta" value="archivioProdotti" disabled>Archivio Prodotti
	<br>
	
	<a href="archivioFornitori.do">Vai all'archivio Fornitori</a>
	</form>
</body>
</html>