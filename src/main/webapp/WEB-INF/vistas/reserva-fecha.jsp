<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">

		<form:form action="reserva-lista-autos" method="POST" modelAttribute="busqueda">
	    	<h3 class="form-signin-heading">Reservar Auto</h3>
			<hr class="colorgraph"/><br>		  
			
			<div class="form-group">
			Fecha desde: <form:input id="fechaDesde" path="fechaDesde" required="required" type="date" class="form-control"/>
			</div>
			
			<div class="form-group">
			Fecha hasta: <form:input id="fechaHasta" path="fechaHasta" required="required" type="date" class="form-control"/>
			
			</div>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
		</form:form>
			
		</div>

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>