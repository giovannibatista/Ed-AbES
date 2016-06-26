function salvarMapa(idMapa) {
	console.log(idMapa);
	$.ajax({
		url : "/Navegacao/MapaPublico/Salvar/" + idMapa,
		type : "GET",
		success : function(data) {
			if (data) {
				alert("Incluiu novo mapa");
			}
		},
		error : function() {
			alert("Erro ao Salvar mapa. Por favor, contate o administador!");
		}
	});
}