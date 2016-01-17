<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<h4 class="modal-title" id="myModalLabel">Esqueceu sua senha?<a href="javascript: void(0);"><img class="runTimeTranslation" title="Insira o seu email no campo abaixo para receber uma nova senha" style="padding-left: 8px; padding-bottom: 3px;" src="/resources/img/icone_som.png"></img></a></h4>
	</div>
	<form id="signupform" role="form" action="EsqueceuSuaSenha" method="POST">
		<div class="modal-body clearfix">
			<div class="form-group">
				<div class="col-md-3">
					<label for="email" class="control-label">E-mail:</label>
				</div>
				<div class="col-md-9">
					<input id="esqueci_email" type="email" required class="form-control" name="email" placeholder="Endereço de e-mail" onblur="ativaAtalhos()" onfocus="desativaAtalhos()">
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button id="btn-forgot" type="submit" class="btn btn-success"><img src="/resources/img/icon_check.png" /> &nbsp Enviar</button>
			<button type="button" class="btn btn-danger" onclick="hideModal('modalEsqueceuSenha');" data-dismiss="modal"><img src="/resources/img/icon_cancel.png" /> &nbsp Cancelar</button>
		</div>
	</form>
</div>