/**
 *
 * @author Claudio Loriga
 */
package it.unica.avis.sort;

import it.unica.avis.model.UtenteConDonazione;
import java.util.Comparator;

public class SortDonazioni implements Comparator<UtenteConDonazione> {

    @Override
    public int compare(UtenteConDonazione u1, UtenteConDonazione u2) {
        int donazioni1 = u1.getNumeroDonazioni();
        int donazioni2 = u2.getNumeroDonazioni();

        return donazioni2 - donazioni1;
    }

}
