<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Reservar fecha</title>
<div class="container">

	<form:form action="reserva-lista-autos" method="POST"
		modelAttribute="busqueda">
		<h3 class="form-signin-heading">Reservar Auto</h3>
		<hr class="colorgraph" />
		<br>
		
		<div class="container">
			<div class="row">

				<div class="col-sm">
					<div class="card bg-light mb-3" style="max-width: 18rem;">
						<div class="card-header text-center">Tipo Contrato</div>
						<div class="card-body">
							Seleccione un contrato<br><br>
							<input type="radio" name="tipoContrato" value="km" required="required"> Por Kilometraje<br><br> 
							<input type="radio" name="tipoContrato" value="dia" required="required"> Por Día<br>
						</div>
					</div>
				</div>
				<div class="col-sm">

					<div class="card bg-light mb-3" style="max-width: 18rem;">
						<div class="card-header text-center">Descripcion Precios</div>
						<div class="card-body">
							<h5 class="card-title text-center">Por Km</h5>
							<p class="card-text text-center">$20</p>
							
							<h5 class="card-title text-center">Por Día</h5>
							<p class="card-text text-center">$800</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="form-group">
			Fecha desde:
			<form:input id="fechaDesde" path="fechaDesde" required="required"
				type="date" class="form-control" />
		</div>

		<div class="form-group">
			Fecha hasta:
			<form:input id="fechaHasta" path="fechaHasta" required="required"
				type="date" class="form-control" />

		</div>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
	</form:form>

</div>

<jsp:include page="includes/bottom.jsp" />