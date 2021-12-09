package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
@WebServlet(name = "DonazioniPrenotateServlet", urlPatterns = {"/DonazioniPrenotateServlet"})
public class DonazioniPrenotateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String nessunaSessione = "Non è stata trovata nessuna sessione di donazione";

        Utente user = (Utente) session.getAttribute("utente");
        List<SessioneDonazione> sessioni = SessioneDonazioneFactory.getInstance().getAllSessioniUtente(user);
        List<SessioneDonazione> sessioniPassate = new ArrayList<>();
        Date now = new Date(System.currentTimeMillis());

        for (SessioneDonazione sessione : sessioni) {
            if (sessione.getData_sessione().after(now)) {
                sessioniPassate.add(sessione);
            }
        }

        if (!sessioniPassate.isEmpty()) {
            request.setAttribute("listaSessioni", sessioniPassate);
            request.setAttribute("user", user.getUsername());
            request.getRequestDispatcher("donazioniPrenotate.jsp").forward(request, response);
        } else {
            pubblicaErrore(request, response, nessunaSessione);
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
