$(function() {
	var $formularioMapa = $("#formularioCriarMapa");
	var $formularioCancelButton = $("#formularioCancelButton");
	
	$formularioCancelButton.unbind("click").bind("click", function() {
		if (!confirm("Deseja cancelar a criação do mapa?")) {
			return (false);
		} else {
			document.location = "/Mapa/Criar/";
		}
	});
	
	$formularioMapa.unbind("submit").bind("submit", function() {		
		$.ajax({
			url : "/Mapa/Criar/",
			dataType : "json",
			type : "POST",
			data : $formularioMapa.serializeArray(),
			success : function(json) {
				var id = json['idMapa'];
				
				if (id > 0) {
					alert("O mapa foi salvo com sucesso.");
					document.location = "/Mapa/Desenho/" + json.idMapa;
				} else {
					alert("O nome do mapa já existe.");
				}
			},
			error : function() {
				//console.log(json.properties);
				alert("Ocorreu um erro ao salvar o mapa.");
			}
		});
		
		return (false);
	});
});