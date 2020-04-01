<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Producto</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	type="text/css">
	<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-lg-6">
			<h3>Crear Producto</h3>

			<form action="productos" method="post">
				<input type="hidden" name="opcion" value="guardar">
				<table class="table table-bordered" border="1">
					<tr>
						<td>Nombre</td>
						<td><input class="form-control" type="text" name="nombre"
							size="50"></td>
					</tr>
					<tr>
						<td>Cantidad</td>
						<td><input class="form-control" type="text" name="cantidad"
							size="50"></td>
					</tr>
					<tr>
						<td>Precio</td>
						<td><input class="form-control" type="text" name="precio"
							size="50"></td>
					</tr>

				</table>
				<button type="submit" class="btn btn-primary" value="Guardar">
					Guardar</button>

			</form>
		</div>
	</div>

</body>
</html>