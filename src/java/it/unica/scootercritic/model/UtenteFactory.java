package it.unica.scootercritic.model;

import it.unica.scootercritic.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtenteFactory {

    private static UtenteFactory instance;

    private UtenteFactory() {
    }

    public static UtenteFactory getInstance() {
        if (instance == null) {
            instance = new UtenteFactory();
        }
        return instance;
    }

    public Utente getUtenteByUsernamePassword(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();

            String query = "SELECT * FROM utente WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            set = stmt.executeQuery();

            if (set.next()) {
                Utente utente = new Utente();
                utente.setUsername(set.getString("username"));
                utente.setPassword(set.getString("password"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setCf(set.getString("codice_fiscale"));
                utente.setSesso(set.getString("sesso"));
                utente.setEmail(set.getString("email"));
                utente.setTelefono(set.getString("telefono"));
                utente.setGs(set.getString("gruppo_sanguigno"));
                utente.setPatologie(set.getString("patologie"));
                utente.setFoto(set.getString("foto"));
                utente.setDataDiNascita(set.getDate("data"));
                return utente;
            } else {
                return null;
            }
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

    public static boolean setUtenteIntoDb(Utente nuovo_utente) { 
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO utente VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nuovo_utente.getUsername());
            stmt.setString(2, nuovo_utente.getPassword());
            stmt.setString(3, nuovo_utente.getNome());
            stmt.setString(4, nuovo_utente.getCognome());
            stmt.setString(5, nuovo_utente.getCf());
            stmt.setString(6, nuovo_utente.getSesso());
            stmt.setString(7, nuovo_utente.getEmail());
            stmt.setString(8, nuovo_utente.getGs());
            stmt.setString(9, nuovo_utente.getPatologie());
            stmt.setString(10, nuovo_utente.getFoto());
            stmt.setDate(11, nuovo_utente.getDataDiNascita());
            stmt.setString(12, nuovo_utente.getTelefono());
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
    
        public static boolean DeleteUtenteFromDb(Utente old_utente) { 
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "DELETE FROM utente WHERE username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, old_utente.getUsername());
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
    
    
    
        /*public static boolean ModifyUtenteIntoDb(Utente utente, ) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;

        try {
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO utente VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nuovo_utente.getUsername());
            stmt.setString(2, nuovo_utente.getPassword());
            stmt.setString(3, nuovo_utente.getNome());
            stmt.setString(4, nuovo_utente.getCognome());
            stmt.setString(5, nuovo_utente.getCf());
            stmt.setString(6, nuovo_utente.getSesso());
            stmt.setString(7, nuovo_utente.getEmail());
            stmt.setString(8, nuovo_utente.getGs());
            stmt.setString(9, nuovo_utente.getPatologie());
            stmt.setString(10, nuovo_utente.getFoto());
            stmt.setDate(11, nuovo_utente.getDataDiNascita());
            stmt.setString(12, nuovo_utente.getTelefono());
            //System.out.println(stmt);
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
*/
}
