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

	FornitoreDAO f = new FornitoreDAO();
	
	public static final String CHIAVE_LISTA_FORNITORI = "CHIAVE_LISTA_FORNITORI";
	public static final String LISTA_FORNITORI_DESTINATION = "jsp/listaFornitori.jsp";
	public static final String CHIAVE_AGGIUNGI_FORNITORE = "CHIAVE_AGGIUNGI_FORNITORE";
	public static final String AGGIUNGI_FORNITORE_DESTINATION = "jsp/aggiungiFornitore.jsp";
	public static final String CHIAVE_MODIFICA_FORNITORE = "CHIAVE_MODIFICA_FORNITORE";
	public static final String MODIFICA_FORNITORE_DESTINATION = "jsp/modificaFornitore.jsp";
	public static final String CHIAVE_ELIMINA_FORNITORE = "CHIAVE_ELIMINA_FORNITORE";
	public static final String ELIMINA_FORNITORE_DESTINATION = "jsp/eliminaFornitore.jsp";
	
	
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		String path = request.getServletPath();
		int pos = path.lastIndexOf('/');
		String action = path.substring(pos + 1, path.length() - 3);
		switch (action) {
		case "aggiungi":
			response.sendRedirect(AGGIUNGI_FORNITORE_DESTINATION);
			break;
//			case "aggiungi":
//				aggiungiFornitore(request, response);
//				break;
//			case "modifica":
//				modificaFornitore(request, response);
//				break;
//			case "elimina":
//				eliminaFornitore(request, response);
//				break;
		default:
			mostraPaginaDiErrore(request, response);
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		int pos = path.lastIndexOf('/');
		String action = path.substring(pos + 1, path.length() - 3);
		try {
			switch (action) {
			case "listaFornitori":
				listaFornitori(request, response);
				break;
			case "aggiungi":
				aggiungiFornitore(request, response);
				break;
			case "modifica":
				modificaFornitore(request, response);
				break;
			case "elimina":
				eliminaFornitore(request, response);
				break;
			default:
				mostraPaginaDiErrore(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void listaFornitori(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Fornitore> result = f.listaFornitori();
		request.setAttribute(CHIAVE_LISTA_FORNITORI, result);
		RequestDispatcher disp = request.getRequestDispatcher(LISTA_FORNITORI_DESTINATION);
		disp.forward(request, response);	
		
		String azione = request.getParameter("azione");
		switch (azione) {
		case "aggiungi":
			aggiungiFornitore(request, response);
			break;
		case "modifica":
			modificaFornitore(request, response);
			break;
		case "elimina":
			eliminaFornitore(request, response);
			break;
		}

	}

	private void mostraPaginaDiErrore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp");
		disp.forward(request, response);
	}
	
	private void aggiungiFornitore (HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		String codice = request.getParameter("codiceFornitore");
		int codInt = Integer.parseInt(codice);
		Fornitore f1 = new Fornitore(codInt, request.getParameter("nome"), request.getParameter("indirizzo"), request.getParameter("citta"));
		f.aggiungiFornitore(f1);
		request.setAttribute(codice, f1);
		request.setAttribute(CHIAVE_AGGIUNGI_FORNITORE, f1);
		RequestDispatcher disp = request.getRequestDispatcher(AGGIUNGI_FORNITORE_DESTINATION);
		disp.forward(request, response);
	}
	
	private void modificaFornitore (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.sendRedirect(MODIFICA_FORNITORE_DESTINATION);
		Fornitore f1 = new Fornitore(Integer.parseInt(request.getParameter("codiceFornitore")),request.getParameter("nome"), request.getParameter("indirizzo"), request.getParameter("citta"));
		f.modificaFornitore(f1);
		response.sendRedirect(LISTA_FORNITORI_DESTINATION);
	}
	
	private void eliminaFornitore (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		response.sendRedirect(ELIMINA_FORNITORE_DESTINATION);
		String id = request.getParameter("codiceFornitore");
		Fornitore f1 = new Fornitore (Integer.parseInt(id), null, null, null);
		f.eliminaFornitore(f1);
		response.sendRedirect(LISTA_FORNITORI_DESTINATION);
	}
	

}
