$(function() {
	var $runTimeTranslation = $(".runTimeTranslation");
	var $runTimeTranslationObject = $(".runTimeTranslationObject");
	var $body = $("body");

	$runTimeTranslation.unbind("click").bind("click", function() {
		var $obj = $(this);
		var $audioCache = null;
		var text = $obj.attr("title");
		var hashCode = quickHash(text);

		if (!$body.data("playing")) {
			// Avisa o DOM que está rodando audio
			$body.data("playing", true);
			
			// Primeiro, vamos verificar se já existe em cache essa mensagem
			$audioCache = $("#audio_" + hashCode);

			if ($audioCache.length) {
				// Existe
				$audioCache.get(0).play();
			} else {
				// Chama o Ajax e cria o Audio
				callTraducao(text, hashCode);
			}
		}

		return (false);
	});
	
	$runTimeTranslationObject.unbind("click").bind("click", function() {
		var $obj = $(this);
		var $audioCache = null;
		var text = $("#titleEditModal").val();
		var hashCode = quickHash(text);

		if (!$body.data("playing")) {
			// Avisa o DOM que está rodando audio
			$body.data("playing", true);
			
			// Primeiro, vamos verificar se já existe em cache essa mensagem
			$audioCache = $("#audio_" + hashCode);

			if ($audioCache.length) {
				// Existe
				$audioCache.get(0).play();
			} else {
				// Chama o Ajax e cria o Audio
				callTraducao(text, hashCode);
			}
		}

		return (false);
	});

	function callTraducao(text, hashCode) {
		var url = encodeURI("/API/getTraducao?text=" + text);
		$body.append("<audio id='audio_" + hashCode
				+ "' autoplay='true' src='" + url + "' />");

		$("#audio_" + hashCode).bind("ended", function() {
			$body.data("playing", false);
		});
	}
});

function quickHash(str){
    var hash = 0;
    if (str.length == 0) return hash;
    for (i = 0; i < str.length; i++) {
        char = str.charCodeAt(i);
        hash = ((hash<<5)-hash)+char;
        hash = hash & hash; // Convert to 32bit integer
    }
    return hash;
}
