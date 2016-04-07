$(function() {
	var $formularioUploadAudio = $("#formularioUploadAudio");
	var $formularioCancelButton = $("#formularioEditarPefilCancela");
	
	
	$formularioCancelButton.unbind("click").bind("click", function() {
		if (confirm("Deseja cancelar a alteração do perfil?")) {
			document.location = "/Mapa/Criar/";
		}
		else {
			return (false);
		}
	});
	
	
	$formularioUploadAudio.unbind("submit").bind("submit", function() {
		var data = new FormData();
		var arquivo = document.getElementById("arquivo");
		var descricaoAudio = $("#descricaoAudio").val();

		data.append( 'arquivo', arquivo.files[0] );
		data.append( 'descricaoAudio' , descricaoAudio );
					
		
		$.ajax({
			url : "/Audio/Importar/",
			type : "POST",
			data : data,
			cache: false,
			contentType: false,
			processData: false,
			success : function(data) {
				if(data){
					alert("Áudio importado com sucesso!");
				}else{
					alert("Ocorreu um erro ao importar o áudio!");
				}
				document.getElementById("formularioUploadAudio").reset();
				document.location = "/Audio/Importar";
			},
			error : function(data) {
				//console.log(json);
				alert("Ocorreu um erro ao importar o áudio.");
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