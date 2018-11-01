<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h1>Bienvenidos a Taller Web 1</h1>
			
		<form:form action="reservar-auto" method="POST" modelAttribute="reserva">
	    	<h3 class="form-signin-heading">Reservar Auto</h3>
			<hr class="colorgraph"><br>
			
			<select name="auto">
			    <c:forEach items="${listaAutosDisponibles}" var="auto">
		            <option value="${auto.id}">${auto.id} ${auto.disponible}</option>
			    </c:forEach>
			</select>  		  
			
			<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Reservar</button>
		</form:form>
			
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>