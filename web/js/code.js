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


    $(document).on('click', '.btn', function () {

        var name = $(this).data('username');
        if (name != undefined && name != null) {
            window.location = '/player_detail?username=' + name;
        }
    });

    $('#descrizioneRecensione').keydown(function (e) {
        var key = e.keycode || e.charcode;
        if (this.value.length > 50) {
            if (!(key === 46 || key === 8)) { // backspace e delete
                e.preventDefault();
            }
        }
        if (this.value.length < 5) {
            this.style.color = "red";
        } else {
            this.style.color = "black";
        }
    });

    $('#descrizioneRecensione').keyup(function ()
    {
        $('#caratteriRimanenti').text("Caratteri: " + $(this).val().length + "/50");
    });
    var testo = '<p id="messaggioErrore">Hai inserito un voto errato!</p>';
    function controllaVoto() {
        if ($('#votoRecensione').val() < 1 || $('#votoRecensione').val() > 5)
        {
            $('#votoRecensione').addClass("error");
            $('#votoRecensione').removeClass("clear");
            if ($('#messaggioErrore').length === 0)
            {
                $('#votoRecensione').after(testo);
            }
        } else {
            $('#votoRecensione').addClass("clear");
            $('#votoRecensione').removeClass("error");
            $("#messaggioErrore").remove();
        }
    }

    $('#votoRecensione').on('change input', controllaVoto);
    $("a").on("mouseover mouseout", function ()
    {
        $(this).toggleClass("hover");
    });
    function contaClick()
    {
        var clicks = 0;
        function click()
        {
            clicks++;
            return clicks;
        }

        return click;
    }
    ;
    var contatore = contaClick();
    $("body").click(function ()
    {
        if (contatore() === 20)
        {
            alert("Ti piace Scootercritic? Attiva le notifiche!");
        }

    });
}
);

/*$("#button_archivia").click(function () {
    $("#creaSessioneDaArchiviare.jsp").submit();
});

$("#button_eliminia").click(function () {
    $("#EliminaSessioneDonazione").submit();
});
*/
$('#button_archivia').click(function(){
   window.location.href='creaSessioneDaArchiviare.jsp';
});

$('#button_elimina').click(function(){
   window.location.href='EliminaSessioneDonazione';
});


/* var avvisoLogin = document.createElement("p");
 avvisoLogin.id = "messaggioErroreLogin";
 var testoLogin = document.createTextNode("Non hai inserito sufficenti caratteri!");
 avvisoLogin.appendChild(testoLogin);
 
 
 document.getElementById("usernameLogin").onkeydown = function (e) {
 var key = e.keycode || e.charcode;
 if (this.value.length > 20) {
 if (!(key === 46 || key === 8)) { // backspace e delete
 e.preventDefault();
 }
 }
 if (this.value.length < 5) {
 this.style.color = "red";
 insertAfter(avvisoLogin, this);
 } else {
 this.style.color = "black";
 document.getElementById("messaggioErroreLogin").remove();
 }
 };
 
 
 document.getElementById('oggettoSegnalazione').onkeydown = function (e) {
 var key = e.keycode || e.charcode;
 if (this.value.length > 100) {
 if (!(key === 46 || key === 8)) { // backspace e delete
 e.preventDefault();
 }
 }
 };
 
 
 document.getElementById('corpoSegnalazione').onkeydown = function (e) {
 var key = e.keycode || e.charcode;
 if (this.value.length > 100) {
 if (!(key === 46 || key === 8)) { // backspace e delete
 e.preventDefault();
 }
 }
 };
 });
 * 
 */





