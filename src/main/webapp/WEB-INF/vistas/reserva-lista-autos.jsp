<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	</head>
	<body>
		<div class = "container">
			<h1></h1>
			
			<div>
			${busqueda.fechaDesde} - ${busqueda.fechaHasta}
			</div>
			
			<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">id</th>
									<th scope="col">Marca</th>
									<th scope="col">Nombre</th>
									<th scope="col">Precio</th>
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
										<td>
											<form action="agregar-caracteristicas" method="POST">
												<input name="fechaDesde" value="${busqueda.fechaDesde}" type="hidden"/>
											 	<input name="fechaHasta" value="${busqueda.fechaHasta}" type="hidden"/>
											 	
											
											 	 	<input name="precio" value="${auto.precio}" type="hidden"/>
											 	 	
								
											 	 	
								<label><input type="checkbox" name="seguro" value="true"> Seguro por daños</label><br>
								<label><input type="checkbox"  name="tanque"value="true"> Tanque lleno</label><br>
								<label><input type="checkbox"  name="chofer"value="true"> Con chofer</label><br>
									<button class="btn btn-lg btn-primary btn-block" type="submit">Agregar</button>
									
												
						
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