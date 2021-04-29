package it.epicode.archivio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.archivio.dataAccess.FornitoreDAO;
import it.epicode.archivio.model.Fornitore;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String inserisci_destination = "jsp/inserisci.jsp";
	public static final String rimuovi_destination = "jsp/rimuovi.jsp";
	public static final String modifica_destination = "jsp/modifica.jsp";
	public static final String error_page_destination = "jsp/errorPage.jsp";
	public static final String lista_fornitori_destination = "jsp/listaFornitori.jsp";
	
	public static final String archivio_fornitori_destination ="jsp/ArchivioFornitori.jsp";
	
	public static final String chiave_lista_fornitori = "chiave_lista_fornitori";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} 
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	FornitoreDAO forn = new FornitoreDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		int pos = path.lastIndexOf("/");
		String action = path.substring(pos + 1, path.length() - 3);
		try {
			switch (action) {
			case "index":
				selezionaArchivio(request, response);
				break;
			case "archivioFornitore":
				selezioneAzione(request, response);
				break;
			default:
				response.sendRedirect("index.jsp");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			mostraPaginaDiErrore(request, response);
		}
	}
	
	private void mostraPaginaDiErrore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(error_page_destination);
		disp.forward(request, response);
	}
	
	private void listaFornitori (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Fornitore> list = forn.listaFornitori();
		request.setAttribute(chiave_lista_fornitori, list);
		RequestDispatcher disp = request.getRequestDispatcher(lista_fornitori_destination);
		disp.forward(request, response);
	}

	private void selezionaArchivio (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String scelta = request.getParameter("scelta");
		
		if ("archivioFornitori".equals(scelta)) {
			RequestDispatcher disp = request.getRequestDispatcher(archivio_fornitori_destination);
			disp.forward(request, response);
		}
		else {
			mostraPaginaDiErrore(request, response);
		}
	}
	
	private void selezioneAzione (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String azione = request.getParameter("scelta");
		Fornitore f =(Fornitore) request.getAttribute("fornitore");
		if (azione.equals("inserisci")) {
			String codice = request.getParameter("codiceFornitore");
			int codiceInt = Integer.parseInt(codice);
			f.setCodiceFornitore(codiceInt);
			f.setNome(request.getParameter("nome"));
			f.setIndirizzo(request.getParameter("indirizzo"));
			f.setCitta(request.getParameter("citta"));
			forn.aggiungiFornitore(f);
			RequestDispatcher disp = request.getRequestDispatcher(inserisci_destination);
			disp.forward(request, response);
			
		}
		else if (azione.equals("modifica")) {
			String codice = request.getParameter("codiceFornitore");
			int codiceInt = Integer.parseInt(codice);
			f.setCodiceFornitore(codiceInt);
			f.setNome(request.getParameter("nome"));
			f.setIndirizzo(request.getParameter("indirizzo"));
			f.setCitta(request.getParameter("citta"));
			forn.modificaFornitore(f);
			RequestDispatcher disp = request.getRequestDispatcher(modifica_destination);
			disp.forward(request, response);
		}
		else if (azione.equals("rimuovi")) {
			String codice = request.getParameter("codiceFornitore");
			int codiceInt = Integer.parseInt(codice);
			f.setCodiceFornitore(codiceInt);
			forn.eliminaFornitore(f);
			RequestDispatcher disp = request.getRequestDispatcher(rimuovi_destination);
			disp.forward(request, response);
		}
		listaFornitori(request, response);
	}
	
}