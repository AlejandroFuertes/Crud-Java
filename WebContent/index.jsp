<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./bootstrap/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet" href="./bootstrap/css/estilos.css" type="text/css">
<title>Menú de Opciones</title>
</head>

<body>

	<div class="container">
	<h3>Menu de Opciones Productos</h3>

		<div class="col-lg-6">
			<table class="table table-bordered">	
				<tr>
		
					<td><a href="productos?opcion=crear"> Crear un Producto </a></td>
		
				</tr>
				<tr>
					<td><a href="productos?opcion=listar"> Listar Productos </a></td>
				</tr>
				<tr>
					<td>Obtener un Producto</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>