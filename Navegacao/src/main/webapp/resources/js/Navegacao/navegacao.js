var Navegacao = function(mapaNavegacao) {
	var self = this;
	var jogador = mapaNavegacao.objetoInicial;
	
	var direcaoEnum = {
			  UP: 1,
			  DOWN: 2,
			  LEFT: 3,
			  RIGHT: 4
			};

	self.direcao = direcaoEnum.UP;
	
	var offset = {
		top : jogador.data("coord-y") * mapaNavegacao.scale,
		left : jogador.data("coord-x") * mapaNavegacao.scale
	};

	self.walk = function() {
		var rotate = 0;
		switch(self.direcao) {
		    case direcaoEnum.UP:
		    	offset = {
					top : offset.top - 32,
					left : offset.left
				};    	
		        break;
		    case direcaoEnum.DOWN:
		    	offset = {
					top : offset.top + 32,
					left : offset.left
				};
		        break;
		    case direcaoEnum.LEFT:
				offset = {
					top : offset.top,
					left : offset.left - 32
				};

		    	break;
		    case direcaoEnum.RIGHT:
				offset = {
					top : offset.top,
					left : offset.left + 32
				};
		        break;
		    default:
		    	offset = {
					top : offset.top - 32,
					left : offset.left
				};    	

		}
		
		mapaNavegacao.moveObj(jogador, offset, rotate);
	}

	self.up = function() {
		self.direcao = direcaoEnum.UP;
		
	}

	self.down = function() {
		self.direcao = direcaoEnum.DOWN;
		
	}

	self.left = function() {
		self.direcao = direcaoEnum.LEFT;
	}

	self.right = function() {
		self.direcao = direcaoEnum.RIGHT;
	}

};

function encerrarNavegacao() {
	console.log('Navegacao encerrada');
}

function pararNavegacao() {
	console.log('parar Navegacao');
}

function retomarNavegacao() {
	console.log('retomar Navegacao');
}

function reproduzirLogNavegacao() {
	console.log('reproduzir log navegacao');
}

function reproduzirTempoNavegacao() {
	console.log('reproduzir tempo de navegacao');
}

function pararAudioNavegacao() {
	console.log('parar audio navegacao');
}

function retomarAudioNavegacao() {
	console.log('retomar audio navegacao');
}