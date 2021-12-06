package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        String donazioniMassimeRaggiunte = "Hai raggiunto il numero massimo di donazioni annuali";
        String genericError = "Qualcosa è andato storto, riprova";
        List<SessioneDonazione> sessioniDonazione;

        HttpSession session = request.getSession(); // Crea una nuova sessione o recpera quella esistente
        Utente utente_sessione = (Utente) session.getAttribute("utente");
        sessioniDonazione = SessioneDonazioneFactory.getInstance().getAllSessioniUtente(utente_sessione);
        String sessionprova = request.getParameter("idSessioneScelta");

        if (utente_sessione.getSesso().equals("Maschio")) {
            if (sessioniDonazione.size() <= 3) {
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
                request.setAttribute("errorMessage", donazioniMassimeRaggiunte);
                request.setAttribute("link", "login.jsp");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else if (utente_sessione.getSesso().equals("Femmina")) {
            if (sessioniDonazione.size() <= 1) {
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
                request.setAttribute("errorMessage", donazioniMassimeRaggiunte);
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
