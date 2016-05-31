/**
 * 
 */

Mousetrap.bind('s', function(e) {
	console.log('s');
	navigation.yes();
});

Mousetrap.bind('n', function(e) {
	console.log('n');
	navigation.no();
});

Mousetrap.bind('alt+e', function(e) {
	console.log('alt+E foi pressionado.');
	navigation.askToCloseNavigation();
});

Mousetrap.bind('alt+l', function(e) {
	console.log('alt+l foi pressionado.');
	navigation.playLog();
});

Mousetrap.bind('alt+p', function(e) {
	console.log('alt+P foi pressionado.');
	navigation.playPauseTextToSpeech();
});

Mousetrap.bind('alt+m', function(e) {
	console.log('alt+m foi pressionado.');
	navigation.getInfoMap();
});

Mousetrap.bind('alt+s', function(e) {
	console.log('alt+S foi pressionado. ');
	navigation.resumeStopNavigation();
});

Mousetrap.bind('alt+t', function(e) {
	console.log('alt+t foi pressionado.');
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

Mousetrap.bind('alt+r',function(e) {
	console.log('alt+R foi pressionado.');
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
