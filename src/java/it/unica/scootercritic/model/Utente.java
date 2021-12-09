/**
 *
 * @author Claudio Loriga
 */

package it.unica.scootercritic.model;

import java.sql.Date;
import java.util.Objects;

public class Utente {

    private String username;
    private String password;
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private String cf;
    private String sesso;
    private String email;
    private String telefono;
    private String gs;
    private String patologie;

    public Utente() {}

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

    public Date getDataDiNascita() {
        return dataDiNascita;
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

    public String getTelefono() {
        return telefono;
    }

    public String getGs() {
        return gs;
    }

    public String getPatologie() {
        return patologie;
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

    public void setDataDiNascita(Date data_di_nascita) {
        this.dataDiNascita = data_di_nascita;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public void setPatologie(String patologie) {
        this.patologie = patologie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.username);
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
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }



}