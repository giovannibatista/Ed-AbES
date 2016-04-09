<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>Ed-AbES - importar os arquivos de áudio</title>

<jsp:include page="../Head.jsp" />

<script type="text/javascript" src="/resources/js/Audio/Form.js"
	charset="UTF-8"></script>
</head>
<body>
	<div class="content">
		<div id="mainMenu">
			<jsp:include page="../Menu.jsp" />
		</div>
		<div id="mainBody">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">Importar os arquivos de áudio</div>
						</div>
						<div class="panel-body">
							<form id="formularioUploadAudio" class="form-horizontal"
								method="POST" enctype="multipart/form-data">
								<div class="form-group">
									<label for="nomeMapa" class="col-md-4 control-label">Arquivo:</label>
									<div class="col-md-8">
										<input id="arquivo" type="file" class=""
											name="arquivo" accept="audio/*"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Descrição:</label>
									<div class="col-md-8">
										<input type="text" class="form-control" id="descricaoAudio"
											name="descricaoAudio"
											placeholder="Som de batida em madeira (Dica: Descrição curta)" />
									</div>
								</div>

								<div class="form-group">
									<!-- Button -->
									<div class="col-md-offset-3 col-md-9 text-right">
										<button type="submit" class="btn btn-success">
											<img src="/resources/img/icon_check.png" /> &nbsp; Salvar
										</button>

										<button id="formularioCancelButton" type="button"
											class="btn btn-danger">
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
</body>
</html>