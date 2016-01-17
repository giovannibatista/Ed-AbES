$(function() {
	var $formularioEditarPerfil = $("#formularioEditarPerfil");
	var $formularioCancelButton = $("#formularioEditarPefilCancela");
	
	
	$formularioCancelButton.unbind("click").bind("click", function() {
		if (confirm("Deseja cancelar a alteração do perfil?")) {
			document.location = "/Mapa/Criar/";
		}
		else {
			return (false);
		}
	});
	
	
	$formularioEditarPerfil.unbind("submit").bind("submit", function() {	
		$.ajax({
			url : "/Salvar/Perfil/",
			dataType : "json",
			type : "POST",
			data : $formularioEditarPerfil.serializeArray(),
			success : function(json) {
				alert("Dados alterados com sucesso.");
				document.location = "/Mapa/Criar/";
			},
			error : function() {
				//console.log(json);
				alert("Ocorreu um erro ao salvar os novos dados.");
			}
		});
		
		return (false);
	});
	
});

function validaSenha (input){ 
    if (input.value != document.getElementById('senha').value) {
    input.setCustomValidity('Repita a senha corretamente');
  } else {
    input.setCustomValidity('');
  }
} 	