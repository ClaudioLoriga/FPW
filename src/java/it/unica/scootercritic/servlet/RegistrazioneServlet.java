package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.Utente;
import it.unica.scootercritic.model.UtenteFactory;
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
@WebServlet(name = "RegistrazioneServlet", urlPatterns = {"/registrazione"})
public class RegistrazioneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean registrazioneAvvenuta;
        String campoVuoto = "Un campo non è stato compilato, riprova";
        String erroreRegistrazione = "La registrazione non è avvenuta";
        String erroreUsernameUtente = "Lo username è gia stato utilizzato";
        String dataInseritaScorrettamente = "La data non è stata inserita correttamente, deve rispettare il formato gg/mm/aaaa";
        String cfScorretto = "Il codice fiscale inserito non è corretto";
        String emailScorretta = "L'email inserita non è corretta";
        String telefonoScorretto = "Il numero inserito non è corretto";
        HttpSession session = request.getSession();
        List<String> nomiUtenti = UtenteFactory.getAllUtentiUsername();

        String user = request.getParameter("username_registrazione");
        for (String nome : nomiUtenti) {
            if (nome.equals(user)) {
                pubblicaErrore(request, response, erroreUsernameUtente);
            }
        }
        if (user.isEmpty()) {
            pubblicaErrore(request, response, campoVuoto);
        }
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
        Utente utente = new Utente();
        utente.setUsername(user);
        utente.setPassword(pass);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setDataDiNascita(new java.sql.Date(data_nascita.getTime()));
        utente.setCf(cf);
        utente.setSesso(sesso);
        utente.setEmail(email);
        utente.setTelefono(telefono);
        utente.setGs(gs);
        utente.setPatologie(patologie);
        registrazioneAvvenuta = UtenteFactory.setUtenteIntoDb(utente);

        if (registrazioneAvvenuta) {
            pubblicaUtente(session, request, response, utente);
        } else {
            pubblicaErrore(request, response, erroreRegistrazione);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void pubblicaUtente(HttpSession session, HttpServletRequest request, HttpServletResponse response, Utente utente) throws ServletException, IOException {
        session.setAttribute("user", utente.getUsername()); // Imposta utente
        session.setAttribute("utente", utente);
        session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime())); // Imposta last login
        session.setMaxInactiveInterval(30); // Tempo massimo di inattività (in secondi) prima che la sessione scada
        request.getRequestDispatcher("registrazioneEffettuata.jsp").forward(request, response);
    }

    private void pubblicaErrore(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("errorMessage", error);
        request.setAttribute("link", "index.jsp");
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
}
