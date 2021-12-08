package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Claudio Loriga
 */
@WebServlet(name = "PrenotaSessioneServlet", urlPatterns = {"/PrenotaSessioneServlet"})
public class PrenotaSessioneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean sessione_modificata;
        String errorePrenotazione = "La prenotazione non è avvenuta correttamente";
        HttpSession session = request.getSession();
        Utente utente_sessione = (Utente) session.getAttribute("utente");

        SessioneDonazione sessione_prenotata = new SessioneDonazione();
        sessione_prenotata.setId(Long.parseLong(request.getParameter("idSessioneScelta")));
        sessione_modificata = SessioneDonazioneFactory.ModifySessioneIntoDb(sessione_prenotata, utente_sessione);

        if (sessione_modificata) {
            request.getRequestDispatcher("prenotazione_effettuata.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", errorePrenotazione);
            request.setAttribute("link", "index.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
