/**
 * 
 */

Mousetrap.bind('alt+i', function(e) {
	var idMapa = document.getElementById("idMapa").value;
	console.log('alt + I is pressed. Id: ' + idMapa);
	iniciarNavegacao(idMapa);
});

Mousetrap.bind('alt+v', function(e) {
	console.log('alt + v is pressed');
	voltarListaMapas();
});