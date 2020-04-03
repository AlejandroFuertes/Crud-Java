<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

<title>Crear Producto</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript" src="./bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./bootstrap/css/estilos.css"
	type="text/css">
</head>
<body>
	<div class="container">
		<div class="col-lg-6">
			<div class="centrarForm">
				<form action="productos" method="post">

					<h3 style="text-align: center">Producto</h3>

					<input type="hidden" name="opcion" value="guardar">

					<div class="form-group">
						<label for="ProductName">Nombre</label> <input
							class="form-control" type="text" name="nombre" size="50"
							placeholder="Introduzca el nombre del producto" required="required" autofocus="autofocus">
					</div>

					<div class="form-group">
						<label for="ProductQuantity">Cantidad</label> <input
							class="form-control" type="number" name="cantidad" size="50"
							placeholder="Introduzca la cantidad disponible" required="required" min = "0">
					</div>

					<div class="form-group">
						<label for="ProductPrice">Precio</label> <input
							class="form-control" type="number" name="precio" size="50"
							placeholder="Introduzca el precio" required="required" min = "0">
					</div>

					<button type="submit" class="btn btn-success" value="Guardar">Guardar</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>