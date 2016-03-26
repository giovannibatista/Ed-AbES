/**
 * 
 */

keyboardJS.bind('alt + e', function(e) {
	alert('alt + E foi pressionado. Navegação encerrada');
});

keyboardJS.bind('alt + s', function(e) {
	alert('alt + S foi pressionado. Navegação parada/retomada');});

keyboardJS.bind('alt + p', function(e) {
	alert('alt + P foi pressionado. Audio parado/retomado');
});

keyboardJS.bind('alt + t', function(e) {
	alert('alt + T foi pressionado. Porta Aberta');
});

keyboardJS.bind('alt + l', function(e) {
	alert('alt + l foi pressionado. Reproduzir lod de navegação');
});

keyboardJS.bind('alt + i', function(e) {
	alert('alt + I foi pressionado. Jogador está em tal local do mapa, na direção tal!');
});

keyboardJS.bind('alt + o', function(e) {
	alert('alt + O foi pressionado. O objetivo do mapa é tal...');
});

keyboardJS.bind('alt + r', function(e) {
	alert('alt + R foi pressionado. Os seguintes objetos estão ao meu redor...');
});

keyboardJS.bind('space', function(e) {
	alert('espaco foi pressionado. Jogador avançou um passo a frente');
});

keyboardJS.bind('up', function(e) {
	alert('up foi pressionado. Jogador mudou a direção para o norte');
});

keyboardJS.bind('down', function(e) {
	alert('down foi pressionado. Jogador mudou a direção para o sul');
});

keyboardJS.bind('left', function(e) {
	alert('left foi pressionado.  Jogador mudou a direção para o Oeste');
});

keyboardJS.bind('right', function(e) {
	alert('right foi pressionado.  Jogador mudou a direção para Leste');
});
