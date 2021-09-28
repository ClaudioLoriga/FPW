package it.unica.scootercritic.model;

public class Immagine {

    private long id;
    private String descrizione;
    private String nomefile;
    private String percorso;

    public Immagine() {
    }

    public Immagine(String descrizione, String nomefile, String percorso) {
        this.descrizione = descrizione;
        this.nomefile = nomefile;
        this.percorso = percorso;
    }

    public long getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNomefile() {
        return nomefile;
    }

    public String getPercorso() {
        return percorso;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNomefile(String nomefile) {
        this.nomefile = nomefile;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Immagine other = (Immagine) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
