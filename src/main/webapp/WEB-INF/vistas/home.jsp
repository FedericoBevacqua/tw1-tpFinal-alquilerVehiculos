<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	</head>
	<body>
		<div class = "container">
			<h1>Bienvenidos a ReservaTuAuto</h1>
			
			<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/reserva-fecha">Ir a Reservas</a>
			<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/entrega-lista-autos">Ir a Entregas</a>
			<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/devolucion-auto">Ir a Devoluciones</a>

		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
	</body>
</html>