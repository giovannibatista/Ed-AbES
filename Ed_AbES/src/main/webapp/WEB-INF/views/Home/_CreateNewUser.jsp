<div class="modal-content clearfix">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<h4 class="modal-title" id="myModalLabel">Cadastro<a href="javascript: void(0);"><img class="runTimeTranslation" title="Preencha os campos abaixo e clique no botão cadastrar para criar a sua conta." style="padding-left: 8px; padding-bottom: 3px;" src="/resources/img/icone_som.png"></img></a></h4>
	</div>
	<form id="signupform" role="form" action="Cadastrar" method="POST">
		<div class="modal-body" style="margin-top: 20px;">
			<div class="row form-group">
				<div class="col-md-3">
					<label for="nome" class="control-label">* Nome:</label>
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" name="nome" id="nome" placeholder="Ex: João" maxlength="20" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label for="sobrenome" class="control-label">* Sobrenome:</label>
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" name="sobrenome" id="sobrenome" placeholder="Ex: Silva" maxlength="20" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label for="email" class="control-label">* E-mail:</label>
				</div>
				<div class="col-md-9">
					<input type="email" class="form-control" name="email" id="email" placeholder="Ex: joao@silva.br" maxlength="80" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label for="anoDeNasc" class="control-label">Ano de nascimento:</label>
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" name="anoNascimento" value="" id="anoNascimento" placeholder="Ex: 1990" maxlength="4" pattern="[0-9]+$" title="Digite apenas números" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label class="control-label">Gênero:</label>
				</div>
				<div class="col-md-9">
					<div class="btn-group" data-toggle="buttons">
						<label class="btn btn-primary active">
							<input type="radio" name="genero" autocomplete="off" value="Masculino" checked> Masculino
						</label>
						<label class="btn btn-primary">
							<input type="radio" name="genero" autocomplete="off" value="Feminino"> Feminino
						</label>
					</div>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label for="cidade" class="control-label">Cidade:</label>
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" value="" id="cidade" name="cidade" placeholder="Ex: São Paulo" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label for="pais" class="control-label">País:</label>
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="pais" value="" name="pais" placeholder="Ex: Brasil" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label for="senha" class="control-label">* Senha:</label>
				</div>
				<div class="col-md-9">
					<input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" pattern=".{8,16}" title="A senha precisa conter no minimo 8 caracteres e no máximo 16" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-3">
					<label for="conf_senha" class="control-label">* Confirmar senha:</label>
				</div>
				<div class="col-md-9">
					<input type="password" class="form-control" id="conf_senha" name="conf_senha" placeholder="Confirmar senha" pattern=".{8,16}" title="A senha deve ser a mesma informada anteriormente" required oninput="validaSenha(this)" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<div class="row text-right">
				<div class="col-md-12">
					<button id="btn-signup" type="submit" class="btn btn-success"><img src="/resources/img/icon_check.png" /> &nbsp Cadastrar</button>
					<button id="btn-signup-cancel" type="button" class="btn btn-danger"><img src="/resources/img/icon_cancel.png" /> &nbsp Cancelar</button> 
				</div>
			</div>
		</div>		
	</form>
</div>