var NavigationHistory = function() {
	var self = this;

	self.history = {
			id : 0,
			log : "",
			dataNavegacao : new Date(),
			usuario : 0,
			tempoNavegacao : "",
			mapa : {
				id : 0
			}
	};

	self.logInit = function(text) {
		self.history.log = text;
	}

	self.logWalkUp = function(direction) {
		self.history.log += " Você andou um passo ao " + direction + "."
	}

	self.logWalkDown = function(direction) {
		self.history.log += " Você andou um passo para trás."
	}

	self.logChangeDirection = function(direction) {
		self.history.log += " Você se virou para o " + direction + "."
	}

	self.logCollision = function(objectMap) {
		self.history.log += " Você colidiu com o objeto "
			+ objectMap.objeto.nome + " na posição coluna "
			+ (objectMap.coordenadaX + 1) + " e linha "
			+ (objectMap.coordenadaY + 1) + ".";
	}

	self.logFinishedNavigation = function(objectMap, timer) {
		self.history.log += " Você finalizou a navegação em " + timer + ". A posição final do seu jogador foi coluna "
		+ (objectMap.data("coord-x") + 1) + " e linha "
		+ (objectMap.data("coord-y") + 1) + ".";
	}

	self.logFinishedChallengeNavigation = function(objectMap, timer) {
		self.history.log += " Você finalizou a navegação em " + timer + ". O ponto final estava na posição coluna "
		+ (objectMap.data("coord-x") + 1) + " e linha "
		+ (objectMap.data("coord-y") + 1) + ".";
	}

	self.logActions = function(action, text){
		self.history.log += " Você pressionou a tecla de atalho " + action
				+ ", correspondente a ação: " + text + "."; 
	}

	self.saveNavigationHistory = function(){
		console.log(JSON.stringify(self.history));
		$.ajax({
			url : "/Navegacao/Historico/Incluir",
			type : "POST",
			contentType: "application/json; charset=utf-8",
			mimeType: 'application/json',
			data : JSON.stringify(self.history),
			cache: false,
			async: false,
			processData:false,

			success : function(json) {
				console.log("Histórico salvo com sucesso!");
				playTextToSpeech("Histórico de navegação salvo com sucesso. Treinamento encerrado. Para inicar uma navegação, acesse o Menu \"Iniciar Navegação\" ou ALT 1. Ou para retornar o treinamento, acesse o Menu \"Módulo de treinamento\" ou ALT 3 ");
			},
			error : function() {
				alert("Ocorreu um erro ao salvar o histórico de navegação.");
			}
		});


	}

}
