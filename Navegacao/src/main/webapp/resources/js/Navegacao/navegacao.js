function abrirResumo(idMapa){
	alert("Mapa " + idMapa);
	document.location = "/Navegacao/Resumo/"+idMapa;
}

function iniciarNavegacao(idMapa){
	document.location = "/Navegacao/Mapa/" + idMapa;
}

function voltarMapasSalvos(){
	document.location = "/Navegacao/MapasSalvos/";
}

function encerrarNavegacao(){
	alert('Navegação encerrada');
}

function pararNavegacao(){
	alert('parar Navegação');
}

function retomarNavegacao(){
	alert('retomar Navegação');
}

function reproduzirLogNavegacao(){
	alert('reproduzir log navegação');
}

function reproduzirTempoNavegacao(){
	alert('reproduzir tempo de navegação');
}

function pararAudioNavegacao(){
	alert('parar audio navegação');
}

function retomarAudioNavegacao(){
	alert('retomar audio navegaçaõ');
}

