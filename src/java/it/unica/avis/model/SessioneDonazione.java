/**
 *
 * @author Claudio Loriga
 */

package it.unica.avis.model;

import java.sql.Time;
import java.sql.Date;

public class SessioneDonazione {

    private long id;
    private Time ora_inizio;
    private Time ora_fine;
    private String luogo;
    private Date data_sessione;
    private Boolean prenotata;
    private String username;

    public SessioneDonazione() {
    }

    public long getId() {
        return id;
    }

    public Time getOra_inizio() {
        return ora_inizio;
    }

    public Time getOra_fine() {
        return ora_fine;
    }

    public String getLuogo() {
        return luogo;
    }

    public Date getData_sessione() {
        return data_sessione;
    }

    public Boolean getPrenotata() {
        return prenotata;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOra_inizio(Time ora_inizio) {
        this.ora_inizio = ora_inizio;
    }

    public void setOra_fine(Time ora_fine) {
        this.ora_fine = ora_fine;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public void setData_sessione(Date data_sessione) {
        this.data_sessione = data_sessione;
    }

    public void setPrenotata(Boolean prenotata) {
        this.prenotata = prenotata;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SessioneDonazione other = (SessioneDonazione) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
