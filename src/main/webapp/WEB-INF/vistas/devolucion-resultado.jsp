<jsp:include page="includes/top.jsp" />
<jsp:include page="includes/modalPuntuacion.jsp" />
		<div class = "container">
			<h1>Id Devolucion: ${devolucionId}</h1>
			<br>
			<h2>Precio Extra: ${precioExtra}</h2>
			
			<div class="card w-50">
			  <div class="card-body text-center">
			    <h5 class="card-title">¿Como te parecio nuestro vehiculo? Puntualo</h5>
				<button type="button" class="btn btn-info" data-toggle="modal" data-target="#modalPuntuacion">
  					Puntuar
				</button>
			  </div>
			</div>
			
			
			
			<div class="container">
				<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/home">Volver al Inicio</a>
			</div>
		</div>
<jsp:include page="includes/bottom.jsp" />

