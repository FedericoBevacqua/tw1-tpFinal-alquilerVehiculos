<%@ page import="com.mercadopago.MP" %>
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="includes/top.jsp" />

<%
	MP mp = new MP("7466445635971939", "b2T9AcENUezVW34XoYyOWe4mO1Ow4M32");

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String preferenceData = "{'items':" +
			"[{"+
			"'title':'Reserva de Auto'," +
			"'quantity':1," +
			"'currency_id':'ARS'," + // Available currencies at: https://api.mercadopago.com/currencies
			"'unit_price': "+ request.getAttribute("importe") +
			"}]" +
			", 'back_urls': {" +
			"'success':'http://localhost:8080/tw1-tpFinal-alquilerVehiculos/procesar-pago?result=success&fechaDesde="
			+ sdf.format(request.getAttribute("fechaDesde")) + "&fechaHasta=" + sdf.format(request.getAttribute("fechaHasta"))
			+ "&tipoContrato=" + request.getAttribute("tipoContrato") + "&autoId=" + request.getAttribute("autoId")
			+ "'," +
			"'failure': 'http://localhost:8080/tw1-tpFinal-alquilerVehiculos/procesar-pago?result=failure'," +
			"'pending':'http://localhost:8080/tw1-tpFinal-alquilerVehiculos/procesar-pago?result=pending'" +
			"}" +
			"}";

	JSONObject preference = mp.createPreference(preferenceData);

	String initPoint = preference.getJSONObject("response").getString("init_point");
%>

<title>Rent a Car - Reserva Pagar</title>
		<div class = "container">
			<h1>Pagar Reserva</h1>
			<h3>Importe: $ <fmt:formatNumber type="number" maxFractionDigits="2" value="${importe}" /></h3>

			<div>Tipo de Pago: </div>
			<form action="reservar-auto" method="POST" class="form-inline">

				<input class="form-control" id="firstDate" name="fechaDesde" type="hidden" value="<fmt:formatDate value='${fechaDesde}' type='date' pattern='yyyy-MM-dd'/>" />
				<input class="form-control" id="fechaHasta" name="fechaHasta" type="hidden" value="<fmt:formatDate value='${fechaHasta}' type='date' pattern='yyyy-MM-dd'/>" />
				<input name="tipoContrato" value="${tipoContrato}" type="hidden" />
				<input name="autoId" value="${autoId}" type="hidden" />

				<div class="form-group mx-sm-3 mb-2">
					<!-- Boton de MercadoPago -->
					<a href="<%= initPoint %>" mp-mode="modal" name="MP-Checkout" id="botonMercadoPago" class="btn btn-primary">Pagar con MercadoPago</a>
				</div>

				<div class="form-group mx-sm-3 mb-2">
					<button class="btn btn-primary btn-block" type="submit">Pagar en Efectivo</button>
				</div>
			</form>

			<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/home">Volver al Inicio</a>
		</div>

	<!-- Cargar library JavaScript de MercadoPago -->
	<script src="https://secure.mlstatic.com/sdk/javascript/v1/mercadopago.js"></script>
	<%--Mercadopago.setPublishableKey("TEST-f6fab4cd-7cb9-4e3c-b4aa-9e1ff6385d2c");--%>
<jsp:include page="includes/bottom.jsp" />