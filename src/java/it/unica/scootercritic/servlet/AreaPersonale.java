/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AreaPersonale", urlPatterns = {"/areaPersonale"})
public class AreaPersonale extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        
        if(session != null && session.getAttribute("user") != null){
            response.sendRedirect("areaPersonale.jsp");
        } else{
            response.sendRedirect("login.jsp");
        }
        
        
    }
    
  /*  private static AreaPersonale instance;

    private AreaPersonale() {
    }

    public static AreaPersonale getInstance() {
        if (instance == null) {
            instance = new AreaPersonale();
        }
        return instance;
    }
    
    public List<Segnalazione> getAllSegnalazioni() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<Segnalazione> segnalazioni = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM segnalazione WHERE utente_id = ?";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();

            while (set.next()) {
                Segnalazione segnalazione = new Segnalazione();
                segnalazione.setId(set.getLong("id"));
                segnalazione.setOggetto(set.getString("oggetto"));
                segnalazione.setTesto(set.getString("testo"));
                segnalazione.setUtente_id(set.getString("utente_id"));
                Timestamp ts = set.getTimestamp("data");
                LocalDateTime localDt = null;
                if (ts != null) {
                    localDt = LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(ts.getTime()), ZoneOffset.UTC);
                }
                segnalazione.setData(localDt);
                segnalazioni.add(segnalazione);
            }
            return segnalazioni;
        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }

        }
        return null;
    
    }
    */

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
