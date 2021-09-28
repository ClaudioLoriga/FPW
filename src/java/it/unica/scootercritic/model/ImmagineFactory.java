package it.unica.scootercritic.model;

import it.unica.scootercritic.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImmagineFactory {

    private static ImmagineFactory instance;

    private ImmagineFactory() {
    }

    public static ImmagineFactory getInstance() {
        if (instance == null) {
            instance = new ImmagineFactory();
        }
        return instance;
    }
    
       public boolean addImmagine(Immagine image) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO immagine VALUES (default, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, image.getDescrizione());
            stmt.setString(2, image.getNomefile());
            stmt.setString(3, image.getPercorso());
            int righe = stmt.executeUpdate();

            return righe == 1;

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
        return false;
    }

    public ArrayList<Immagine> getImmagini() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        
        ArrayList<Immagine> risultato = new ArrayList<>();
        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM immagine";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();

            while (set.next()) {
                Immagine elemento = new Immagine();
                elemento.setId(set.getLong("id"));
                elemento.setDescrizione(set.getString("descrizione"));
                elemento.setNomefile(set.getString("nome_file"));
                elemento.setPercorso(set.getString("percorso"));
                risultato.add(elemento);
            }
            return risultato;

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
    
}
