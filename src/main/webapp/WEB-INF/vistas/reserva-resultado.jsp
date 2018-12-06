<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Reserva Resultado</title>
		<div class = "container">
			<h1>Ha reservado exitosamente el vehiculo! </h1>
			<h3>Id Reserva: ${reservaId}</h3>
			
			<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/home">Volver al Inicio</a>
		</div>
<jsp:include page="includes/bottom.jsp" />