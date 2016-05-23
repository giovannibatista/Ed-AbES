/**
 * 
 */

Mousetrap.bind('alt+e', function(e) {
	console.log('alt+E foi pressionado. Navegacao encerrada');
});

Mousetrap.bind('alt+s', function(e) {
	console.log('alt+S foi pressionado. Navegacao parada/retomada');
});

Mousetrap.bind('alt+p', function(e) {
	console.log('alt+P foi pressionado. Audio parado/retomado');
});

Mousetrap.bind('alt+l', function(e) {
	console.log('alt+l foi pressionado. Reproduzir log de navegacao');
});

Mousetrap.bind('alt+c', function(e) {
	console.log('alt+c foi pressionado.');
	navigation.getLastBumpedObject();
});

Mousetrap.bind('alt+i', function(e) {
	console.log('alt+I foi pressionado.');
	navigation.getCurrentLocation();
});

Mousetrap.bind('alt+o', function(e) {
	console.log('alt+O foi pressionado.');
	navigation.getGoalMap();
});

Mousetrap.bind('alt+r', function(e) {
	console.log('alt+R foi pressionado. Os seguintes objetos estao ao meu redor...');
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
