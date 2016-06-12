$(function() {
	var $formularioMapa = $("#formularioEditarMapa");
	var $formularioCancelButton = $("#formularioCancelButton");
	var $idMapa = $("#idMapa");
	
	$formularioCancelButton.unbind("click").bind("click", function() {
		if (confirm("Deseja cancelar a edição do mapa?")) {
			document.location = "/Mapa/Listar/";
		}
		else {
			return (false);
		}
	});
	
	$formularioMapa.unbind("submit").bind("submit", function() {	
		var idMapa = $idMapa.val();
		$.ajax({
			url : "/Mapa/Editar/" + idMapa,
			dataType : "json",
			type : "POST",
			data : $formularioMapa.serializeArray(),
			success : function(json) {
				alert("Mapa editado com sucesso.");
				document.location = "/Mapa/Desenho/" + json.idMapa;
			},
			error : function() {
				//console.log(json);
				alert("Ocorreu um erro ao salvar o mapa.");
			}
		});
		
		return (false);
	});
	
	
});