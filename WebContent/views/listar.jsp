<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listar Productos</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./bootstrap/css/estilos.css" type="text/css">
</head>
<body>
	<br><br>
	<div class="container">
	
		<div class="col-lg8">
			<h3>Lista de Productos</h3>
			<a class="btn btn-success" href="productos?opcion=crear">Agregar Nuevo</a>
			<br><br>
			<table class="table table-bordered">
				<tr>
					<td class="text-center">ID</td>
					<td class="text-center">Nombre</td>
					<td class="text-center">Cantidad</td>
					<td class="text-center">Precio</td>
					<td class="text-center">Fecha Creacion</td>
					<td class="text-center">Fecha Actualizacion</td>
					<td class="text-center">Accion</td>
				</tr>
	
				<c:forEach var="producto" items="${lista}">
					<tr>
						<td class="text-center"><a
							href="productos?opcion=mostrarEditar&id=<c:out value="${producto.id}"></c:out>">
								<c:out value="${producto.id}"></c:out>
						</a></td>
						<td class="text-center"><c:out value="${producto.nombre}"></c:out></td>
						<td class="text-center"><c:out value="${producto.cantidad}"></c:out></td>
						<td class="text-center"><c:out value="${producto.precio}"></c:out></td>
						<td class="text-center"><c:out value="${producto.fechaCrear }"></c:out></td>
						<td class="text-center"><c:out value="${producto.fechaActualizar }"></c:out></td>
						<td class="text-center"><a class = "btn btn-danger"
							href="productos?opcion=eliminar&id=<c:out value="${producto.id}"></c:out>">
								Eliminar </a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>