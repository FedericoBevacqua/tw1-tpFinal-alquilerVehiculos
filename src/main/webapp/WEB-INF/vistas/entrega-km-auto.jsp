<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Entrega de Vehiculos</title>
		<div class = "container">
			
			<h3 class="form-signin-heading">Entregas de Vehiculos</h3>
			<hr class="colorgraph" />
			
			
			<h3>Id Reserva: ${reservaId}</h3>
			
			<!-- Mostar mas datos del vehiculo -->
			
			<form action="entregar-auto" method="POST">
								<input name="reservaId" value="${reservaId}" type="hidden"/>
								Ingresar Kilometros Actuales del vehiculo
								<br>
								Kms:<input name="kilometrajeActual" required="required" type="number" />
								<br>
								<button class="btn btn-lg btn-primary btn-block" type="submit">Entregar</button>
			</form>
			
			
		</div>
<jsp:include page="includes/bottom.jsp" />