package com.capacitacion.crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capacitacion.crud.dao.ProductoDAO;
import com.capacitacion.crud.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/productos" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		if (opcion != null) {

			switch (opcion) {
			case "crear":
				redireccionaACrearProducto(request, response);
				break;

			case "listar":
				mostrarProductos(request, response);
				break;

			case "mostrarEditar":
				mostrarProducto(request, response);
				break;

			case "eliminar":
				eliminarProducto(request, response);
				break;
				
			default:
				break;
			}
		}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		ProductoDAO productoDAO = new ProductoDAO();

		try {
			productoDAO.deleteProduct(id);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void mostrarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		try {
			producto = productoDAO.getProduct(id);
			request.setAttribute("producto", producto);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
			requestDispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void mostrarProductos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductoDAO productoDAO = new ProductoDAO();
		List<Producto> listaProducto = new ArrayList<>();

		try {
			listaProducto = productoDAO.getProducts();
			request.setAttribute("lista", listaProducto);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
			requestDispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void redireccionaACrearProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		try {
			switch (opcion) {
			case "guardar":
				guardarProducto(request, response);
				break;

			case "editar":
				editarProducto(request, response);				
				
				break;
			default:
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	private void editarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		Date fechaActual = new Date();
		
		producto.setId(Integer.parseInt(request.getParameter("id")));
		producto.setNombre(request.getParameter("nombre"));
		producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		producto.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
		
		try {
			productoDAO.updateProduct(producto);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private void guardarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		Date fechaActual = new Date();

		producto.setNombre(request.getParameter("nombre"));
		producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));

		try {
			productoDAO.createProduct(producto);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
