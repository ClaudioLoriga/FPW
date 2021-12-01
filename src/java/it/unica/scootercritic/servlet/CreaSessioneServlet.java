package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import it.unica.scootercritic.model.Utente;
import it.unica.scootercritic.model.UtenteFactory;
import it.unica.scootercritic.utils.Utils;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CreaSessioneServlet", urlPatterns = {"/CreaSessioneServlet"})
public class CreaSessioneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean inserimentoAvvenuto;
        String erroreInserimento = "L'inserimento non è avvenuto correttamente";
        //HttpSession session = request.getSession(); // Crea una nuova sessione o recupera quella esistente

        String data_grezza = request.getParameter("data_sessione");
        Date data_sessione;
        try {
            data_sessione = new SimpleDateFormat("dd/MM/yyyy").parse(data_grezza);
        } catch (ParseException e) {
            data_sessione = new Date(0L);
        }
        String orario_inizio_grezzo = request.getParameter("orario_inizio_sessione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        Time orario_inizio;
        try {
            SimpleDateFormat time_format = new SimpleDateFormat("kk:mm");
            long inizio_ms = time_format.parse(orario_inizio_grezzo).getTime();
            orario_inizio = new Time(inizio_ms);
        } catch (ParseException e) {
            orario_inizio = new Time(0L);
        }

        String orario_fine_grezzo = request.getParameter("orario_fine_sessione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        Time orario_fine;
        try {
            SimpleDateFormat time_format = new SimpleDateFormat("kk:mm");
            long fine_ms = time_format.parse(orario_fine_grezzo).getTime();
            orario_fine = new Time(fine_ms);
        } catch (ParseException e) {
            orario_fine = new Time(0L);
        }

        String luogo_sessione = request.getParameter("luogo_sessione"); // Recupera i parametri passati dal client (nuova-registrazione.jsp)
        
        SessioneDonazione nuova_sessione = new SessioneDonazione();
        nuova_sessione.setData_sessione(new java.sql.Date(data_sessione.getTime()));
        nuova_sessione.setOra_inizio(orario_inizio);
        nuova_sessione.setOra_fine(orario_fine);
        nuova_sessione.setLuogo(luogo_sessione);
        inserimentoAvvenuto = SessioneDonazioneFactory.setSessioneIntoDb(nuova_sessione);

        if (inserimentoAvvenuto) {
            request.getRequestDispatcher("inserimentoEffettuato.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", erroreInserimento);
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
