
$(document).on('change', '#servicio', function(event) {
    $('#servicioSelecionado').val($("#servicio option:selected").text());
});
$(document).on('change', '#torneoSeleccionado', function(event) {
    $('#servicioSelec').val($("#torneoSeleccionado option:selected").text());
});

// Si se hace click sobre el input de tipo checkbox con id checkb
$('#win1').click(function() {
    // Si esta seleccionado (si la propiedad checked es igual a true)
    if ($(this).prop('checked')) {
        // Selecciona cada input que tenga la clase .checar
        $('#win2').prop('checked', false);
    }
});
$('#win2').click(function() {
    // Si esta seleccionado (si la propiedad checked es igual a true)
    if ($(this).prop('checked')) {
        // Selecciona cada input que tenga la clase .checar
        $('#win1').prop('checked', false);
    }
});