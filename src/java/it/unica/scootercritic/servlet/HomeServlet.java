/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.MonopattinoFactory;
import it.unica.scootercritic.model.Recensione;
import it.unica.scootercritic.model.RecensioneFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("cmd");
        if (command != null && command.equals("recensione")) {
            Recensione recensione = RecensioneFactory.getInstance().getRecensione(request.getParameter("offsetId"));
            request.setAttribute("recensione", recensione);
            response.setContentType("application/json");
            response.setHeader("Expires", "Sat, 5 November 2005 12:00:00 GMT");
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            request.getRequestDispatcher("recensioneJSON.jsp").forward(request, response);
        } else if (command != null && command.equals("listaMonopattini")) {
            ArrayList<String> monopattini = MonopattinoFactory.getInstance().getSuggerimenti();
            request.setAttribute("monopattini", monopattini);
            response.setContentType("application/json");
            response.setHeader("Expires", "Sat, 5 November 2005 12:00:00 GMT");
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            request.getRequestDispatcher("suggerimentiJSON.jsp").forward(request, response);
        } else {
            Recensione recensione = RecensioneFactory.getInstance().getRecensione("0");
            request.setAttribute("recensione", recensione);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
