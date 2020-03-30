package com.capacitacion.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capacitacion.crud.conexion.Conexion;
import com.capacitacion.crud.model.Producto;

public class ProductoDAO {

	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private boolean estadoOperacion;
	
	
	
	public Boolean createProduct(Producto producto) throws SQLException {
		
		String sql;
		estadoOperacion = false;
		
		try {
			connection = obtenerConexion();
			
			connection.setAutoCommit(false);
			
			sql = "INSERT INTO productos(id, nombre, cantidad, precio, fecha_crear, fecha_actualizar) VALUES(?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setDouble(3, producto.getCantidad());
			preparedStatement.setDouble(4, producto.getPrecio());
			preparedStatement.setDate(5, (Date) producto.getFechaCrear());
			preparedStatement.setDate(6, (Date) producto.getFechaActualizar());
			
			if(preparedStatement.executeUpdate() > 0) {
				estadoOperacion = true;
			}
			
			connection.commit();
			preparedStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean updateProduct(Producto producto) throws SQLException {
		
		estadoOperacion = false;
		String sql = null;
		
		try {
			connection = obtenerConexion();
			connection.setAutoCommit(false);
			
			sql = "UPDATE productos SET nombre = ?, cantidad = ?, precio = ?, fecha_actualizar = ? WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setDouble(2, producto.getCantidad());
			preparedStatement.setDouble(3, producto.getPrecio());
			preparedStatement.setDate(4, (Date) producto.getFechaActualizar());
			preparedStatement.setInt(5, producto.getId());
			
			estadoOperacion = preparedStatement.executeUpdate() > 0;
			
			connection.commit();
			preparedStatement.close();
			connection.close();
			
		}catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public Boolean deleteProduct(Integer id) throws SQLException {
		
		estadoOperacion = false;
		String sql = null;
		
		try {
			connection = obtenerConexion();
			connection.setAutoCommit(false);
			sql = "DELETE FROM productos WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			estadoOperacion = preparedStatement.executeUpdate(sql) > 0;
			connection.commit();
			preparedStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	public List<Producto> getProducts() throws SQLException {
		
		ResultSet resultSet = null;
		List<Producto> listaProductos = new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		
		try {			
			connection = obtenerConexion();
			
			sql = "SELECT * FROM productos";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				Producto producto = new Producto();
				
				producto.setId(resultSet.getInt(1));
				producto.setNombre(resultSet.getString(2));
				producto.setCantidad(resultSet.getDouble(3));
				producto.setPrecio(resultSet.getDouble(4));
				producto.setFechaCrear(resultSet.getDate(5));
				producto.setFechaActualizar(resultSet.getDate(6));
				
				listaProductos.add(producto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return listaProductos;
	}
	
	public Producto getProduct(Integer id) {
		
		Producto producto = new Producto();
		ResultSet resultSet = null;
		estadoOperacion = false;
		String sql = null;
		
		try {
			connection = obtenerConexion();
			sql = "SELECT * FROM productos WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery(sql);
			
			if(resultSet.next()) {
				
				producto.setId(resultSet.getInt(1));
				producto.setNombre(resultSet.getString(2));
				producto.setCantidad(resultSet.getDouble(3));
				producto.setPrecio(resultSet.getDouble(4));
				producto.setFechaCrear(resultSet.getDate(5));
				producto.setFechaActualizar(resultSet.getDate(6));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producto;
	}
	
	//OBTENER EL POOL DE CONEXION
	private Connection obtenerConexion() throws SQLException {	
		return Conexion.getConnection();
	}
}
