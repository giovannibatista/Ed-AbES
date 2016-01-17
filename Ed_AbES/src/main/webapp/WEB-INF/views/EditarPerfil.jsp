<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
	<head>
		<title>Ed-AbES - Edição de perfil</title>

		<jsp:include page="Head.jsp" />

		<script type="text/javascript" src="/resources/js/EditarPerfil/Form.js" charset="UTF-8"></script>
		
	</head>
<body>

	<div class="content">
			<div id="mainMenu">
				<jsp:include page="Menu.jsp" />
			</div>
			<div id="mainBody">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-info">
							<div class="panel-heading">
								<div class="panel-title">Editar perfil</div>
							</div>
							<div class="panel-body">
								<form id="formularioEditarPerfil" class="form-horizontal" role="form" method="POST">
									<input type="hidden" name="idUsuario" value="" id="idUsuario" />
									<div class="form-group">
										<label class="col-md-8"><font color="red">Edite as suas informações.</font></label>
									</div>
									<div class="form-group">
										<label for="nomeMapa" class="col-md-4 control-label">* Nome:</label>
										<div class="col-md-8">
											<input id="nome" type="text" class="form-control" name="nome"
												value="${usuario.nome}" maxlength="20" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">* Sobrenome:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="sobrenome"
												name="sobrenome" value="${usuario.sobrenome}" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">* E-mail:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="email"
												name="email" value="${usuario.email}" required readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Ano de nascimento:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="anoNascimento"
												name="anoNascimento" value="${usuario.anoNascimento}" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Gênero:</label>
										<div class="col-md-8">
											<div class="btn-group" data-toggle="buttons">
												<c:choose>
													<c:when test="${usuario.genero == 'Masculino'}">
													  	<label class="btn btn-primary active">
															<input type="radio" name="genero" autocomplete="off" value="Masculino" checked> Masculino
														</label>
														<label class="btn btn-primary">
															<input type="radio" name="genero" autocomplete="off" value="Feminino"> Feminino
														</label>
													</c:when>
													<c:otherwise>
												      	<label class="btn btn-primary">
															<input type="radio" name="genero" autocomplete="off" value="Masculino"> Masculino
														</label>
														<label class="btn btn-primary active">
															<input type="radio" name="genero" autocomplete="off" value="Feminino" checked> Feminino
														</label>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Cidade:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="cidade"
												name="cidade" value="${usuario.cidade}" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">País:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="pais"
												name="pais" value="${usuario.pais}"onblur="ativaAtalhos()" onfocus="desativaAtalhos()" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">* Senha:</label>
										<div class="col-md-8">
											<input type="password" class="form-control" id="senha"
												name="senha" value="${usuario.senha}" pattern=".{8,16}" title="A senha precisa conter no minimo 8 caracteres e no máximo 16" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">* Confirmar senha:</label>
										<div class="col-md-8">
											<input type="password" class="form-control" id="conf_senha"
												name="conf_senha" value="${usuario.senha}" required pattern=".{8,16}" title="A senha deve ser a mesma informada anteriormente" required oninput="validaSenha(this)" onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<!-- Button -->
										<div class="col-md-offset-3 col-md-9 text-right">
											<button type="submit" class="btn btn-success">
												<img src="/resources/img/icon_check.png" /> &nbsp; Salvar
											</button>
		
											<button id="formularioEditarPefilCancela" type="button" class="btn btn-danger">
												<img src="/resources/img/icon_cancel.png" /> &nbsp; Cancelar
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	<script type="text/javascript" src="/resources/js/Atalhos_teclado/editarPerfil_keyboard.js""></script>

</body>
</html>