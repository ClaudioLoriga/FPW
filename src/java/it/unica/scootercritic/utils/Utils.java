/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.scootercritic.utils;

import it.unica.scootercritic.exceptions.InvalidParamException;
import java.util.Calendar;
import java.util.TimeZone;

public class Utils {
    
    public static void checkString(String param, int min, int max) throws InvalidParamException{
        
        if(param == null)
            throw new InvalidParamException("Parametro nullo");
        
        if(param.length() < min || param.length() > max)
            throw new InvalidParamException("Stringa non valida: "
                    + "deve avere una dimensione compresa tra "
                    + min + " e " + max + " caratteri.");
    }
    
    public static void checkInteger(String param, int min, int max) throws InvalidParamException{
    
        try{
            int valore = Integer.valueOf(param);
            if(valore<min || valore>max)
                throw new InvalidParamException("Numero non valido: "
                        + "deve essere compreso tra " + min + " e " + max);
        } catch(NumberFormatException e){
            throw new InvalidParamException("La stringa non rappresenta un numero intero");
        }
    }

    public static String convertTime(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(time);
        return (cal.get(Calendar.YEAR) + "_" + (cal.get(Calendar.MONTH) + 1) + "_" 
                + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":"
                + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
    }
}