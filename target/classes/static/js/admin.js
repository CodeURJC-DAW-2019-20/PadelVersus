
$(document).on('change', '#servicio', function(event) {
    $('#servicioSelecionado').val($("#servicio option:selected").text());
});
$(document).on('change', '#torneoSeleccionado', function(event) {
    $('#servicioSelec').val($("#torneoSeleccionado option:selected").text());
});

Mustache.render('{{#tournament-teams-}},$("#torneoSeleccionado option:selected")',routeObj);