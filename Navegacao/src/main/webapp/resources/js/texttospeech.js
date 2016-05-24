function playTextToSpeech(textToSpeech) {
	textToSpeech = encodeURIComponent(textToSpeech);
	var url = "/API/getTraducao?text=" + textToSpeech;
	console.log("->" + url);
	$('audio').attr('src', url).get(0).play();
}

function pauseTextToSpeech() {
	$('audio').get(0).pause();
}

function resumeTextToSpeech() {
	$('audio').get(0).play();
}
