package it.unica.scootercritic.model;
import java.time.LocalDateTime;

public class Recensione {
    private long id;
    private int voto;
    private String commento;
    private LocalDateTime data;
    private int num_like;
    private String utente_id;
    private long monopattino_id;
    
    public Recensione(){}

    public long getId() {
        return id;
    }

    public int getVoto() {
        return voto;
    }

    public String getCommento() {
        return commento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getNum_like() {
        return num_like;
    }

    public String getUtente_id() {
        return utente_id;
    }

    public long getMonopattino_id() {
        return monopattino_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setNum_like(int num_like) {
        this.num_like = num_like;
    }

    public void setUtente_id(String utente_id) {
        this.utente_id = utente_id;
    }

    public void setMonopattino_id(long monopattino_id) {
        this.monopattino_id = monopattino_id;
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
        final Recensione other = (Recensione) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
