package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
import java.io.IOException;
import java.util.List;
import it.unica.scootercritic.utils.Utils;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PrenotaSessioneServlet", urlPatterns = {"/PrenotaSessioneServlet"})
public class PrenotaSessioneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean sessione_modificata;
        String errorePrenotazione = "La prenotazione non è avvenuta correttamente";
        String nessunaPrenotazioneDisponibile = "Non ci sono prenotazioni disponibili";
        String genericError = "Qualcosa è andato storto, riprova";

        HttpSession session = request.getSession(); // Crea una nuova sessione o recpera quella esistente
        Utente utente_sessione = (Utente) session.getAttribute("utente");
        List<SessioneDonazione> sessioniDonazione = SessioneDonazioneFactory.getInstance().getAllSessioniUtente(utente_sessione);
        List<SessioneDonazione> sessioniDonazioneDisponibili = new ArrayList<>();
        //
        if (utente_sessione.getSesso().equals("Maschio")) {
            sessioniDonazioneDisponibili = Utils.checkDates(sessioniDonazione, 4);
            if (sessioniDonazioneDisponibili != null) {
                SessioneDonazione sessione_prenotata = new SessioneDonazione();
                sessione_prenotata.setId(Long.parseLong(request.getParameter("idSessioneScelta")));
                sessione_modificata = SessioneDonazioneFactory.ModifySessioneIntoDb(sessione_prenotata, utente_sessione);
                if (sessione_modificata) {
                    request.getRequestDispatcher("prenotazione_effettuata.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", errorePrenotazione);
                    request.setAttribute("link", "login.jsp");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", nessunaPrenotazioneDisponibile);
                request.setAttribute("link", "login.jsp");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else if (utente_sessione.getSesso().equals("Femmina")) {
            sessioniDonazioneDisponibili = Utils.checkDates(sessioniDonazione, 2);
            if (sessioniDonazioneDisponibili != null) {
                SessioneDonazione sessione_prenotata = new SessioneDonazione();
                sessione_prenotata.setId(Long.parseLong(request.getParameter("idSessioneScelta")));
                sessione_modificata = SessioneDonazioneFactory.ModifySessioneIntoDb(sessione_prenotata, utente_sessione);
                if (sessione_modificata) {
                    request.getRequestDispatcher("prenotazione_effettuata.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", errorePrenotazione);
                    request.setAttribute("link", "login.jsp");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", nessunaPrenotazioneDisponibile);
                request.setAttribute("link", "login.jsp");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", genericError);
            request.setAttribute("link", "login.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        /* SessioneDonazione sessione_prenotata = new SessioneDonazione();
        sessione_prenotata.setId(Long.parseLong(request.getParameter("idSessione")));
        sessione_modificata = SessioneDonazioneFactory.ModifySessioneIntoDb(sessione_prenotata, utente_sessione);

        if (sessione_modificata) {
            request.getRequestDispatcher("prenotazione_effettuata.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", errorePrenotazione);
            request.setAttribute("link", "login.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
         */
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
