/**
 * 
 */
Mousetrap.bind('alt+i', function(e) {
	var idMapa = document.getElementById("idMapa").value;
	iniciarNavegacao(idMapa);
});

Mousetrap.bind('alt+v', function(e) {
	voltarListaMapas();
});