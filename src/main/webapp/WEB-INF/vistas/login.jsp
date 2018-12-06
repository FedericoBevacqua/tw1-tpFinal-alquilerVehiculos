<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" href="img/favicon.ico">

		<title>Rent a Car - Iniciar Sesión</title>

		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >

		<!-- Custom styles for this template -->
		<link href="css/login.css" rel="stylesheet">
	</head>

	<body class="text-center">
		<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
		<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
		<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
		<form:form action="validar-login" method="POST" modelAttribute="usuario" class="form-signin">
			<img class="mb-4" src="img/logo.svg" alt="" width="72" height="72">
			<h1 class="h3 mb-3 font-weight-normal">Por favor inicie sesión</h1>
			<label for="email" class="sr-only">E-mail</label>
			<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
			<form:input type="email" id="email" path="email" class="form-control" placeholder="Correo electrónico" required="true" autofocus="autofocus"/>
			<label for="password" class="sr-only">Contraseña</label>
			<form:input type="password" id="password" path="password" class="form-control" placeholder="Contraseña" required="true"/>
			<div class="checkbox mb-3">
				<label>
					<input type="checkbox" value="remember-me"> Recordarme
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar sesión</button>
			<a class="btn btn-lg btn-outline-success btn-block" role="button" href="${pageContext.request.contextPath}/registro">Registrarse</a>
			<p class="mt-5 mb-3 text-muted">&copy; 2018</p>

			<%-- Bloque que es visible si el elemento error no está vacío --%>
			<c:if test="${not empty error}">
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
					${error}
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
		</form:form>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
	</body>
</html>
