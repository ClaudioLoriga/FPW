package it.unica.scootercritic.servlet;

import java.io.IOException;
import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
import java.sql.Date;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PrenotazioneServlet", urlPatterns = {"/PrenotazioneServlet"})
public class PrenotazioneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); // Crea una nuova sessione o recpera quella esistente
        Utente utente_sessione = (Utente) session.getAttribute("utente");
        String genericError = "Non sono presenti prenotazioni disponibili";

        List<SessioneDonazione> sessioni = SessioneDonazioneFactory.getInstance().getAllSessioni();
        List<SessioneDonazione> sessioniUtente = SessioneDonazioneFactory.getInstance().getAllSessioniUtente(utente_sessione);
        List<SessioneDonazione> sessioniSelezionate = new ArrayList<>();

        if (sessioni != null && sessioni.size() > 0) {

            SessioneDonazione sessionePiuRecente = null;
            for (SessioneDonazione sessione : sessioniUtente) {
                if (sessionePiuRecente == null || sessionePiuRecente.getData_sessione().before(sessione.getData_sessione())) {
                    sessionePiuRecente = sessione;
                }
            }

            if (sessionePiuRecente == null) {
                pubblicaLista(request, response, sessioni);
            } else {

                LocalDate localDateRecente = sessionePiuRecente.getData_sessione().toLocalDate();

                for (SessioneDonazione sessione : sessioni) {
                    LocalDate localDateSessione = sessione.getData_sessione().toLocalDate();
                    if (sessione.getData_sessione().after(sessionePiuRecente.getData_sessione())) {
                        long daysBetween = DAYS.between(localDateRecente, localDateSessione);
                        if (daysBetween >= 90) {
                            sessioniSelezionate.add(sessione);
                        }
                    }
                }
                if (sessioniSelezionate != null && sessioniSelezionate.size() > 0) {
                    pubblicaLista(request, response, sessioniSelezionate);
                } else {
                    pubblicaErrore(request, response, genericError);

                }
            }
        } else {
            pubblicaErrore(request, response, genericError);
        }

        /*String command = request.getParameter("offsetId");
        if (command != null) {
            SessioneDonazione sessione = SessioneDonazioneFactory.getInstance().getSessione(command);
            request.setAttribute("sessione", sessione);
            response.setContentType("application/json");
            response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            request.getRequestDispatcher("sessioneJSON.jsp").forward(request, response);
        }
         */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void pubblicaLista(HttpServletRequest request, HttpServletResponse response, List<SessioneDonazione> sessioni) throws ServletException, IOException {
        request.setAttribute("listaSessioni", sessioni);
        request.getRequestDispatcher("nuova-prenotazione.jsp").forward(request, response);
    }

    private void pubblicaErrore(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("errorMessage", error);
        request.setAttribute("link", "login.jsp");
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
}
