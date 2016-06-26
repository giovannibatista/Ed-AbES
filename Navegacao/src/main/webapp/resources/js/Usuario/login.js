function novoUsuario() {
	var email = document.getElementById("novoEmail").value;

	$.ajax({
		url : "/Usuario/ConsultarEmail",
		type : "POST",
		contentType : "text/plain; charset=utf-8",
		mimeType : 'text/plain',
		data : email,
		cache : false,
		processData : false,
		success : function(text) {
			if (text) {
				$('#msg').html('');
				$('#msg').append('<p>' + text + '</p>');
				$('#msg').focus();
			} else {
				document.location = "/Usuario/Editar";
			}

			console.log("Consulta com sucesso=" + text);
		},
		error : function() {
			alert("Ocorreu um erro ao consultar email!");
		}
	});
}

function logout(){
	document.location = "/Usuario/Logout";
}