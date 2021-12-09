package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Claudio Loriga
 */
@WebServlet(name = "AnnullaPrenotazioneServlet", urlPatterns = {"/AnnullaPrenotazioneServlet"})
public class AnnullaPrenotazioneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean sessione_annullata;
        String genericError = "Qualcosa è andato storto, riprova";
        SessioneDonazione sessioneDonazione = new SessioneDonazione();

        sessioneDonazione.setId(Long.parseLong(request.getParameter("idSessione")));
        sessione_annullata = SessioneDonazioneFactory.AnnullaSessione(sessioneDonazione);
        if (sessione_annullata) {
            request.getRequestDispatcher("annullamentoEffettuato.jsp").forward(request, response);
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
