package it.unica.scootercritic.model;

import java.util.Objects;

public class Registrazione {

    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String data_di_nascita;
    private String cf;
    private String sesso;
    private String email;
    private int telefono;
    private String gs;
    private String patologie;
    private String foto;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getData_di_nascita() {
        return data_di_nascita;
    }

    public String getCf() {
        return cf;
    }

    public String getSesso() {
        return sesso;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getGs() {
        return gs;
    }

    public String getPatologie() {
        return patologie;
    }

    public String getFoto() {
        return foto;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setData_di_nascita(String data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public void setPatologie(String patologie) {
        this.patologie = patologie;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.username);
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
        final Registrazione other = (Registrazione) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

}
