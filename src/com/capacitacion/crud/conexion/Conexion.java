package com.capacitacion.crud.conexion;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {

	private static BasicDataSource dataSource = null;
	
	private static DataSource getDataSource() {
		
		if(dataSource == null) {
			
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("vamospormas");
			dataSource.setUrl("jdbc:mysql://localhost:3306/crud?useTimezone=true&serverTimezone=UTC&useSSL=false");
			
			//INICIA EL DATASOURCE
			dataSource.setInitialSize(20);
			//15 MINIMAS EN EL POOL DE CONEXIONES
			dataSource.setMaxIdle(15);
			//MAXIMAS CONEXIONES
			dataSource.setMaxTotal(20);
			//TIEMPO PARA CAMBIAR EL POOL DE CONEXION, EN MILISEGUNDOS
			dataSource.setMaxWaitMillis(5000);
		}
		
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
}
