function playTextToSpeech(textToSpeech) {
	var audio = $('audio');
	textToSpeech = encodeURIComponent(textToSpeech);
	console.log(textToSpeech.length);
	console.log(textToSpeech);
	if(textToSpeech.length > 2048){
		debugger;
		console.log("MAIORRRRR");
	}
	var url = "/API/getTraducao?text=" + textToSpeech;
	console.log("->" + url);
	//audio.get(0).playbackRate = 2.0;
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
