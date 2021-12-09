package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
import it.unica.scootercritic.model.UtenteConDonazione;
import it.unica.scootercritic.model.UtenteFactory;
import it.unica.scootercritic.utils.sort.SortCognome;
import it.unica.scootercritic.utils.sort.SortDonazioni;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Claudio Loriga
 */
@WebServlet(name = "VisualizzaDonatoriServlet", urlPatterns = {"/VisualizzaDonatoriServlet"})
public class VisualizzaDonatoriServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nessunUtente = "Non è stato possibile trovare utenti";
        String sceltaString = (String) request.getParameter("tipo_ordine");
        int sceltaOrdinamento = (sceltaString != null) ? Integer.parseInt(sceltaString) : 0;

        List<Utente> utenti = UtenteFactory.getAllUtenti();
        List<UtenteConDonazione> utentiConDonazione = new ArrayList<>();

        for (int i = 0; i < utenti.size(); i++) {
            List<SessioneDonazione> sessioni = SessioneDonazioneFactory.getInstance().getAllSessioniUtente(utenti.get(i));
            UtenteConDonazione nuovoUtente = new UtenteConDonazione(utenti.get(i), sessioni.size());

            utentiConDonazione.add(nuovoUtente);
        }

        switch (sceltaOrdinamento) {
            case 1:
                //Z-A
                utentiConDonazione.sort(new SortCognome().reversed());
                break;
            case 2:
                //Donazioni crescente
                utentiConDonazione.sort(new SortDonazioni());
                break;
            case 3:
                //Donazioni decrescente
                utentiConDonazione.sort(new SortDonazioni().reversed());
                break;
            default:
                // A-Z
                utentiConDonazione.sort(new SortCognome());
                break;
        }

        if (!utentiConDonazione.isEmpty()) {
            request.setAttribute("utentiConDonazione", utentiConDonazione);
            request.getRequestDispatcher("visualizzaDonatori.jsp").forward(request, response);
        } else {
            pubblicaErrore(request, response, nessunUtente);
        }
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

    private void pubblicaErrore(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("errorMessage", error);
        request.setAttribute("link", "index.jsp");
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
}
