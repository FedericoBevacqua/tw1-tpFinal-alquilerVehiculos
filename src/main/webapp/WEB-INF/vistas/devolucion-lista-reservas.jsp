<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	</head>
	<body>
		<div class = "container">
			<h1>Devoluciones de Vehiculos</h1>
			
			<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">Id Reserva</th>
									<th scope="col">Fecha Entrega</th>
									<th scope="col">Fecha Hasta Reserva</th>
									<th scope="col">Auto Id</th>
									<th scope="col">Devolucion</th>
							
								</tr>
							</thead>
							<tbody>
			<c:forEach var="entrega" items="${listaEntregasRealizadas}">

									<tr>
										<td><c:out value="${entrega.id}" /></td>	
										<td><c:out value="${entrega.fechaEntrega}" /></td>
										<td><c:out value="${entrega.reserva.fechaHasta}" /></td>
										<td><c:out value="${entrega.reserva.auto.id}" /></td>
										<td>
											<form action="devolver-auto" method="POST">
												<input name="entregaId" value="${entrega.id}" type="hidden"/>
												<button class="btn btn-lg btn-primary btn-block" type="submit">Devolver</button>
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