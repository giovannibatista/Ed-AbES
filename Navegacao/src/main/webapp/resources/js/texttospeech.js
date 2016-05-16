function playTextToSpeech(text) {
	text = encodeURIComponent(text);
	var url = "/API/getTraducao?text=" + text;
	console.log("->" + url);
	$('audio').attr('src', url).get(0).play();
}

function pauseTextToSpeech(text) {
	$('audio').get(0).pause();
}

function resumeTextToSpeech(text) {
	$('audio').get(0).play();
}
