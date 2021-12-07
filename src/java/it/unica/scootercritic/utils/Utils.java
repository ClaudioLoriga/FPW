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

    public static List<SessioneDonazione> filtraSessioniDisponibili(List<SessioneDonazione> sessioniOrdinate, List<SessioneDonazione> sessioniUtente, int maxPrenotazioniAnnue) {

        List<SessioneDonazione> sessioniDisponibiliFuture = new ArrayList<>();
        List<SessioneDonazione> sessioniUtentePiuRecenti;
        List<SessioneDonazione> sessioniRisultato = new ArrayList<>();
        SessioneDonazione sessioneOldest;
        Date now = new Date(System.currentTimeMillis());
        Date dataPiuAnno;

        for (SessioneDonazione sessione : sessioniOrdinate) { // Recupero le sessioni dopo la data di oggi
            if (sessione.getData_sessione().after(now)) {
                sessioniDisponibiliFuture.add(sessione);
            }
        }
        
        if (sessioniUtente.size() < maxPrenotazioniAnnue) {
            return sessioniDisponibiliFuture;
        } else { // l'utente ha uguali o maggiori prenotazioni del numero max 
            /*for (int i = 0; i <= numPrenotazioniAnno; i++) {
                sessioniPiuRecenti.add(sessioniOrdinate.get(i));
                if (sessioneOldest == null || sessioneOldest.getData_sessione().after(sessioniDisponibiliFuture.get(i).getData_sessione())) {
                    sessioneOldest = sessioniOrdinate.get(i);
                }
            }
           
             */
            sessioniUtentePiuRecenti = sessioniUtente.subList(Math.max(sessioniUtente.size() - maxPrenotazioniAnnue, 0), sessioniUtente.size());
            sessioneOldest = sessioniUtentePiuRecenti.get(0);
            
            // Ho la sessione più vecchia, aggiungo 1 anno
            Calendar c = Calendar.getInstance();
            c.setTime(sessioneOldest.getData_sessione());
            c.add(Calendar.YEAR, 1);
            dataPiuAnno = new java.sql.Date((c.getTime().getTime()));

            
            int donazioniNellAnno = 0;
            Date dateMax = dataPiuAnno;
            for (SessioneDonazione sessione : sessioniUtentePiuRecenti) {
                if (sessione.getData_sessione().before(dateMax)) {
                    //sessione entro l'anno
                    donazioniNellAnno++;
                }
            }
            
            if (donazioniNellAnno >= maxPrenotazioniAnnue) {
                //non si possono fare altre sessioni fino a dopo dateMax
                //restituisco solo sessioni oltre dateMax
                for(SessioneDonazione sessione: sessioniDisponibiliFuture) {
                    if (sessione.getData_sessione().after(dateMax)) {
                        sessioniRisultato.add(sessione);
                    }
                }
            } else {
                //si possono fare ancora donazioni prima di dateMax
                sessioniRisultato = sessioniDisponibiliFuture;
            }
            
            if (sessioniRisultato.isEmpty()) {
                return null;
            } else {
                return sessioniRisultato;
            }
        }
    }
}
