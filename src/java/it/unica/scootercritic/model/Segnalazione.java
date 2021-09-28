package it.unica.scootercritic.model;

import java.time.LocalDateTime;

public class Segnalazione {

    private long id;
    private String oggetto;
    private String testo;
    private LocalDateTime data;
    private String utente_id;

    public Segnalazione() {
    }

    ;

    public long getId() {
        return id;
    }

    public String getOggetto() {
        return oggetto;
    }

    public String getTesto() {
        return testo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getUtente_id() {
        return utente_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setUtente_id(String utente_id) {
        this.utente_id = utente_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Segnalazione other = (Segnalazione) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
