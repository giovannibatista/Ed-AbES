function salvarUsuario(idUsuario){
	if(idUsuario !== null && idUsuario !== undefined){
		console.log("Edição Usuário");

	}
}
$(document).ready(function(e) {

	$('#usuarioForm').submit(function() {
		var error = false;
		
		error = validateForm();
		
		if(error){
			return false;
		}
	});
	
	function validateForm(){
		var error = false;
		$('#errors').html('');

		if ($('#nome').val() === '') {
			error = true;
			$('#errors').append('<p>Por favor, preencha o campo Nome.</p>');
		}
		if ($('#sobrenome').val() === '') {
			error = true;
			$('#errors').append('<p>Por favor, preencha o campo Sobrenome.</p>');
		} 
		if ($('#email').val() === '') {
			error = true;
			$('#errors').append('<p>Por favor, preencha o campo Email.</p>');
		} 
		if ($('#senha').val() === '') {
			error = true;
			$('#errors').append('<p>Por favor, preencha o campo Senha.</p>');
		}
		if ($('#confirmaSenha').val() === '') {
			error = true;
			$('#errors').append('<p>Por favor, preencha o campo Confirma Senha.</p>');
		}
		
		return error;
		
	}

});

function validaSenha (input){ 
	if (input.value != document.getElementById('senha').value) {
		input.setCustomValidity('Repita a senha corretamente');
	} else {
		input.setCustomValidity('');
	}
} 	


function cancelarAlteracoesUsuario(){
	$('#msg').html('');
	$('#msg').append('<p>Alterações descartadas</p>');
	document.location = "/Usuario/Login";
}