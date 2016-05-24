/**
 * 
 */

Mousetrap.bind('alt+e', function(e) {
	console.log('alt+E foi pressionado. Navegacao encerrada');
});

Mousetrap.bind('alt+l', function(e) {
	console.log('alt+l foi pressionado. Reproduzir log de navegacao');
});

Mousetrap.bind('alt+p', function(e) {
	console.log('alt+P foi pressionado. Audio parado/retomado');
	navigation.playPauseTextToSpeech();
});

Mousetrap.bind('alt+m', function(e) {
	console.log('alt+m foi pressionado. Informações do mapa');
	navigation.getInfoMap();
});

Mousetrap.bind('alt+s', function(e) {
	console.log('alt+S foi pressionado. Navegacao parada/retomada');
	navigation.resumeStopNavigation();
});

Mousetrap.bind('alt+t', function(e) {
	console.log('alt+t foi pressionado. Tempo de navegacao');
	navigation.getTimerNavigation();
});

Mousetrap.bind('alt+c', function(e) {
	console.log('alt+c foi pressionado.');
	navigation.getLastBumpedObject();
});

Mousetrap.bind('alt+o', function(e) {
	console.log('alt+o foi pressionado.');
	navigation.getCurrentLocation();
});

Mousetrap
		.bind(
				'alt+r',
				function(e) {
					console
							.log('alt+R foi pressionado. Os seguintes objetos estao ao meu redor...');
					navigation.getAroundObjects();
				});

Mousetrap.bind('up', function(e) {
	console.log("up");
	navigation.walk();
});

Mousetrap.bind('down', function(e) {
	console.log("down");
	navigation.down();
});

Mousetrap.bind('left', function(e) {
	console.log("left");
	navigation.rotateLeft();
});

Mousetrap.bind('right', function(e) {
	console.log("right");
	navigation.rotateRight();
});
