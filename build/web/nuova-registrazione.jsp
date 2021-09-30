<%-- 
    Document   : nuova-registrazione
    Created on : Sep 30, 2021, 10:41:51 AM
    Author     : fpw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ScooterCritic - Login</title>
        <meta name="author" content="Valentino Artizzu">
        <meta name="description" content="Accesso al sito">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="loginBoxUser">
            <a href="index.jsp"><img title="Logo" alt="Logo avis old" src="img/logo_avis_old.jpg"></a>
            <h1>Registrati!</h1>
            <form action="login" method="post">
                <label for="user">Inserisci uno username</label>
                <input id="usernameLogin" type="text" id="user" name="username_registrazione"/>
                <label for="pass">Inserisci una password</label>
                <input type="text" id="pass" name="password_registrazione"/>
                <label for="nome">Inserisci il tuo nome</label>
                <input type="text" id="nome" name="nome_registrazione"/>
                <label for="nome">Inserisci il tuo cognome</label>
                <input type="text" id="cognome" name="cognome_registrazione"/>
                <label for="nome">Inserisci la tua data di nascita</label>
                <input type="text" id="data" name="data_di_nascita_registrazione"/>
                <label for="nome">Inserisci il tuo codice fiscale</label>
                <input type="text" id="cf" name="cf_registrazione"/>
                <label for="nome">Inserisci la tua data di nascita</label>
                <input type="text" id="nome" name="nome_registrazione"/>
                <label>Inserisci il tuo sesso:</label><br>
                <select name="monopattino">
                    <option value="Maschio">Maschio</option>
                    <option value="Femmina">Femmina</option>
                    <option value="Altro">Lesbica, Gay, Bisex, Trans, Quirr, +</option>
                </select>
                <label for="nome">Inserisci la tua email</label>
                <input type="text" id="email" name="email_registrazione"/>
                <label for="nome">Inserisci il tuo numero telefonico</label>
                <input type="text" id="telefono" name="telefono_registrazione"/>
                <label for="nome">Inserisci il tuo gruppo sanguigno (A,B,AB,0)</label>
                <input type="text" id="sanguigno" name="sanguigno_registrazione"/>
                <label for="nome">Hai eventuali patologie da segnalarci?</label>
                <textarea id="descrizioneRecensione" rows="4" cols="20" name="patologie_registrazione"></textarea>
                <label for="nome">Seleziona una tua foto</label>
                <input name="file" type="file" accept="image/*"/>
                <input type="submit" value="Conferma"/>
            </form>
        </div>
    </body>
</html>
