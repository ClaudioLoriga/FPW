<%-- 
    Document   : news
    Author     : Claudio Loriga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ScooterCritic News</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    <body>
        <c:set var="page" value="news" scope="request"/>
        <jsp:include page="header.jsp"/>
        <h1>Notizie più recenti</h1>

        <article class="news">
            <h2 class="newsTitle">“Donare è partecipare” la nuova campagna Avis dedicata ai volontari</h2>
            <b class="newsDate">7 Dicembre 2021</b>
            <p class="newsBody">
                Praticare regolarmente volontariato fa bene al corpo e allo spirito. Proprio come lo sport. Da questa analogia è nata 
                l’idea della nuova campagna di comunicazione di Avis Provinciale di Modena “Donare è partecipare” mirata a richiamare 
                nuovi volontari nella grande squadra dell’associazione. Protagonisti della campagna sono gli stessi operatori e volontari Avis, 
                quelli che si possono incontrare ogni giorno nelle sedi comunali della provincia. Chi di loro, nella vita, pratica realmente 
                una disciplina sportiva è diventato testimonial della campagna, mettendo in campo e raccontando le loro grandi passioni: lo sport 
                e il volontariato. Nelle immagini appariranno così l’infermiere ciclista, il segretario arciere, il barista podista, il tuttofare 
                pescatore e anche il presidente sciatore. La nuova campagna che invita a donare, oltre al sangue, anche un po’ del proprio tempo, 
                sarà la nuova immagine di Avis per i prossimi mesi, accompagnata dallo slogan “L’unico sport in cui vince la vita”.
            </p>
        </article>
        <article class="news">
            <h2 class="newsTitle">Festa del Donatore del sangue Premiati i volontari dell’Avis</h2>
            <b class="newsDate">8 dicembre 2021</b>
            <p class="newsBody">
                È stata un’occasione importante la recente Festa del Donatore di Sangue organizzata dall’Avis Sansepolcro, anche per consegnare 
                le benemerenze ai volontari che hanno raggiunto un numero importante di donazioni nel corso dell’anno 2020. Nel dettaglio, sono stati premiati
                coloro che hanno eseguito 16 donazioni con la medaglia d’argento, 32 donazioni con la medaglia d’oro ea chi toccato le 50 donazioni 
                è andata una medaglia d’oro con fronde. Ad una donatrice è stata conferita la croce d’oro Avis, ovvero la più prestigiosa delle benemerenze,
                per il raggiungimento di ben 75 donazioni. Un traguardo che pochi riescono a raggiungere.

                Per la prima volta e per iniziativa fortemente voluta dalla presidente locale, Silvia Nofri e condivisa dall’intero direttivo,
                sono state consegnate delle medaglie speciali per chi, sempre nel corso dell’anno 2020, ha iniziato il proprio percorso da donatore, effettuando
                la prima donazione. Il 2020 è stato un anno particolare ed è sembrato giusto introdurre un riconoscimento speciale a chi non si è tirato 
                indietro davanti all’iniziare un gesto di solidarietà unico. La serata è poi continuata con un momento di convivialità vissuto nel rispetto stringente 
                delle normative anti Covid-19. Era presente anche il dottor Pietro Pantone, in rappresentanza del sistema trasfusionale Toscana Sud Est,
                che ha operato al centro trasfusionale di Sansepolcro per molti anni.</p>
        </article>
    </body>
</html>
