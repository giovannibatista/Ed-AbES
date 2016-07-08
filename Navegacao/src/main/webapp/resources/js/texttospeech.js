function playTextToSpeech(textToSpeech) {
	var audio = $('audio');
	textToSpeech = encodeURIComponent(textToSpeech);
	var url = "/API/getTraducao?text=" + textToSpeech;
	audio.attr('src', url);
	audio.get(0).play();
}

function pauseTextToSpeech() {
	var audio = $('audio');
	audio.get(0).pause();
}

function resumeTextToSpeech() {
	var audio = $('audio');
	audio.get(0).play();
}
