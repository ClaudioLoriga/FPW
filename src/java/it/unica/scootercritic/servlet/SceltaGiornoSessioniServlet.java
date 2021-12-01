package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.utils.Utils;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Claudio Loriga
 */

@WebServlet(name = "SceltaGiornoSessioniServlet", urlPatterns = {"/SceltaGiornoSessioniServlet"})
public class SceltaGiornoSessioniServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String data_sessioni_grezza = request.getParameter("data_sessione_search");
        Date data_sessioni;
        try {
            data_sessioni = new SimpleDateFormat("dd/MM/yyyy").parse(data_sessioni_grezza);
        } catch (ParseException e) {
            data_sessioni = new Date(0L);
        }
        SessioneDonazione sessione_giorno = new SessioneDonazione();
        sessione_giorno.setData_sessione(new java.sql.Date(data_sessioni.getTime()));
        List<SessioneDonazione> sessioni = SessioneDonazioneFactory.getInstance().getAllSessioniGiorno(sessione_giorno);

            request.setAttribute("listaSessioni", sessioni); 
            request.getRequestDispatcher("gestisciSessioniDonazioni.jsp").forward(request, response);

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

}
