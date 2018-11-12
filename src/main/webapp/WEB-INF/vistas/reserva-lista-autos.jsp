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
			

		Filtrar por:<br>	
	Marcas<br>

		  <div class="row">
    <div class="col-sm-4" >
    	<a class="btn btn-link" href="hola?marca=Ford" role="button">Ford</a><br>
	<a class="btn btn-link" href="hola?marca=Chevrolet" role="button">Chevrolet</a><br>
	<a class="btn btn-link" href="hola?marca=Toyota" role="button">Toyota</a><br>
	<a class="btn btn-link" href="hola?marca=Audi" role="button">Audi</a><br>
	<a class="btn btn-link" href="hola?marca=BMW" role="button">BMW</a><br>
    </div>
     <div  >
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
											<form action="reservar-auto" method="POST">
												<input name="fechaDesde" value="${busqueda.fechaDesde}" type="hidden"/>
											 	<input name="fechaHasta" value="${busqueda.fechaHasta}" type="hidden"/>
											 	<input name="autoId" value="${auto.id}" type="hidden"/>
												<button class="btn btn-lg btn-primary btn-block" type="submit">Reservar</button>
											</form>
										</td>
									</tr>
								</c:forEach>
								</tbody>
								</table>
								    </div>
    





			
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
	</body>
</html>