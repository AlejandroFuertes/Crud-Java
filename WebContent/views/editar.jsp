<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Producto</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript" src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-lg-6">
			<h3>Editar Producto</h3>
		
			<form action="productos" method="post">
		
				<c:set var="producto" value="${producto}"></c:set>
		
				<input type="hidden" name="opcion" value="editar"> <input
					type="hidden" name="id" value="${producto.id}">
				<table class="table table-bordered">
					<tr>
						<td class="text-center">Nombre</td>
						<td class="text-center"><input type="text" name="nombre" size="50"
							value="${producto.nombre}"></td>
					</tr>
					<tr>
						<td class="text-center">Cantidad</td>
						<td class="text-center"><input type="text" name="cantidad" size="50"
							value="${producto.cantidad}"></td>
					</tr>
					<tr>
						<td class="text-center">Precio</td>
						<td class="text-center"><input type="text" name="precio" size="50"
							value="${producto.precio}"></td>
					</tr>
		
				</table>
				
				<button type="submit" class="btn btn-primary" value="Actualizar">Actualizar</button>
		
			</form>
		</div>
	</div>
</body>
</html>