<%-- 
    Document   : index
    Author     : Claudio Loriga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AVIS</title>
        <meta name="author" content="ClaudioLoriga">
        <meta name="description" content="Il sito dell'associazione volontari italiani sangue">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/jquery.js"></script>
        <script type="text/javascript" src ="js/code.js"></script>
    </head>
    <body>
        <c:set var="page" value="index" scope="request"/>
        <jsp:include page="header.jsp"/>  
        <c:if test="${empty sessione}">
            <c:redirect url="home"/>
        </c:if>
        <c:if test="${not empty sessione}">
            <div id="intro">
                <h2>Benvenuti!</h2>
                <p>
                    In questo sito potrete <b><i>visualizzare e prenotare sessioni di donazione</i></b>
                    a vostro piacimento con un semplice click!
                    Il tutto <u>completamente online</u>!     
                </p>
            </div>           
            <div>
                <h2>Sessioni di donazione disponibili</h2>
                <div>
                    <div class="col-1">
                        <button id="prevReview"> < </button>
                    </div>
                    <div class="col-10">
                        <article>
                            <h3 id="orarioSessione" class="stats">Sessione: Inizio ${sessione.getOra_inizio()} Fine ${sessione.getOra_fine()}</h3>
                            <p id="luogoSessione">Luogo: ${sessione.getLuogo()}</p>
                            <p id="dataSessione" class="stats"><b>Data: </b>${sessione.getData_sessione()}</p>
                        </article>
                    </div>
                    <div class="col-1">
                        <button id="nextReview"> > </button>
                    </div>
                </div>
            </div>
            <footer>
                <div class="col-12">
                    <nav>
                        <ul>
                            <li><a href="https://www.facebook.com/AVIS.1927/">Facebook</a>
                            </li>
                            <li><a href="https://twitter.com/avisnazionale">Twitter</a>
                            </li>
                            <li><a href="https://www.instagram.com/avisnazionale/">Instagram</a>
                            </li>
                            <li><a href="https://www.youtube.com/user/avisnazionale">YouTube</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </footer>
        </c:if>
    </body>
</html>




