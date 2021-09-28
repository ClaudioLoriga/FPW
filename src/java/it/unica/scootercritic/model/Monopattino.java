package it.unica.scootercritic.model;

public class Monopattino {

    private long id;
    private String nome;
    private String modello;
    private String descrizione;
    private float prezzo;
    private String foto;

    public Monopattino() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getModello() {
        return modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getFoto() {
        return foto;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Monopattino other = (Monopattino) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
