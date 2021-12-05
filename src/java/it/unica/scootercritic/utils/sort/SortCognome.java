package it.unica.scootercritic.utils.sort;

import it.unica.scootercritic.model.UtenteConDonazione;
import java.util.Comparator;

/**
 *
 * @author fpw
 */
public class SortCognome implements Comparator<UtenteConDonazione>{

    @Override
    public int compare(UtenteConDonazione u1, UtenteConDonazione u2) {
        return u1.getUtente().getCognome().compareToIgnoreCase(u2.getUtente().getCognome());
    }

}
