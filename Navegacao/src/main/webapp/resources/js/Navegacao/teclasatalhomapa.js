/**
 * 
 */

Mousetrap.bind('f9', function(e) {
	navigation.playKeyboardShortcuts();
});

Mousetrap.bind('s', function(e) {
	navigation.yes();
});

Mousetrap.bind('n', function(e) {
	navigation.no();
});

Mousetrap.bind('alt+q', function(e) {
	navigation.askToCloseNavigation();
});

Mousetrap.bind('alt+l', function(e) {
	navigation.playLog();
});

Mousetrap.bind('alt+p', function(e) {
	navigation.playPauseTextToSpeech();
});

Mousetrap.bind('alt+m', function(e) {
	navigation.getInfoMap();
});

Mousetrap.bind('alt+s', function(e) {
	navigation.resumeStopNavigation();
});

Mousetrap.bind('alt+t', function(e) {
	navigation.getTimerNavigation();
});

Mousetrap.bind('alt+c', function(e) {
	navigation.getLastBumpedObject();
});

Mousetrap.bind('alt+o', function(e) {
	navigation.getCurrentLocation();
});

Mousetrap.bind('alt+r', function(e) {
	navigation.getAroundObjects();
});

Mousetrap.bind('up', function(e) {
	navigation.walk();
});

Mousetrap.bind('down', function(e) {
	navigation.down();
});

Mousetrap.bind('left', function(e) {
	navigation.rotateLeft();
});

Mousetrap.bind('right', function(e) {
	navigation.rotateRight();
});
