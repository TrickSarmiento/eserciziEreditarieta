<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="archivio.dataAccess.FornitoreDAO, java.util.List, archivio.model.Fornitore";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	L'elenco dei fornitori.
	<% FornitoreDAO forn = new FornitoreDAO();
	
	List<Fornitore> elenco = forn.listaFornitori();
	for (Fornitore f : elenco) {
		System.out.println(f.getNome() + f.getCodiceFornitore());
	}
	%>

	Scegli l'azione che vuoi eseguire.

	<% 
	String azione = request.getParameter("sceltaAzione");
	Fornitore f =(Fornitore) request.getAttribute("fornitore");
	if (azione.equals("inserisci")) {
			String codice = request.getParameter("codiceFornitore");
			int codiceInt = Integer.parseInt(codice);
			f.setCodiceFornitore(codiceInt);
			f.setNome(request.getParameter("nome"));
			f.setIndirizzo(request.getParameter("indirizzo"));
			f.setCitta(request.getParameter("citta"));
			forn.aggiungiFornitore(f);
			
		}
		else if (azione.equals("modifica")) {
			String codice = request.getParameter("codiceFornitore");
			int codiceInt = Integer.parseInt(codice);
			f.setCodiceFornitore(codiceInt);
			f.setNome(request.getParameter("nome"));
			f.setIndirizzo(request.getParameter("indirizzo"));
			f.setCitta(request.getParameter("citta"));
			forn.modificaFornitore(f);

		}
		else if (azione.equals("rimuovi")) {
			String codice = request.getParameter("codiceFornitore");
			int codiceInt = Integer.parseInt(codice);
			f.setCodiceFornitore(codiceInt);
			forn.eliminaFornitore(f);

		}
		%>

	Inserisci nuovo fornitore
	<input type="radio" name="sceltaAzione" value="inserisci">
	Inserisci Modifica un fornitore
	<input type="radio" name="sceltaAzione" value="modifica">
	Modifica Rimuovi un fornitore
	<input type="radio" name="sceltaAzione" value="rimuovi">
	Rimuovi
	<br>
	<button type="submit" name="Prosegui" size="24">Prosegui</button>
</body>
</html>