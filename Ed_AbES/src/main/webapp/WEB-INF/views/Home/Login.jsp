<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
  <head>
    <title>Ed-AbES</title>
    
    <jsp:include page="../Head.jsp" />
  </head>
  <body> 
    <div class="container">    
        <div id="loginModal" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Ed-AbES</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form id="loginform" class="form-horizontal" role="form" method="POST" action="/User/Login">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><img src="/resources/img/icon_user.png"/></span>
                                        <input id="login-username" type="email" class="form-control" name="email" value="" placeholder="Email" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><img src="/resources/img/icon_lock.png"/></span>
                                        <input id="login-password" type="password" class="form-control" name="senha" placeholder="Senha" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()" />
                                    </div>
                                    
									
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">                                     
                                         <button id="btn-login" type="submit" class="btn btn-success" >Entrar</button>                       
                                    </div>
                                </div>
								<div>
									<c:if test="${param.verificacao == 'erro'}">
									    <script type="text/javascript">
										    alert("Email e/ou senha inválidos");
									    </script>
									</c:if> 
								</div>
								<div>
									<c:if test="${cadastro == true}">
										<c:if test="${verificacaoCadastro == true}">
											<script type="text/javascript">
										    	alert("Usuário cadastrado com sucesso");
									    	</script>
										</c:if>
										<c:if test="${verificacaoCadastro == false}">
											<script type="text/javascript">
										    	alert("Usuário não cadastrado. Contate o administrador do sistema");
									    	</script>
										</c:if>
									</c:if>
									<c:if test="${esqueceuSuaSenha == true}">
										<c:if test="${verificacaoEsqueceuSuaSenha == true}">
											<script type="text/javascript">
										    	alert("Email enviado");
									    	</script>
										</c:if>
										<c:if test="${verificacaoEsqueceuSuaSenha == false}">
											<script type="text/javascript">
										    	alert("Email não cadastrado");
									    	</script>
										</c:if>
									</c:if>
								
								
								</div>

                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Não possui uma conta? 
	                                        <a href="javascript: void(0);" onClick="$('#signupModal').modal('show')">
	                                            Cadastre-se aqui
	                                        </a>
                                        </div>
                                       	<div style="font-size:85%" >
	                                        <a href="javascript: void(0);" onclick="$('#modalEsqueceuSenha').modal('show')">
	                                        	Esqueceu sua senha?
	                                        </a>
                                        </div>
                                       	<div style="font-size:85%" >
	                                        <a href="javascript: void(0);" onClick="$('#modalSobre').modal('show')">
	                                            Sobre o Ed-AbES
	                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     

                        </div>                     
                    </div>  
        </div>
        </div>
		
		<!-- CADASTRO -->
        <div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<jsp:include page="_CreateNewUser.jsp" />
		</div>
	</div>
		<!-- FIM DO CADASTRO -->
		
    <!-- ESQUECEU SUA SENHA -->
	<div class="modal fade" id="modalEsqueceuSenha" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<jsp:include page="_ForgotPassword.jsp" />
		</div>
	</div>
    <!-- FIM DO ESQUECEU SUA SENHA -->
    
    <!-- SOBRE -->
	<div class="modal fade" id="modalSobre" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="mateushaas" action="Sobre" method="POST">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Sobre o Ed_AbES<a href="javascript: void(0);"><img class="runTimeTranslation" title="Bem vindo ao edi AbES. Esta aplicassao e responssavel pela criassao de ambientes virtuais" style="padding-left: 8px; padding-bottom: 3px;" src="/resources/img/icone_som.png"></img></a></h4>
					</div>
					<div class="modal-body">
						<label>Bem vindo ao Ed-AbES, esta aplicação é responsável pela criação de ambientes virtuais.</label>
						<br/>
						<br/>
						<label>Desenvolvedores:</label>
						<ul>
						  <li>Muriel Garrido Pereira</li>
						  <li>Daniel Luz Woo Pinto</li>
						</ul>
						<label>Orientadora:</label>
						<ul>
						  <li>Prof. Márcia Campos</li>
						</ul>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" onclick="hideModal('modalSobre');" data-dismiss="modal"><img src="/resources/img/icon_cancel.png" /> &nbsp Fechar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
    <!-- FIM DO SOBRE -->  
    
    <script type="text/javascript" src="/resources/js/login.js"></script>
    <script type="text/javascript" src="/resources/js/Atalhos_teclado/login_keyboard.js"></script>
    <script type="text/javascript">
		function validaForm () {
			return true;
		}
		
		function validaSenha (input){ 
		    if (input.value != document.getElementById('senha').value) {
		    input.setCustomValidity('Repita a senha corretamente');
		  } else {
		    input.setCustomValidity('');
		  }
		} 	
	</script>
    
  </body>
</html>