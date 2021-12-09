$(document).ready(function ()
{
    var offset = 0;
    $("#prevReview").click(function ()
    {
        if (offset > 0)
            offset--;
        $.ajax({// EFFETTUO UNA RICHIESTA AJAX CON PARAMETRO "home"
            url: "home",
            data: {
                offsetId: offset // MANDERÀ offsetId (RENDENDOLO NON NULL NELLA SERVLET)
            },
            dataType: "json", // RICHIEDO UN RETURN DI TIPO "json"
            success: function (data, state) { // SE LA RICHIESTA HA SUCCESSO, UTILIZZO I DATI (offset) E UTILIZZO LA FUNZIONE "aggiornaSessione"
                aggiornaSessione(data);
            },
            error: function (data, state) {

            }
        });
    });

    $("#nextReview").click(function ()
    {
        offset++;
        $.ajax({
            url: "home",
            data: {
                offsetId: offset
            },
            dataType: "json",
            success: function (data, state) {
                if (data.luogo === "") { // SE IL SERVER RESTITUISCE UNA SESSIONE NON ESISTENTE (UNA SESSIONE VUOTA) RIPORTO L'OFFSET AL VALORE INIZIALE
                    offset--;
                } else {
                    aggiornaSessione(data);
                }
            },
            error: function (data, state) {

            }
        });
    });

    function aggiornaSessione(sessione)
    {
        $("#orarioSessione").html("Sessione: Inizio " + sessione.ora_inizio + " Fine " + sessione.ora_fine);
        $("#luogoSessione").html("Luogo: " + sessione.luogo);
        $("#dataSessione").html("<b>Data: </b>" + sessione.data);
    }
}
);






