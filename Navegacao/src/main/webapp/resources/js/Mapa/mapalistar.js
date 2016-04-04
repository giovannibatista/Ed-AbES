/**
 * 
 */

function salvarMapa(index){
//alert("Mapa Salvo " + index);
	$.ajax({
		url : "/Mapa/Testar/",
		dataType : "json",
		type : "GET",
		success : function(data) {
			alert("Retorno: " + data);
		},
		error : function() {
			alert("Ocorreu um erro!");
		}
	});
}