/**
 * 
 */

keyboardJS.bind('alt + i', function(e) {
	var idMapa = $("#idMapa").val();
	alert('alt + I is pressed. Id: ' + idMapa);
	iniciarNavegacao(idMapa);
});

keyboardJS.bind('alt + r', function(e) {
	alert('alt + V is pressed');
	voltarListaMapas();
});