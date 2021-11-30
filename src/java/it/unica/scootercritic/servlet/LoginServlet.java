/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.servlet;

import it.unica.scootercritic.exceptions.InvalidParamException;
import it.unica.scootercritic.model.Utente;
import it.unica.scootercritic.model.UtenteFactory;
import it.unica.scootercritic.utils.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); // Crea una nuova sessione o recpera quella esistente
        String user = request.getParameter("user"); // Recupera i parametri passati dal client (login.jsp)
        String pass = request.getParameter("pass");

        try {
            Utils.checkString(user, 5, 20); // Valida parametri ricevuti
            // Utils.checkString(pass, 8, 50);

            Utente utente = UtenteFactory.getInstance().getUtenteByUsernamePassword(user, pass);

            if (user.contentEquals("Loriga") && pass.contentEquals("65804")) // ACCESSO COME AMMINISTRATORE 
            {
                session.setAttribute("user", utente.getUsername()); // Imposta utente username
                session.setAttribute("utente", utente);
                session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime())); // Imposta last login
                session.setMaxInactiveInterval(600); // Tempo massimo di inattività (in secondi) prima che la sessione scada
                response.sendRedirect("home"); // Redirect alla servlet user
            }

            if (utente != null) { // Verifica se le credenziali sono corrette
                session.setAttribute("user", utente.getUsername()); // Imposta utente username
                session.setAttribute("utente", utente);
                session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime())); // Imposta last login
                session.setMaxInactiveInterval(600); // Tempo massimo di inattività (in secondi) prima che la sessione scada
                response.sendRedirect("home"); // Redirect alla servlet user
            } else {
                throw new InvalidParamException("User o pass non validi!");
            }

        } catch (InvalidParamException e) {
            session.invalidate(); // Invalida sessione
            request.setAttribute("errorMessage", e.getMessage()); // Imposta parametri richiesta
            request.setAttribute("link", "login.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response); // Inoltra alla pagina di errore
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

    private boolean login(String user, String pass) {
        switch (user) {
            case "giovanni_soli":
            case "jack_cabras":
            case "aldo_pelosi":
                if (user.equals(pass)) {
                    return true;
                }
        }

        return false;
    }

}
