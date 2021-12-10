$(document).ready(function ()
{
    var offset = 0;
    $("#prevReview").click(function ()
    {
        if (offset > 0)
            offset--;
        $.ajax({
            url: "home",
            data: {
                offsetId: offset 
            },
            dataType: "json",
            success: function (data, state) { 
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
                if (data.luogo === "") {
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






