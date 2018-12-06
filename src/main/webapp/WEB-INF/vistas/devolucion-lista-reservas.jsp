<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Devolucion Lista Vehiculos</title>
		<div class = "container">
			
			<h3 class="form-signin-heading">Devoluciones de Vehiculos</h3>
			<hr class="colorgraph" />
			
			<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">Id Entrega</th>
									<th scope="col">Fecha Entrega</th>
									<th scope="col">Fecha Hasta Reserva</th>
									<th scope="col">Auto Id</th>
									<th scope="col">Devolucion</th>
							
								</tr>
							</thead>
							<tbody>
			<c:forEach var="entrega" items="${listaReservasEntregadas}">

									<tr>
										<td><c:out value="${entrega.id}" /></td>	
										<td><c:out value="${entrega.fechaEntrega}" /></td>
										<td><c:out value="${entrega.reserva.fechaHasta}" /></td>
										<td><c:out value="${entrega.reserva.auto.id}" /></td>
										<td>
											<form action="devolucion-km-auto" method="POST">
												<input name="reservaId" value="${entrega.reserva.id}" type="hidden"/>
												<button class="btn btn-lg btn-primary btn-block" type="submit">Devolver</button>
											</form>
										</td>
									</tr>
								</c:forEach>
								</tbody>
								</table>
			
		</div>
<jsp:include page="includes/bottom.jsp" />