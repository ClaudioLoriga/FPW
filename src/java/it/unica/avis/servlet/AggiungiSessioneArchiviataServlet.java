package it.unica.avis.servlet;

import it.unica.avis.model.DonazioneArchiviata;
import it.unica.avis.model.DonazioneArchiviataFactory;
import it.unica.avis.model.SessioneDonazione;
import it.unica.avis.model.SessioneDonazioneFactory;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Claudio Loriga
 */
@WebServlet(name = "AggiungiSessioneArchiviataServlet", urlPatterns = {"/AggiungiSessioneArchiviataServlet"})
public class AggiungiSessioneArchiviataServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean sessione_archiviata, sessione_rimossa;
        String genericError = "La sessione non è stata archiviata correttamente, riprova";
        String campoVuoto = "Un campo non è stato compilato, riprova";
        String dataInseritaScorrettamente = "La data non è stata inserita correttamente, deve rispettare il formato gg/mm/aaaa";
        DonazioneArchiviata sessione_da_archiviare = new DonazioneArchiviata();
        SessioneDonazione sessione_da_rimuovere = new SessioneDonazione();

        String utente = request.getParameter("utente_sessione");
        if (utente.isEmpty()) {
            pubblicaErrore(request, response, campoVuoto);
        }
        String data_grezza = request.getParameter("data_sessione");
        if (data_grezza.isEmpty() || !data_grezza.matches("([0-9]+[\\/]){2}[0-9]{4}")) {
            pubblicaErrore(request, response, dataInseritaScorrettamente);
        }
        Date data;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(data_grezza);
        } catch (ParseException e) {
            data = new Date(0L);
        }
        String qsp = request.getParameter("qsp_sessione");
        if (qsp.isEmpty()) {
            pubblicaErrore(request, response, campoVuoto);
        }
        String note_sessione = request.getParameter("note_sessione");
        sessione_da_archiviare.setUsername(utente);
        sessione_da_archiviare.setData_sessione(new java.sql.Date(data.getTime()));
        sessione_da_archiviare.setQsp(qsp);
        sessione_da_archiviare.setNote(note_sessione);
        sessione_archiviata = DonazioneArchiviataFactory.setSessioneIntoDb(sessione_da_archiviare);

        sessione_da_rimuovere.setId(Long.parseLong(request.getParameter("idSessione")));
        sessione_rimossa = SessioneDonazioneFactory.DeleteSessioneFromDb(sessione_da_rimuovere);

        if (sessione_archiviata && sessione_rimossa) {
            request.getRequestDispatcher("sessioneArchiviata.jsp").forward(request, response);
        } else {
            pubblicaErrore(request, response, genericError);
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
