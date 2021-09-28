package it.unica.scootercritic.servlet;

import it.unica.scootercritic.model.Immagine;
import it.unica.scootercritic.model.ImmagineFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author fpw
 */
@WebServlet(name = "FileServlet", urlPatterns = {"/upload"})
@MultipartConfig

public class FileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part file = request.getPart("file");
        try (InputStream contenutoFile = file.getInputStream()) {
            File daSalvare = new File("/home/NetBeansProjects/ScooterCritic/web/uploads/" + file.getSubmittedFileName());

            Files.copy(contenutoFile, daSalvare.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String URL = "http://localhost:8080/ScooterCritic/uploads/" + file.getSubmittedFileName();
            if (ImmagineFactory.getInstance().addImmagine(new Immagine(request.getParameter("descrizione"), file.getSubmittedFileName(), URL))) {
                request.setAttribute("messaggio", "Il tuo file è stato correttamente inserito in /uploads/" + file.getSubmittedFileName());
                request.getRequestDispatcher("fileInserito.jsp").forward(request, response);
            } else {
                request.setAttribute("messaggio", "Riferimento nel database perso. Contatta l'amministratore");
                request.getRequestDispatcher("fileInserito.jsp").forward(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("messaggio", "Caricamento del file non riuscito!");
            request.getRequestDispatcher("fileInserito.jsp").forward(request, response);
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
