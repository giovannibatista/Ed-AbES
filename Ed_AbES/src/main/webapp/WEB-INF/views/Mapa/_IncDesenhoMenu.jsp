<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edabes.dto.*"%>

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	<c:forEach items="${listaObjetosMenu}" var="categoria">
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="heading${categoria.idCategoria}">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapse${categoria.idCategoria}"
						aria-expanded="true" aria-controls="collapse${categoria.idCategoria}">${categoria.titulo}</a>
				</h4>
			</div>
			<div id="collapse${categoria.idCategoria}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${categoria.idCategoria}">
				<div class="panel-body">
					<div class="panel-group" id="accordion${categoria.idCategoria}" role="tablist" aria-multiselectable="true">
						<c:forEach items="${categoria.listaDeSubcategoria}" var="subcategoria">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading${subcategoria.idSubcategoria}">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion${categoria.idCategoria}" href="#collapseSub${subcategoria.idSubcategoria}" aria-expanded="true">${subcategoria.titulo}</a>
									</h4>
								</div>
								<div id="collapseSub${subcategoria.idSubcategoria}" class="panel-collapse collapse" role="tabpanel">
									<div class="panel-body">
										<div class="row">
											<c:forEach items="${subcategoria.listaObjetos}" var="objeto">
												<div class="col-md-4">
													<a href="javascript: void(0);" 
														class="thumbnail" 
														data-image="${objeto.imagemMapa}" 
														data-width="${objeto.largura}" 
														data-height="${objeto.altura}" 
														data-objeto="${objeto.idObjeto}"
														data-nome="${objeto.nome}"
														data-rotate="0"
														title="${objeto.nome}">
														<img src="${objeto.imagemMenu}" alt="${objeto.nome}" border="0" />
													</a>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>