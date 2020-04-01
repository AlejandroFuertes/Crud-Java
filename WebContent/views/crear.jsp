<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Producto</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript" src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-lg-6" >

			<h3>Crear Producto</h3>

			<form action="productos" method="post">
				<input type="hidden" name="opcion" value="guardar">

				<div class="form-group">
					<label for="ProductName">Nombre</label> <input class="form-control"
						type="text" name="nombre" size="50"
						placeholder="Introduzca el nombre del producto">
				</div>

				<div class="form-group">
					<label for="ProductQuantity">Cantidad</label> <input
						class="form-control" type="text" name="cantidad" size="50"
						placeholder="Introduzca la cantidad disponible">
				</div>

				<div class="form-group">
					<label for="ProductPrice">Precio</label> <input
						class="form-control" type="text" name="precio" size="50"
						placeholder="Introduzca el precio">
				</div>

				<button type="submit" class="btn btn-primary" value="Guardar">Guardar</button>

			</form>
		</div>
	</div>

</body>
</html>