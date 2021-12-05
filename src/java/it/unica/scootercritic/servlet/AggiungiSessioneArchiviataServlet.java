/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.DonazioneArchiviata;
import it.unica.scootercritic.model.DonazioneArchiviataFactory;
import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
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
 * @author fpw
 */
@WebServlet(name = "AggiungiSessioneArchiviataServlet", urlPatterns = {"/AggiungiSessioneArchiviataServlet"})
public class AggiungiSessioneArchiviataServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean sessione_archiviata, sessione_rimossa;
        String genericError = "Qualcosa è andato storto, riprova";
        DonazioneArchiviata sessione_da_archiviare = new DonazioneArchiviata();
        SessioneDonazione sessione_da_rimuovere = new SessioneDonazione();

        HttpSession session = request.getSession(); // Crea una nuova sessione o recpera quella esistente
        String utente = request.getParameter("utente_sessione");
        String data_grezza = request.getParameter("data_sessione");
        Date data;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(data_grezza);
        } catch (ParseException e) {
            data = new Date(0L);
        }
        String qsp = request.getParameter("qsp_sessione");
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
            request.setAttribute("errorMessage", genericError);
            request.setAttribute("link", "login.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
