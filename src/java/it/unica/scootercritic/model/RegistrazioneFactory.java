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

/**
 *
 * @author fpw
 */
public class RegistrazioneFactory {

    private static RegistrazioneFactory instance;

    private RegistrazioneFactory() {
    }

    public static RegistrazioneFactory getInstance() {
        if (instance == null) {
            instance = new RegistrazioneFactory();
        }
        return instance;
    }

    public static boolean setUtenteIntoDb(Registrazione nuova_registrazione) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO utente VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nuova_registrazione.getUsername());
            stmt.setString(2, nuova_registrazione.getPassword());
            stmt.setString(3, nuova_registrazione.getNome());
            stmt.setString(4, nuova_registrazione.getCognome());
            stmt.setString(5, nuova_registrazione.getData_di_nascita());
            stmt.setString(6, nuova_registrazione.getCf());
            stmt.setString(7, nuova_registrazione.getSesso());
            stmt.setString(8, nuova_registrazione.getEmail());
            stmt.setInt(9, nuova_registrazione.getTelefono());
            stmt.setString(10, nuova_registrazione.getGs());
            stmt.setString(11, nuova_registrazione.getPatologie());
            stmt.setString(12, nuova_registrazione.getFoto());
            set = stmt.executeQuery();
            return true;

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

}
