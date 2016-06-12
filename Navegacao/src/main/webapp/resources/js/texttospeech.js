var i = 0;
function playTextToSpeech(textToSpeech) {
	var audio = $('audio');
	console.log(i + " - " +textToSpeech);
	textToSpeech = encodeURIComponent(textToSpeech);
	i++;
	if(textToSpeech.length > 2048){
		console.log("Texto com mais de 2048 caracteres: Tamanho=" + textToSpeech.length);
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
