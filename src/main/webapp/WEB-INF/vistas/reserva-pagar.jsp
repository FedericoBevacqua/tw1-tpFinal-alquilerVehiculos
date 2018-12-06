<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="includes/top.jsp" />
<title>Rent a Car - Reserva Pagar</title>
		<div class = "container">
			<h1>Pagar Reserva</h1>
			<h3>Importe: $ <fmt:formatNumber type="number" maxFractionDigits="2" value="${importe}" /></h3>

			<div>Tipo de Pago: </div>
			<form action="reservar-auto" method="POST" class="form-inline">

				<div class="form-group mb-2">
					<select name="tipoPago" title="tipoPago" id="tipoPago" class="form-control">
						<option value="efectivo">Efectivo</option>
						<option value="mercadoPago" disabled>MercadoPago</option>
					</select>
				</div>

				<input class="form-control" id="firstDate" name="fechaDesde" type="hidden" value="<fmt:formatDate value='${fechaDesde}' type='date' pattern='yyyy-MM-dd'/>" />
				<input class="form-control" id="fechaHasta" name="fechaHasta" type="hidden" value="<fmt:formatDate value='${fechaHasta}' type='date' pattern='yyyy-MM-dd'/>" />
				<input name="tipoContrato" value="${tipoContrato}" type="hidden" />
				<input name="autoId" value="${autoId}" type="hidden" />

				<div class="form-group mx-sm-3 mb-2">
					<button class="btn btn-primary btn-block" type="submit">Pagar</button>
				</div>
			</form>

			<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/home">Volver al Inicio</a>
		</div>

<jsp:include page="includes/bottom.jsp" />