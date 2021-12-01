package it.unica.scootercritic.model;

import it.unica.scootercritic.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonazioneArchiviataFactory {

    private static DonazioneArchiviataFactory instance;

    private DonazioneArchiviataFactory() {
    }

    public static DonazioneArchiviataFactory getInstance() {
        if (instance == null) {
            instance = new DonazioneArchiviataFactory();
        }
        return instance;
    }
    
        public static boolean setSessioneIntoDb(DonazioneArchiviata donazione_da_archiviare) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO donazionearchiviata VALUES" + "(default,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, donazione_da_archiviare.getUsername());
            stmt.setDate(2, donazione_da_archiviare.getData_sessione());
            stmt.setString(3, donazione_da_archiviare.getQsp());
            stmt.setString(4, donazione_da_archiviare.getNote());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);

        } finally {
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
        
        

}
