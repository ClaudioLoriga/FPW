var caricato = false;

$("boxSuggerimenti").keydown(function()
{
   if(!caricato){
       $.ajax({
           url: "home",
           data: {
               cmd: "listaMonopattini"
           },
           dataType: "json",
           success: function(data, state) {
               caricato = true;
               popolaAutoCompletamento(data);
           },
           error : function(data, state){
               alert(state);
           }
       });
   } 
});

function popolaAutoCompletamento(lista)
{
    $.each(lista, function (k,v){
        var elemento = '<option value="' + v + '">';
        $("#listaDiMonopattini").append(elemento);
    });
}

