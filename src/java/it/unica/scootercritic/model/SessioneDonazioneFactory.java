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

public class SessioneDonazioneFactory {

    private static SessioneDonazioneFactory instance;

    private SessioneDonazioneFactory() {
    }

    public static SessioneDonazioneFactory getInstance() {
        if (instance == null) {
            instance = new SessioneDonazioneFactory();
        }
        return instance;
    }

    public List<SessioneDonazione> getAllSessioni() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<SessioneDonazione> sessioniDonazione = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM sessionedonazione WHERE prenotata = FALSE";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();

            while (set.next()) {
                SessioneDonazione sessione = new SessioneDonazione();
                sessione.setId(set.getLong("id"));
                sessione.setOra_inizio(set.getTime("ora_inizio"));
                sessione.setLuogo(set.getString("luogo"));
                sessione.setData_sessione(set.getDate("data"));
                sessione.setOra_fine(set.getTime("ora_fine"));
                sessioniDonazione.add(sessione);
            }
            return sessioniDonazione;
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

    public List<SessioneDonazione> getAllSessioniOrdered() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<SessioneDonazione> sessioniDonazione = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM sessionedonazione WHERE prenotata = FALSE ORDER BY data ASC";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();

            while (set.next()) {
                SessioneDonazione sessione = new SessioneDonazione();
                sessione.setId(set.getLong("id"));
                sessione.setOra_inizio(set.getTime("ora_inizio"));
                sessione.setLuogo(set.getString("luogo"));
                sessione.setData_sessione(set.getDate("data"));
                sessione.setOra_fine(set.getTime("ora_fine"));
                sessioniDonazione.add(sessione);
            }
            return sessioniDonazione;
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

    public List<SessioneDonazione> getAllSessioniUtente(Utente utente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<SessioneDonazione> sessioniDonazione = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM sessionedonazione WHERE username = ? ";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, utente.getUsername());
            set = stmt.executeQuery();

            while (set.next()) {
                SessioneDonazione sessione = new SessioneDonazione();
                sessione.setId(set.getLong("id"));
                sessione.setOra_inizio(set.getTime("ora_inizio"));
                sessione.setLuogo(set.getString("luogo"));
                sessione.setData_sessione(set.getDate("data"));
                sessione.setOra_fine(set.getTime("ora_fine"));
                sessioniDonazione.add(sessione);
            }
            return sessioniDonazione;
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

    public SessioneDonazione getSessione(String offset) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        SessioneDonazione sessione = new SessioneDonazione();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM sessionedonazione WHERE prenotata = FALSE LIMIT 1 OFFSET ?"; // CON LIMIT 1 PRENDO 1 SOLO ELEMENTO, OFFSET PERMETTE DI SALTARE ELEMENTI NELLA QUERY (WHERE prenotata = 0)
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(offset));
            set = stmt.executeQuery();

            while (set.next()) {
                sessione.setId(set.getLong("id"));
                sessione.setOra_inizio(set.getTime("ora_inizio"));
                sessione.setLuogo(set.getString("luogo"));
                sessione.setData_sessione(set.getDate("data"));
                sessione.setOra_fine(set.getTime("ora_fine"));
            }
            return sessione;

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

    public List<SessioneDonazione> getAllSessioniGiorno(SessioneDonazione giorno_scelto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<SessioneDonazione> sessioniDonazione = new ArrayList<>();

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM sessionedonazione WHERE data = ? AND username IS NOT NULL";
            stmt = conn.prepareStatement(query);
            stmt.setDate(1, giorno_scelto.getData_sessione());
            set = stmt.executeQuery();

            while (set.next()) {
                SessioneDonazione sessione = new SessioneDonazione();
                sessione.setId(set.getLong("id"));
                sessione.setOra_inizio(set.getTime("ora_inizio"));
                sessione.setLuogo(set.getString("luogo"));
                sessione.setData_sessione(set.getDate("data"));
                sessione.setOra_fine(set.getTime("ora_fine"));
                sessioniDonazione.add(sessione);
            }
            return sessioniDonazione;
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

    public static boolean setSessioneIntoDb(SessioneDonazione nuova_sessione) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO sessionedonazione VALUES" + "(default,?,?,?,?,false,null)";
            stmt = conn.prepareStatement(query);
            stmt.setTime(1, nuova_sessione.getOra_inizio());
            stmt.setString(2, nuova_sessione.getLuogo());
            stmt.setDate(3, nuova_sessione.getData_sessione());
            stmt.setTime(4, nuova_sessione.getOra_fine());
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

    public static boolean ModifySessioneIntoDb(SessioneDonazione sessione_prenotata, Utente utente) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "UPDATE sessionedonazione SET prenotata = TRUE, username = ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, utente.getUsername());
            stmt.setLong(2, sessione_prenotata.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
            //if (e instanceof PSQLException && e.getMessage().equalsIgnoreCase("No results were returned by the query.")) {
            //  return true;
            //}

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

    public static boolean DeleteSessioneFromDb(SessioneDonazione nuova_sessione) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "DELETE FROM sessionedonazione WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setLong(1, nuova_sessione.getId());
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
