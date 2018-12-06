<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Devolucion de Vehiculos</title>
		<div class = "container">
			
			<h3 class="form-signin-heading">Devolucion de Vehiculos</h3>
			<hr class="colorgraph" />
			
			
			<h3>Id Reserva: ${reservaId}</h3>
			
			<!-- Mostar mas datos del vehiculo -->
			
			<form action="devolver-auto" method="POST">
								<input name="reservaId" value="${reservaId}" type="hidden"/>
								Ingresar Kilometros Actuales para la Devolucion del vehiculo
								<br>
								Kms:<input name="kilometrajeDevolucion" required="required" type="number" />
								<button class="btn btn-lg btn-primary btn-block" type="submit">Entregar</button>
			</form>
			
			
		</div>
<jsp:include page="includes/bottom.jsp" />