package it.unica.scootercritic.model;

import java.sql.Date;

public class DonazioneArchiviata {

    private long id;
    private String username;
    private Date data_sessione;
    private String qsp;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getData_sessione() {
        return data_sessione;
    }

    public void setData_sessione(Date data_sessione) {
        this.data_sessione = data_sessione;
    }

    public String getQsp() {
        return qsp;
    }

    public void setQsp(String qsp) {
        this.qsp = qsp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final DonazioneArchiviata other = (DonazioneArchiviata) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
