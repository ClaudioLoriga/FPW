/**
 *
 * @author Claudio Loriga
 */
package it.unica.avis.sort;

import it.unica.avis.model.UtenteConDonazione;
import java.util.Comparator;

public class SortCognome implements Comparator<UtenteConDonazione> {

    @Override
    public int compare(UtenteConDonazione u1, UtenteConDonazione u2) {
        return u1.getUtente().getCognome().compareToIgnoreCase(u2.getUtente().getCognome());
    }

}
