<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Editar Producto</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript" src="./bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./bootstrap/css/estilos.css" type="text/css">
</head>
<body>
	<div class="container">
		<div class="col-lg-6">
			<div class="centrarForm">			
				<form action="productos" method="post">
					<h3 style="text-align: center">Actualizar Producto</h3>
					
					<c:set var="producto" value="${producto}"></c:set>
			
					<input type="hidden" name="opcion" value="editar"> <input
						type="hidden" name="id" value="${producto.id}">
						
						<div class = "form-group">
							<label for="ProductName" >Nombre</label>
						
						<input class="form-control" type="text" name="nombre" size="50"
								value="${producto.nombre}">
						
						</div>
						<div class="form-group">
							<label for="ProductQuantity">Cantidad</label>
							<input class="form-control" type="text" name="cantidad" size="50" value="${producto.cantidad}">
						</div>
						<div class="form-group">
							<label for="ProductPrice">Precio</label>
							<input class="form-control" type="text" name="precio" size="50" value="${producto.precio}">
						</div>
					<button type="submit" class="btn btn-primary" value="Actualizar">Actualizar</button>
			
				</form>
			</div>
		</div>
	</div>
</body>
</html>