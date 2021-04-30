package archivio.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String error_page_destination = "jsp/errorPage.jsp";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		int pos = path.lastIndexOf("/");
		String action = path.substring(pos + 1, path.length() - 3);
		try {
			switch (action) {
			case "index":
				selezionaArchivio(request, response);
				break;
			case "archivioFornitori":
				selezioneAzione(request, response);
				break;
			default:
				mostraPaginaDiErrore(request, response);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			mostraPaginaDiErrore(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void selezionaArchivio (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("jsp/index.jsp");
		disp.forward(request, response);
	}
	
	private void selezioneAzione (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("jsp/archivioFornitori.jsp");
		disp.forward(request, response);
	}
	
	
	private void mostraPaginaDiErrore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(error_page_destination);
		disp.forward(request, response);
		
	}

}
