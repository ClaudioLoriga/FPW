package it.unica.scootercritic.utils;

import it.unica.scootercritic.exceptions.InvalidParamException;
import it.unica.scootercritic.model.SessioneDonazione;
import it.unica.scootercritic.model.SessioneDonazioneFactory;
import java.sql.Date;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class Utils {

    public static void checkString(String param, int min, int max) throws InvalidParamException {

        if (param == null) {
            throw new InvalidParamException("Parametro nullo");
        }

        if (param.length() < min || param.length() > max) {
            throw new InvalidParamException("Stringa non valida: "
                    + "deve avere una dimensione compresa tra "
                    + min + " e " + max + " caratteri.");
        }
    }

    public static void checkInteger(String param, int min, int max) throws InvalidParamException {

        try {
            int valore = Integer.valueOf(param);
            if (valore < min || valore > max) {
                throw new InvalidParamException("Numero non valido: "
                        + "deve essere compreso tra " + min + " e " + max);
            }
        } catch (NumberFormatException e) {
            throw new InvalidParamException("La stringa non rappresenta un numero intero");
        }
    }

    public static String convertTime(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(time);
        return (cal.get(Calendar.YEAR) + "_" + (cal.get(Calendar.MONTH) + 1) + "_"
                + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":"
                + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
    }

        public static List<SessioneDonazione> checkDates(List<SessioneDonazione> sessioniUtente, int numPrenotazioniAnno) {

        List<SessioneDonazione> sessioniOrdinate = SessioneDonazioneFactory.getInstance().getAllSessioniOrdered();
        List<SessioneDonazione> sessioniAttive = new ArrayList<>();
        List<SessioneDonazione> sessioniSelezionate = new ArrayList<>();
        List<SessioneDonazione> sessioniScelte = new ArrayList<>();
        SessioneDonazione sessioneOldest = new SessioneDonazione();
        Date now = new Date(System.currentTimeMillis());
        Date dataPiuAnno;

        for (SessioneDonazione sessione : sessioniOrdinate) { // Recupero le sessioni dopo la data di oggi
            if (sessione.getData_sessione().after(now)) {
                sessioniAttive.add(sessione);
            }
        }
        if (sessioniAttive != null && (sessioniAttive.size() > 0 && sessioniUtente.size() < numPrenotazioniAnno)) {
            return sessioniAttive;
        } else { // l'utente ha uguali o maggiori prenotazioni del numero max 
            for (int i = 0; i <= numPrenotazioniAnno; i++) {
                sessioniSelezionate.add(sessioniOrdinate.get(i));
                if (sessioneOldest == null || sessioneOldest.getData_sessione().after(sessioniAttive.get(i).getData_sessione())) {
                    sessioneOldest = sessioniOrdinate.get(i);
                }
            }
            // Ho la sessione più vecchia, aggiungo 1 anno
            Calendar c = Calendar.getInstance();
            c.setTime(sessioneOldest.getData_sessione());
            c.add(Calendar.YEAR, 1);
            dataPiuAnno = new java.sql.Date((c.getTime()));

            LocalDate localDateOldest = dataPiuAnno.toLocalDate();
            for (SessioneDonazione sessione : sessioniSelezionate) {
                LocalDate localDateSessione = sessione.getData_sessione().toLocalDate();
                long daysBetween = DAYS.between(localDateSessione, localDateOldest);
                if (daysBetween > 365) {
                    sessioniScelte.add(sessione);
                }
            }
            if (sessioniScelte.isEmpty()) {
                return null;
            } else {
                return sessioniScelte;
            }
        }
    }
}