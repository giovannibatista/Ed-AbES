/**
 * 
 */

Mousetrap.bind('alt+s', function(e) {
	var idUsuario = $("#id").val();
	salvarUsuario(idUsuario);
});

Mousetrap.bind('alt+s', function(e) {
	cancelarAlteracoesUsuario();
});