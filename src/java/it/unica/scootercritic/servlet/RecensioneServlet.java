/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.servlet;

import java.lang.Math;
import it.unica.scootercritic.model.Recensione;
import it.unica.scootercritic.model.RecensioneFactory;
import it.unica.scootercritic.utils.Utils;
import it.unica.scootercritic.exceptions.InvalidParamException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
 * @author fpw
 */
@WebServlet(name = "RecensioneServlet", urlPatterns = {"/recensione"})
public class RecensioneServlet extends HttpServlet {
    private static long id = 6;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {

            // Recupera il valore dei parametri passati dal client
            String descrizione = request.getParameter("descrizione");
            String monopattino = request.getParameter("monopattino");
            int voto = Integer.parseInt(request.getParameter("voto"));
            String voto_check = request.getParameter("voto");
            String utente_id = (String) session.getAttribute("user");
            Recensione recensione = new Recensione();
            recensione.setId(id++);
            recensione.setCommento(descrizione);
            recensione.setUtente_id(utente_id);
            recensione.setNum_like((int) (Math.random()));
            recensione.setVoto(voto);
            LocalDateTime localDt = LocalDateTime.now();
            recensione.setData(localDt);
            RecensioneFactory.setRecensioneIntoDb(recensione);

            try {
                int min = 5;
                int max = 50;

                Utils.checkString(descrizione, min, max);
                Utils.checkString(monopattino, min, max);
                Utils.checkInteger(voto_check, 1, 5);

                List<String> listaMonopattini = new ArrayList<>();
                listaMonopattini.add("CorriVeloce Classic");
                listaMonopattini.add("DueRuote Roadster");
                listaMonopattini.add("RisoPiccolo RisoScooter");
                request.setAttribute("listaMonopattini", listaMonopattini);
                request.getRequestDispatcher("recensioneInserita.jsp").forward(request, response);

            } catch (InvalidParamException e) {
                request.setAttribute("errorMessage", e.getMessage());
                request.setAttribute("link", "nuovo-post.jsp");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } else {
            response.sendRedirect("login.jsp");
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
