function novoUsuario(){
	var email = document.getElementById("novoEmail").value;
	
	$.ajax({
		url : "/Usuario/ConsultarEmail",
		type : "POST",
		contentType: "text/plain; charset=utf-8",
		mimeType: 'text/plain',
		data :email,
		cache: false,
		processData:false,
		success : function(text) {
			if(text){
				document.location = "/Usuario/Login";
				alert(text);
				document.getElementById("novoEmail").focus();
			}else{
				document.location = "/Usuario/Editar";
			}
			
			console.log("Consulta com sucesso=" + text);
		},
		error : function() {
			alert("Ocorreu um erro ao consultar email!");
		}
	});
}

function efetuarLogin(){
	
}