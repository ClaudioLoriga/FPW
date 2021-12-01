/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.Utente;
import it.unica.scootercritic.model.UtenteFactory;
import it.unica.scootercritic.utils.Utils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ModificaUtenteServlet", urlPatterns = {"/ModificaUtenteServlet"})
public class ModificaUtenteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean registrazioneAvvenuta;
        String erroreRegistrazione = "La registrazione non è avvenuta";
        HttpSession session = request.getSession(); // Crea una nuova sessione o recpera quella esistente

        Utente old_utente = (Utente) session.getAttribute("utente"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String pass = request.getParameter("password_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String nome = request.getParameter("nome_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String cognome = request.getParameter("cognome_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String data_grezza = request.getParameter("data_di_nascita_registrazione");
        Date data_nascita;
        try {
            data_nascita = new SimpleDateFormat("dd/MM/yyyy").parse(data_grezza);
        } catch (ParseException e) {
            data_nascita = new Date(0L);
        }
        String cf = request.getParameter("cf_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String sesso = request.getParameter("sesso_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String email = request.getParameter("email_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String telefono = request.getParameter("telefono_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String gs = request.getParameter("sanguigno_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String patologie = request.getParameter("patologie_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String immagine = request.getParameter("immagine_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        Utente modified_utente = new Utente();
        modified_utente.setUsername(old_utente.getUsername());
        modified_utente.setPassword(pass);
        modified_utente.setNome(nome);
        modified_utente.setCognome(cognome);
        modified_utente.setDataDiNascita(new java.sql.Date(data_nascita.getTime()));
        modified_utente.setCf(cf);
        modified_utente.setSesso(sesso);
        modified_utente.setEmail(email);
        modified_utente.setTelefono(telefono);
        modified_utente.setGs(gs);
        modified_utente.setPatologie(patologie);
        modified_utente.setFoto(immagine);
        UtenteFactory.DeleteUtenteFromDb(old_utente);
        registrazioneAvvenuta = UtenteFactory.setUtenteIntoDb(modified_utente);

        if (registrazioneAvvenuta) {
            session.setAttribute("utente", modified_utente);
            session.setAttribute("user", modified_utente.getUsername()); // Imposta utente
            session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime())); // Imposta last login
            session.setMaxInactiveInterval(30); // Tempo massimo di inattività (in secondi) prima che la sessione scada
            request.getRequestDispatcher("modificaEffettuata.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", erroreRegistrazione);
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
