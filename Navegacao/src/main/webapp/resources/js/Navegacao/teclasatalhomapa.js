/**
 * 
 */

keyboardJS.bind('alt + e', function(e) {
	console.log('alt + E foi pressionado. Navegação encerrada');
});

keyboardJS.bind('alt + s', function(e) {
	console.log('alt + S foi pressionado. Navegação parada/retomada');});

keyboardJS.bind('alt + p', function(e) {
	console.log('alt + P foi pressionado. Audio parado/retomado');
});

keyboardJS.bind('alt + t', function(e) {
	console.log('alt + T foi pressionado. Porta Aberta');
});

keyboardJS.bind('alt + l', function(e) {
	console.log('alt + l foi pressionado. Reproduzir lod de navegação');
});

keyboardJS.bind('alt + i', function(e) {
	console.log('alt + I foi pressionado. Jogador está em tal local do mapa, na direção tal!');
});

keyboardJS.bind('alt + o', function(e) {
	console.log('alt + O foi pressionado. O objetivo do mapa é tal...');
});

keyboardJS.bind('alt + r', function(e) {
	console.log('alt + R foi pressionado. Os seguintes objetos estão ao meu redor...');
});

keyboardJS.bind('alt + w', function(e) {
	console.log("walk");
	navegacao.walk();
});

keyboardJS.bind('up', function(e) {
	console.log("up");
	navegacao.up();
});

keyboardJS.bind('down', function(e) {
	console.log("down");
	navegacao.down();
});

keyboardJS.bind('left', function(e) {
	console.log("left");
	navegacao.left();
});

keyboardJS.bind('right', function(e) {
	console.log("right");
	navegacao.right();
});
