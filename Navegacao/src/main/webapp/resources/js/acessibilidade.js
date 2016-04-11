$( document ).ready(function() {
	var altoContraste =  localStorage.getItem("altoContraste");
	if(altoContraste === "true"){
		setActiveStyleSheet("preto_branco", false);
		ocultarElemento('coresOriginais', 'altoContraste');
	}else{
		setActiveStyleSheet("padrao", false);
		ocultarElemento('altoContraste','coresOriginais');
	}
});

/*
 * Função importada do site http://www.acessibilidadelegal.com 	
 * */
function setActiveStyleSheet(title, salvarEstado) {
  var i, a, main;
  for(i=0; (a = document.getElementsByTagName("link")[i]); i++) {
    if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title")) {
      a.disabled = true;
      if(a.getAttribute("title") == title){
    	  a.disabled = false;
      }
    }
  }
  if(salvarEstado){
	  salvarEstadoContraste(title);
  }
}

function salvarEstadoContraste(title){
	if(title == "preto_branco"){
		localStorage.setItem("altoContraste", true);
	}else{
		localStorage.setItem("altoContraste", false);
	}
	
}

function ocultarElemento(retirar, ocultar){
	$("#"+retirar).removeClass("oculto");
	$("#"+ocultar).addClass("oculto");
}


function alteraTamanhoFonte(multiplier) {
	  if (document.body.style.fontSize == "") {
	    document.body.style.fontSize = "1.5em";
	  }
	  document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
	}