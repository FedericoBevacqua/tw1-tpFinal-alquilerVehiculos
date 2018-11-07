<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	</head>
	<body>
		<div class = "container">
			<h1>Entregas de Vehiculos</h1>
			
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
											<form action="entregar-auto" method="POST">
												<input name="reservaId" value="${reserva.id}" type="hidden"/>
												<button class="btn btn-lg btn-primary btn-block" type="submit">Entregar</button>
											</form>
										</td>
									</tr>
								</c:forEach>
								</tbody>
								</table>
			
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
	</body>
</html>