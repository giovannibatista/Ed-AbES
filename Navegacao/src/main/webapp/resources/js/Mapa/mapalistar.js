function salvarMapa(idMapa) {
	console.log(idMapa);
	$.ajax({
		url : "/Navegacao/MapaPublico/Salvar/" + idMapa,
		type : "GET",
		success : function(data) {
			if (data) {
				$('#msg').html('');
				$('#msg').append('<p>Mapa salvo com sucesso!</p>');
			}
		},
		error : function() {
			$('#msg').html('');
			$('#msg')
			.append(
			'<p>Erro ao Salvar mapa. Por favor, contate o administador!</p>');

		}
	});
}