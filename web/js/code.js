$(document).ready(function ()
{
    var offset = 0;
    $('#prevReview').click(function ()
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
                aggiornaRecensione(data);
            },
            error: function (data, state) {

            }
        });
    });

    $('#nextReview').click(function ()
    {
        offset++;
        $.ajax({
            url: "home",
            data: {
                offsetId: offset
            },
            dataType: "json",
            success: function (data, state) {
                if (data.user === "") {
                    offset--;
                } else {
                    aggiornaRecensione(data);
                }
            },
            error: function (data, state) {
                
            }
        });
    });
    
    function aggiornaRecensione (recensione)
    {
        $('#titoloRecensione').html("Recensione di " + recensione.user + "del" + recensione.data);
        $('#commentoRecensione').text(recensione.desc);
        $('#statisticheRecensione').html("<b>Giudizio:</b>" + recensione.voto + "<b>Like:</b>" + recensione.like);
    }


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





