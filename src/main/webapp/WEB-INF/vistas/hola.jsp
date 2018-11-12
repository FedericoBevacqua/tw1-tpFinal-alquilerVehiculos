<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">id</th>
									<th scope="col">Marca</th>
									<th scope="col">Nombre</th>
									<th scope="col">Precio</th>
									<th scope="col">Reservar</th>
							
								</tr>
							</thead>
							<tbody>
			<c:forEach var="auto" items="${filtroPorMarca}">

									<tr>
										<td><c:out value="${auto.id}" /></td>	
										<td><c:out value="${auto.marca}" /></td>
										<td><c:out value="${auto.nombre}" /></td>
										<td><c:out value="${auto.precio}" /></td>
										<td>
											<form action="reservar-auto" method="POST">
												<input name="fechaDesde" value="${busqueda.fechaDesde}" type="hidden"/>
											 	<input name="fechaHasta" value="${busqueda.fechaHasta}" type="hidden"/>
											 	<input name="autoId" value="${auto.id}" type="hidden"/>
												<button class="btn btn-lg btn-primary btn-block" type="submit">Reservar</button>
											</form>
										</td>
									</tr>
								</c:forEach>
								</tbody>
								</table> 
</body>
</html>