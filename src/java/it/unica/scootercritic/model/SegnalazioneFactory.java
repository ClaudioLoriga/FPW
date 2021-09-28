package it.unica.scootercritic.model;

import it.unica.scootercritic.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.ArrayList;

public class SegnalazioneFactory {
    private static SegnalazioneFactory instance;

    private SegnalazioneFactory() {
    }

    public static SegnalazioneFactory getInstance() {
        if (instance == null) {
            instance = new SegnalazioneFactory();
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
            String query = "SELECT * FROM segnalazione";
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
}
