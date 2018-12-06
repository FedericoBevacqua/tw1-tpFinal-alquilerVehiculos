<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Home</title>
	
		<c:if test="${not empty mensaje}">
			<div class="container">
				<c:out value="${mensaje}"/>
			</div>
		</c:if>
		<div class="container">
		
		<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
	      <h1 class="display-4">Alquila Ya</h1>
	      <p class="lead">Bienvenidos a Rent a Car, aquí encontraras los mejores precios, variedad y disponibilidad de todo tipo de vehículos. No esperes mas y Reserva ya tu auto. </p>
   		</div>
		
		<div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">Cliente</h4>
          </div>
          <div class="card-body">
            <h1 class="card-title pricing-card-title">Reserva</h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>2 Tipos de contratos</li>
              <li>Precios accesibles</li>
              <li>Amplia disponibilidad</li>
              <li>Gran variedad de Vehiculos</li>
            </ul>
            <a role="button" class="btn btn-lg btn-block btn-outline-primary" href="${pageContext.request.contextPath}/reserva-fecha">Ir a Reservas</a>
          </div>
        </div>
        <div class="card mb-4 shadow-sm">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">Vendedor</h4>
          </div>
          <div class="card-body">
            <h1 class="card-title pricing-card-title">Entrega</h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>Lista vehiculos reservados</li>
              <li>Precio varia por contrato</li>
              <li>Ingresar KMs Actuales</li>
              <li>(Vendedor)</li>
            </ul>
            <a role="button" class="btn btn-lg btn-block btn-primary" href="${pageContext.request.contextPath}/entrega-lista-autos">Ir a Entregas</a>
          </div>
        </div>
        <div class="card mb-4 shadow-sm">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">Vendedor</h4>
          </div>
          <div class="card-body">
            <h1 class="card-title pricing-card-title">Devolución</h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>Lista vehiculos entregados</li>
              <li>Precio: Agregados extras</li>
              <li>Sumados excesos Dias o Kms</li>
              <li>(Vendedor)</li>
            </ul>
            <a role="button" class="btn btn-lg btn-block btn-primary" href="${pageContext.request.contextPath}/devolucion-lista-reservas">Ir a Devoluciones</a>
          </div>
        </div>
      </div>
	</div>
<jsp:include page="includes/bottom.jsp" />