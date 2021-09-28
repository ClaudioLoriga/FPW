/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class RecensioneFactory {

    private static RecensioneFactory instance;

    private RecensioneFactory() {
    }

    public static RecensioneFactory getInstance() {
        if (instance == null) {
            instance = new RecensioneFactory();
        }
        return instance;
    }

    public List<Recensione> getAllRecensioni() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<Recensione> recensioni = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM recensione";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();

            while (set.next()) {
                Recensione recensione = new Recensione();
                recensione.setId(set.getLong("id"));
                recensione.setVoto(set.getInt("voto"));
                recensione.setCommento(set.getString("commento"));
                recensione.setNum_like(set.getInt("num_like"));
                recensione.setUtente_id(set.getString("utente_id"));
                recensione.setMonopattino_id(set.getLong("monopattino_id"));
                Timestamp ts = set.getTimestamp("data");
                LocalDateTime localDt = null;
                if (ts != null) {
                    localDt = LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(ts.getTime()), ZoneOffset.UTC);
                }
                recensione.setData(localDt);
                recensioni.add(recensione);
            }
            return recensioni;
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

    public Recensione getRecensione(String offset) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        Recensione recensione = new Recensione();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM recensione LIMIT 1 OFFSET ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(offset));
            set = stmt.executeQuery();

            while (set.next()) {
                recensione.setId(set.getLong("id"));
                recensione.setVoto(set.getInt("voto"));
                recensione.setCommento(set.getString("commento"));
                recensione.setNum_like(set.getInt("num_like"));
                recensione.setUtente_id(set.getString("utente_id"));
                recensione.setMonopattino_id(set.getLong("monopattino_id"));
                Timestamp ts = set.getTimestamp("data");
                LocalDateTime localDt = null;
                if (ts != null) {
                    localDt = LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(ts.getTime()), ZoneOffset.UTC);
                }
                recensione.setData(localDt);
            }
            return recensione;

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

    public static void setRecensioneIntoDb(Recensione nuova_recensione) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO recensione" + "(id, voto, commento, num_like, utente_id)" + "VALUES" + "(?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setLong(1, nuova_recensione.getId());
            stmt.setInt(2, nuova_recensione.getVoto());
            stmt.setString(3, nuova_recensione.getCommento());
            stmt.setInt(4, nuova_recensione.getNum_like());
            stmt.setString(5, nuova_recensione.getUtente_id());
            set = stmt.executeQuery();

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
    }
}
