/**
 * 
 */

Mousetrap.bind('alt+s', function(e) {
	var idUsuario = $("#id").val();
	console.log('alt + s is pressed. Id: ' + idUsuario);
	salvarUsuario(idUsuario);
});

Mousetrap.bind('alt+s', function(e) {
	console.log('alt + s is pressed');
	cancelarAlteracoesUsuario();
});