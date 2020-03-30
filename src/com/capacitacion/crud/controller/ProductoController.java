package com.capacitacion.crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("crear")) {
			
			System.out.println("Selecciono la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/crear.jsp");
			requestDispatcher.forward(request, response);
		}else {
			if(opcion.equals("listar")) {
				ProductoDAO productoDAO = new ProductoDAO();
				List<Producto> lista = new ArrayList<>();
				
				try {
					lista = productoDAO.getProducts();
					
					//IMPRIMO LOS PRODUCTOS EN CONSOLA
					for (Producto producto : lista) {
						System.out.println(producto);
					}
					
					/*SET ATTRIBUTE ENVIA DATOS AL JSP CON UNA CLAVE*/
					request.setAttribute("lista", lista);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/listar.jsp");
					requestDispatcher.forward(request, response);
				}catch (Exception e) {
					
				}
				
				
				System.out.println("Usted selecciono la opcion Listar");
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/listar.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();
		
		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		
		producto.setNombre(request.getParameter("nombre"));
		producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		
		/*SETEAMOS LA FECHA ACTUAL*/
		producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));
		
		try {
			productoDAO.createProduct(producto);
			System.out.println("Registro guardado satisfactoriamente");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
