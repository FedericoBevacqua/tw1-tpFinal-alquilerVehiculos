<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Entrega Lista Vehiculos</title>
		<div class = "container">
			
		<h3 class="form-signin-heading">Entregas de Vehiculos</h3>
		<hr class="colorgraph" />

			<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">Id Reserva</th>
									<th scope="col">Fecha Desde</th>
									<th scope="col">Fecha Hasta</th>
									<th scope="col">Auto Id</th>
									<th scope="col">Entregar</th>
							
								</tr>
							</thead>
							<tbody>
			<c:forEach var="reserva" items="${listaReservasPendientes}">

									<tr>
										<td><c:out value="${reserva.id}" /></td>	
										<td><c:out value="${reserva.fechaDesde}" /></td>
										<td><c:out value="${reserva.fechaHasta}" /></td>
										<td><c:out value="${reserva.auto.id}" /></td>
										<td>
											<form action="entregar-km-auto" method="POST">
												<input name="reservaId" value="${reserva.id}" type="hidden"/>
												<button class="btn btn-lg btn-primary btn-block" type="submit">Entregar</button>
											</form>
										</td>
									</tr>
								</c:forEach>
								</tbody>
								</table>
			
		</div>
<jsp:include page="includes/bottom.jsp" />