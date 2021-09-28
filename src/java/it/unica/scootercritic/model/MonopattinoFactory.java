package it.unica.scootercritic.model;

import it.unica.scootercritic.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

public class MonopattinoFactory {

    private static MonopattinoFactory instance;

    private MonopattinoFactory() {
    }

    public static MonopattinoFactory getInstance() {
        if (instance == null) {
            instance = new MonopattinoFactory();
        }
        return instance;
    }

    public List<Monopattino> getAllMonopattini() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<Monopattino> monopattini = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM monopattino";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();

            while (set.next()) {
                Monopattino monopattino = new Monopattino();
                monopattino.setId(set.getLong("id"));
                monopattino.setNome(set.getString("nome"));
                monopattino.setModello(set.getString("modello"));
                monopattino.setDescrizione(set.getString("descrizione"));
                monopattino.setPrezzo(set.getFloat("prezzo"));
                monopattino.setFoto(set.getString("foto"));
                monopattini.add(monopattino);
            }
            return monopattini;
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

    public ArrayList<String> getSuggerimenti() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        ArrayList<String> monopattini = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT nome, modello FROM monopattino";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();

            while (set.next()) {
                monopattini.add(set.getString("nome") + " " + set.getString("modello"));
            }
            return monopattini;
            
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
