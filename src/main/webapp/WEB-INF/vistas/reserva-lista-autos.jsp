<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Reservar Vehiculo</title>
	<div class="container">
		<h3 class="form-signin-heading">Reserva Lista Vehiculos</h3>
		<hr class="colorgraph" />

		<div>${busqueda.fechaDesde} - ${busqueda.fechaHasta}</div>
		
	
		
		Filtrar por:<br> Marcas<br>

		<div class="row">
			<div class="col-sm-4">
			
			<form action="reserva-lista-autos" method="POST">
												<input name="fechaDesde" value="${busqueda.fechaDesde}" type="hidden" /> 
												<input name="fechaHasta" value="${busqueda.fechaHasta}" type="hidden" /> 
												<input name="tipoContrato" value="${tipoContrato}" type="hidden" /> 
												
												<input type="checkbox" name="Ford" >Ford<br>
												<input type="checkbox" name="Chevrolet" >Chevrolet<br>
												<input type="checkbox" name="Toyota">Toyota<br>
												
												<br> Ordenar por :<br>
													<input type="checkbox" name="menorPrecio" >Menor Precio<br>
													<input type="checkbox" name="mayorPrecio" >Mayor Precio<br><br>
														<div class="col-sm-6">
														<button class="btn btn-lg btn-primary btn-block"
													
													
											
													type="submit">Filtrar</button><br><br>
														<button class="btn btn-lg btn-primary btn-block"
													type="submit">Borrar Filtros</button><br>
													</div>
											</form>
		
					
					
			</div>

			<div>

						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">id</th>
									<th scope="col">Marca</th>
									<th scope="col">Nombre</th>
									<th scope="col">Precio</th>
									<th scope="col">Puntaje</th>
									<th scope="col">Reservar</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="auto" items="${autosDisponibles}">

									<tr>
										<td><c:out value="${auto.id}" /></td>
										<td><c:out value="${auto.marca}" /></td>
										<td><c:out value="${auto.nombre}" /></td>
										<td><c:out value="${auto.precio}" /></td>
										<td><c:out value="${auto.puntajePromedio} / 5" /></td>
										<td>
											<form action="reservar-auto" method="POST">
												<input name="fechaDesde" value="${busqueda.fechaDesde}" type="hidden" /> 
												<input name="fechaHasta" value="${busqueda.fechaHasta}" type="hidden" /> 
												<input name="tipoContrato" value="${tipoContrato}" type="hidden" /> 
												<input name="autoId" value="${auto.id}" type="hidden" />
												<button class="btn btn-lg btn-primary btn-block"
													type="submit">Reservar</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

				
			</div>
		</div>
	</div>

<jsp:include page="includes/bottom.jsp" />