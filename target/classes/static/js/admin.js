$(document).ready(function () {
    $(".dontShow").css("display", "none");


    $(document).on('change', '#torneoSeleccionado', function (event) {
        $("#selectTeam1 > select").css("display", "none");
        var tournament = $("#torneoSeleccionado option:selected").text();
        tournament = tournament.replace(/\s/g, '');
        console.log(tournament);
        $("#blankSelect").css("display", "none");
        console.log("#" + tournament);
        $("#t1" + tournament).css("display", "block");
        $("#t1" + tournament).removeClass("dontShow");


    });
    $(document).on('change', '#torneoSeleccionado', function (event) {
        $("#selectTeam2 > select").css("display", "none");
        var tournament = $("#torneoSeleccionado option:selected").text();
        tournament = tournament.replace(/\s/g, '');
        console.log(tournament);
        $("#blankSelect1").css("display", "none");
        console.log("#" + tournament);
        $("#t2" + tournament).css("display", "block");
        $("#t2" + tournament).removeClass("dontShow");


    });
    // Si se hace click sobre el input de tipo checkbox con id checkb

});
$('#win1').click(function () {
    // Si esta seleccionado (si la propiedad checked es igual a true)
    if ($(this).prop('checked')) {
        // Selecciona cada input que tenga la clase .checar
        $('#win2').prop('checked', false);
    }
});
$('#win2').click(function () {
    // Si esta seleccionado (si la propiedad checked es igual a true)
    if ($(this).prop('checked')) {
        // Selecciona cada input que tenga la clase .checar
        $('#win1').prop('checked', false);
    }
});