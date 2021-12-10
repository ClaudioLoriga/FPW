<%-- 
    Document   : modifica-utente
    Author     : Claudio Loriga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Avis - Modifica Utente</title>
        <meta name="author" content="Claudio Loriga">
        <meta name="description" content="Modifica Utente">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="loginBoxUser">
            <a href="index.jsp"><img title="Logo" alt="Logo di Avis old" src="img/logo_avis_old.jpg"></a>
            <h1>Modifica i tuoi dati!</h1>
            <h2>Lo username è univoco, non può essere modificato</h2>
            <form action="ModificaUtenteServlet" method="post">
                <label for="password_registrazione">Inserisci una password</label>
                <input type="text" id="password_registrazione" name="password_registrazione"/>
                <label for="nome_registrazione">Inserisci il tuo nome</label>
                <input type="text" id="nome_registrazione" name="nome_registrazione"/>
                <label for="cognome_registrazione">Inserisci il tuo cognome</label>
                <input type="text" id="cognome_registrazione" name="cognome_registrazione"/>
                <label for="data_di_nascita_registrazione">Inserisci la tua data di nascita</label>
                <input type="text" id="data_di_nascita_registrazione" name="data_di_nascita_registrazione"/>
                <label for="cf_registrazione">Inserisci il tuo codice fiscale</label>
                <input type="text" id="cf_registrazione" name="cf_registrazione"/>
                <label>Inserisci il tuo sesso:</label><br>
                <select name="sesso_registrazione">
                    <option value="Maschio">Maschio</option>
                    <option value="Femmina">Femmina</option>
                </select>
                <br>
                <label for="email_registrazione">Inserisci la tua email</label>
                <input type="text" id="email_registrazione" name="email_registrazione"/>
                <label for="telefono_registrazione">Inserisci il tuo numero telefonico</label>
                <input type="number" id="telefono_registrazione" name="telefono_registrazione"/>
                <label>Inserisci il tuo gruppo sanguigno:</label>
                <select name="sanguigno_registrazione">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="AB">AB</option>
                    <option value="0">0</option>
                </select>
                <br>
                <label for="patologie_registrazione">Hai eventuali patologie da segnalarci?</label>
                <textarea id="patologie_registrazione" rows="4" cols="20" name="patologie_registrazione"></textarea>
                <input type="submit" value="Conferma"/>
            </form>
        </div>
    </body>
</html>
