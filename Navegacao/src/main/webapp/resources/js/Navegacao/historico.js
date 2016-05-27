var NavigationHistory = function() {
	var self = this;

	self.history = {
		id : 0,
		log : "",
		dataNavegacao : "",
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
	
	self.saveNavigationHistory = function(){
		console.log(self.history);
	}

}
