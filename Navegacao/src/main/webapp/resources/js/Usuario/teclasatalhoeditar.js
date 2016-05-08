/**
 * 
 */

Mousetrap.bind('alt + s', function(e) {
	var idUsuario = $("#id").val();
	alert('alt + s is pressed. Id: ' + idUsuario);
	salvarUsuario(idUsuario);
});

Mousetrap.bind('alt + s', function(e) {
	alert('alt + s is pressed');
	cancelarAlteracoesUsuario();
});