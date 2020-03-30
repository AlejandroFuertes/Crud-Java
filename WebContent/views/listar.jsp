<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Productos</title>
</head>
<body>
	<h3>Listar Productos</h3>

	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nombre</td>
			<td>Cantidad</td>
			<td>Precio</td>
			<td>Fecha Creacion</td>
			<td>Fecha Actualizacion</td>
		</tr>

		<c:forEach var="producto" items="${lista}">
			<tr>
				<td> <a href="productos?opcion=mostrarEditar&id=<c:out value="${producto.id}"></c:out>">  <c:out value="${producto.id}"></c:out></a>	</td>
				<td> <c:out value="${producto.nombre}"></c:out>	</td>
				<td> <c:out value="${producto.cantidad}"></c:out>	</td>
				<td> <c:out value="${producto.precio}"></c:out>	</td>
				<td> <c:out value="${producto.fechaCrear }"></c:out>	</td>
				<td> <c:out value="${producto.fechaActualizar }"></c:out>	</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>