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

@WebServlet(name = "RegistrazioneServlet", urlPatterns = {"/registrazione"})
public class RegistrazioneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean registrazioneAvvenuta;
        String erroreRegistrazione = "La registrazione non è avvenuta";
        HttpSession session = request.getSession(); // Crea una nuova sessione o recpera quella esistente

        String user = request.getParameter("username_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
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
        utente.setFoto(immagine);
        registrazioneAvvenuta = UtenteFactory.setUtenteIntoDb(utente);

        if (registrazioneAvvenuta) { 
            session.setAttribute("user", utente.getUsername()); // Imposta utente
            session.setAttribute("utente", utente);
            session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime())); // Imposta last login
            session.setMaxInactiveInterval(30); // Tempo massimo di inattività (in secondi) prima che la sessione scada
            request.getRequestDispatcher("registrazioneEffettuata.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", erroreRegistrazione);
            request.setAttribute("link", "login.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
}
