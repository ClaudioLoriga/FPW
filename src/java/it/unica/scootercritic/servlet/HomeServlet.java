package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Claudio Loriga
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("offsetId");
        if (command != null) {
            SessioneDonazione sessione = SessioneDonazioneFactory.getInstance().getSessione(Integer.parseInt(command));
            if (sessione.getData_sessione().after(new Date(System.currentTimeMillis()))) {
                request.setAttribute("sessione", sessione);
                response.setContentType("application/json");
                response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
                request.getRequestDispatcher("sessioneJSON.jsp").forward(request, response);
            } else {
                sessione = SessioneDonazioneFactory.getInstance().getSessione(Integer.parseInt(command) + 1);
                request.setAttribute("sessione", sessione);
                response.setContentType("application/json");
                response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
                request.getRequestDispatcher("sessioneJSON.jsp").forward(request, response);
            }
        } else {
            SessioneDonazione sessione = SessioneDonazioneFactory.getInstance().getSessione(0); // SE IL COMANDO È NULL, VIENE CARICATA LA PRIMA RECENSIONE E CARICHIAMO LA JSP COME SE FOSSE UNA RICHIESTA NORMALE
            if (sessione.getData_sessione().after(new Date(System.currentTimeMillis()))) {
                request.setAttribute("sessione", sessione);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                sessione = SessioneDonazioneFactory.getInstance().getSessione(1);
                request.setAttribute("sessione", sessione);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
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

}
