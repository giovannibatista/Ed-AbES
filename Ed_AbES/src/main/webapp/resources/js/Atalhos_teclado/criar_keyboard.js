/* [Key code] = [Key Pressed]
 * 8 = Backspace
 * 9 = Tab
 * 13 = Enter
 * 16 = Shift
 * 17 = Ctrl 
 * 18 = Alt 
 * 19 = pause/brak 
 * 20 = Caps lock 
 * 27 = escape
 * 33 = Page up
 * 34 = Page down 
 * 35 = End 
 * 36 = Home
 * 37 = Left arrow 
 * 38 = Up arrow 
 * 39 = Right arrow 
 * 40 = Down arrow 
 * 45 = Insert
 * 46 = Delete
 * 48 = 0 
 * 49 = 1
 * 50 = 2
 * 51 = 3
 * 52 = 4
 * 53 = 5
 * 54 = 6
 * 55 = 7
 * 56 = 8
 * 57 = 9
 * 65 = a
 * 66 = b
 * 67 = c
 * 68 = d
 * 69 = e
 * 70 = f
 * 71 = g
 * 72 = h
 * 73 = i
 * 74 = j
 * 75 = k
 * 76 = l
 * 77 = m
 * 78 = n
 * 79 = o
 * 80 = p
 * 81 = q
 * 82 = r
 * 83 = s
 * 84 = t
 * 85 = u
 * 86 = v
 * 87 = w
 * 88 = x
 * 89 = y
 * 90 = z
 * 91 = Left window key
 * 92 = Right window key
 * 93 = Select key
 * 96 = Numpad 0
 * 97 = Numpad 1
 * 98 = Numpad 2
 * 99 = Numpad 3
 * 100 = Numpad 4
 * 101 = Numpad 5
 * 102 = Numpad 6
 * 103 = Numpad 7
 * 104 = Numpad 8
 * 105 = Numpad 9
 * 106 = Multiply (*)
 * 107 = Add (+)
 * 109 = Subtract (-)
 * 110 = Decimal Point (.)
 * 111 = Divide (/) 
 * 112 = F1
 * 113 = F2
 * 114 = F3
 * 115 = F4
 * 116 = F5
 * 117 = F6
 * 118 = F7
 * 119 = F8
 * 120 = F9
 * 121 = F10
 * 122 = F11
 * 123 = F12
 * 144 = Num lock
 * 145 = Scroll lock
 * 186 = Semi-colon
 * 187 = Equal sign
 * 188 = Comma (,)
 * 189 = Dash
 * 190 = Period
 * 191 - Forward slash
 * 192 = Grave accent
 * 219 = Open bracket
 * 220 = Back slash
 * 221 = Close bracket
 * 222 = Single quote
 */

var controleAtalhos = true;

function desativaAtalhos() {
	controleAtalhos = false;
}

function ativaAtalhos() {
	controleAtalhos = true;
}

$(document).ready(function() {
	$("#nomeMapa").focus();

	$("body").keydown(function(event) {
		var tecla = event.keyCode;
		var $formularioMapa = $("#formularioCriarMapa");
		var $formularioCancelButton = $("#formularioCancelButton");
		// alert ("Tecla: " + tecla + " Controle: " + controleAtalhos);
		if (controleAtalhos) {

			if (tecla == 49) {
				$("#nomeMapa").focus();
				return (false);
			} else if (tecla == 50) {
				$("#descricaoMapa").focus();
				return (false);
			} else if (tecla == 51) {
				$("#objetivoMapa").focus();
				return (false);
			} else if (tecla == 52) {
				$("#unidadeDeMedida").focus();
				return (false);
			} else if (tecla == 53) {
				$("#tipoMapa").focus();
				return (false);
			} else if (tecla == 54) {
				$formularioMapa.submit();
			} else if (tecla == 55) {
				$formularioCancelButton.click();
			}
		}
	});

});

function verificaCadastro() {
	var verificacao = true;

	var nome = $("#nome").val();
	var sobrenome = $("#sobrenome").val();
	var email = $("#email").val();
	var senha = $("#senha").val();
	var confSenha = $("#conf_senha").val();

	if (nome == "" || sobrenome == "" || email == "" || senha == ""
			|| confSenha == "") {
		verificacao = false;
	}

	return verificacao;
}
