package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.Registrazione;
import it.unica.scootercritic.model.RegistrazioneFactory;
import it.unica.scootercritic.utils.Utils;
import java.io.IOException;
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
        String data = request.getParameter("data_di_nascita_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String cf = request.getParameter("cf_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String sesso = request.getParameter("sesso_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String email = request.getParameter("email_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        int telefono = Integer.parseInt(request.getParameter("telefono_registrazione")); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String gs = request.getParameter("sanguigno_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String patologie = request.getParameter("patologie_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        String immagine = request.getParameter("immagine_registrazione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        Registrazione registrazione = new Registrazione();
        registrazione.setUsername(user);
        registrazione.setPassword(pass);
        registrazione.setNome(nome);
        registrazione.setCognome(cognome);
        registrazione.setData_di_nascita(data);
        registrazione.setCf(cf);
        registrazione.setSesso(sesso);
        registrazione.setEmail(email);
        registrazione.setTelefono(telefono);
        registrazione.setGs(gs);
        registrazione.setPatologie(patologie);
        registrazione.setFoto(immagine);
        registrazioneAvvenuta = RegistrazioneFactory.setUtenteIntoDb(registrazione);
        
        if (registrazioneAvvenuta) { // Verifica se le credenziali sono corrette
            session.setAttribute("user", registrazione.getUsername()); // Imposta utente
            session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime())); // Imposta last login
            session.setMaxInactiveInterval(30); // Tempo massimo di inattività (in secondi) prima che la sessione scada
            request.getRequestDispatcher("registrazioneEffettuata.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", erroreRegistrazione);
            request.setAttribute("link", "nuovo-post.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

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
