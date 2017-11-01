package edu.cibertec.dao;

import edu.cibertec.mysql.MysqlDAOFactory;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	// public static final int ORACLE = 2;	
	// public static final int SQLSERVER = 3;
	

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MysqlDAOFactory();
		
		default:
			return null;
		}
	}
	
	public abstract TipoDAO getTipo();
	
	public abstract CategoriaDAO getCategoria();
	
	public abstract ProductoDAO getProducto();
}
