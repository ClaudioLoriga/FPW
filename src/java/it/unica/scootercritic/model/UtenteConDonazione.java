/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.model;

import java.util.Objects;

/**
 *
 * @author fpw
 */
public class UtenteConDonazione {
    
    public UtenteConDonazione(Utente insUtente, int numDonazioni) {
        utente = insUtente;
        numeroDonazioni = numDonazioni; 
    }
    
    private final Utente utente;
    private final int numeroDonazioni;

    public Utente getUtente() {
        return utente;
    }

    public int getNumeroDonazioni() {
        return numeroDonazioni;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.utente);
        hash = 83 * hash + this.numeroDonazioni;
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
        final UtenteConDonazione other = (UtenteConDonazione) obj;
        if (this.numeroDonazioni != other.numeroDonazioni) {
            return false;
        }
        if (!Objects.equals(this.utente, other.utente)) {
            return false;
        }
        return true;
    }
    
    
}
