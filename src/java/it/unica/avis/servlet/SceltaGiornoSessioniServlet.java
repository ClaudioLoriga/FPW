package it.unica.avis.servlet;

import it.unica.avis.model.SessioneDonazione;
import it.unica.avis.model.SessioneDonazioneFactory;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "SceltaGiornoSessioniServlet", urlPatterns = {"/SceltaGiornoSessioniServlet"})
public class SceltaGiornoSessioniServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dataInseritaScorrettamente = "La data non è stata inserita correttamente";
        String nessunRisultato = "Non sono state trovate sessioni nel giorno desiderato!";

        String data_sessioni_grezza = request.getParameter("data_sessione_search");
        if (data_sessioni_grezza.isEmpty() || !data_sessioni_grezza.matches("([0-9]+[\\/]){2}[0-9]{4}")) {
            pubblicaErrore(request, response, dataInseritaScorrettamente);
        }
        Date data_sessioni;
        try {
            data_sessioni = new SimpleDateFormat("dd/MM/yyyy").parse(data_sessioni_grezza);
        } catch (ParseException e) {
            data_sessioni = new Date(0L);
        }
        SessioneDonazione sessione_giorno = new SessioneDonazione();
        sessione_giorno.setData_sessione(new java.sql.Date(data_sessioni.getTime()));
        List<SessioneDonazione> sessioni = SessioneDonazioneFactory.getInstance().getAllSessioniGiorno(sessione_giorno);
        if (sessioni.isEmpty()) {
            pubblicaErrore(request, response, nessunRisultato);
        } else {
            request.setAttribute("listaSessioni", sessioni);
            request.getRequestDispatcher("gestisciSessioniDonazioni.jsp").forward(request, response);
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
