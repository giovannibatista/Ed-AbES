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