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
			
			
			<h1>Id Reserva: ${reservaId}</h1>
			
			<!-- Mostar mas datos del vehiculo -->
			
			<form action="entregar-auto" method="POST">
								<input name="reservaId" value="${reservaId}" type="hidden"/>
								Ingresar Kilometros Actuales del vehiculo
								<br>
								Kms:<input name="kilometrajeActual" required="required" type="number" />
								<button class="btn btn-lg btn-primary btn-block" type="submit">Entregar</button>
			</form>
			
			
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
	</body>
</html>