package it.unica.avis.servlet;

import it.unica.avis.model.Utente;
import it.unica.avis.model.UtenteFactory;
import it.unica.avis.utils.Utils;
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
 * @author Claudio Loriga 
 */
@WebServlet(name = "ModificaUtenteServlet", urlPatterns = {"/ModificaUtenteServlet"})
public class ModificaUtenteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean modificaAvvenuta;
        String erroreRegistrazione = "La registrazione non è avvenuta";
        String campoVuoto = "Un campo non è stato compilato, riprova";
        String dataInseritaScorrettamente = "La data non è stata inserita correttamente, deve rispettare il formato gg/mm/aaaa";
        String cfScorretto = "Il codice fiscale inserito non è corretto";
        String emailScorretta = "L'email inserita non è corretta";
        String telefonoScorretto = "Il numero inserito non è corretto";
        HttpSession session = request.getSession();

        Utente old_utente = (Utente) session.getAttribute("utente"); 
        String pass = request.getParameter("password_registrazione"); 
        if (pass.isEmpty()) {
            pubblicaErrore(request, response, campoVuoto);
        }
        String nome = request.getParameter("nome_registrazione");
        if (nome.isEmpty()) {
            pubblicaErrore(request, response, campoVuoto);
        }
        String cognome = request.getParameter("cognome_registrazione");
        if (cognome.isEmpty()) {
            pubblicaErrore(request, response, campoVuoto);
        }
        String data_grezza = request.getParameter("data_di_nascita_registrazione");
        if (data_grezza.isEmpty() || !data_grezza.matches("([0-9]+[\\/]){2}[0-9]{4}")) {
            pubblicaErrore(request, response, dataInseritaScorrettamente);
        }
        Date data_nascita;
        try {
            data_nascita = new SimpleDateFormat("dd/MM/yyyy").parse(data_grezza);
        } catch (ParseException e) {
            data_nascita = new Date(0L);
        }
        String cf = request.getParameter("cf_registrazione");
        if (cf.isEmpty() || cf.length() > 16) {
            pubblicaErrore(request, response, cfScorretto);
        }
        String sesso = request.getParameter("sesso_registrazione"); 
        String email = request.getParameter("email_registrazione"); 
        if (email.isEmpty() || !email.matches("[A-Za-z0-9]+[@][A-Za-z0-9]+[.][a-z]+")) {
            pubblicaErrore(request, response, emailScorretta);
        }
        String telefono = request.getParameter("telefono_registrazione");
        if (telefono.isEmpty() || !telefono.matches("[0-9]{10}")) {
            pubblicaErrore(request, response, telefonoScorretto);
        }
        String gs = request.getParameter("sanguigno_registrazione");
        String patologie = request.getParameter("patologie_registrazione");
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
        UtenteFactory.DeleteUtenteFromDb(old_utente);
        modificaAvvenuta = UtenteFactory.setUtenteIntoDb(modified_utente);

        if (modificaAvvenuta) {
            pubblicaUtente(session, request, response, modified_utente);
        } else {
            pubblicaErrore(request, response, erroreRegistrazione);
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

    private void pubblicaUtente(HttpSession session, HttpServletRequest request, HttpServletResponse response, Utente utente) throws ServletException, IOException {
        session.setAttribute("user", utente.getUsername());
        session.setAttribute("utente", utente);
        session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime()));
        session.setMaxInactiveInterval(30);
        request.getRequestDispatcher("modificaEffettuata.jsp").forward(request, response);
    }

    private void pubblicaErrore(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("errorMessage", error);
        request.setAttribute("link", "index.jsp");
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
}
