<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" href="img/favicon.ico">

		<title>Registrarse</title>

		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	</head>

	<body>
		<div class="container">
			<br>
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="card">
						<header class="card-header">
							<h4 class="card-title mt-2">Registro</h4>
						</header>
						<article class="card-body">
							<form:form action="registrar-usuario" method="post" modelAttribute="usuario">
								<%-- TODO: Agregar estos atributos a Usuario?? --%>
								<%--<div class="form-row">--%>
									<%--<div class="col form-group">--%>
										<%--<label>Nombre</label>--%>
										<%--<form:input type="text" class="form-control" placeholder="" path="nombre" required="true"/>--%>
									<%--</div>--%>
									<%--<div class="col form-group">--%>
										<%--<label>Apellido</label>--%>
										<%--<form:input type="text" class="form-control" placeholder=" " path="apellido" required="true"/>--%>
									<%--</div>--%>
								<%--</div>--%>
								<div class="form-group">
									<label>E-mail</label>
									<form:input type="email" class="form-control" placeholder="" path="email" required="true"/>
								</div>
								<div class="form-group">
									<label>Contraseña</label>
									<form:input class="form-control" type="password"  path="password" required="true"/>
								</div>
								<div class="form-group">
									<label>Repetir contraseña</label>
									<input class="form-control" type="password">
								</div>
								<button type="submit" class="btn btn-primary btn-block"> Registrarse</button>
							</form:form>
						</article>
						<div class="border-top card-body text-center">¿Ya estás registrado? <a href="${pageContext.request.contextPath}/login">Iniciar Sesión</a></div>
					</div>
				</div>

			</div>

		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
	</body>
</html>
