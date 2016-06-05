function playAudio(){
	console.log("play audio...");
	
	var sound = new Howl({
		  urls: ['/resources/audio/footsteps-cut.mp3'],
		  autoplay: true,
		  onend: function() {
			  console.log('Finished!');
		  }
		});
}