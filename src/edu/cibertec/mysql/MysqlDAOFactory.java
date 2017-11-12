package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.cibertec.dao.CategoriaDAO;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.dao.ProductoDAO;
import edu.cibertec.dao.TipoDAO;
import edu.cibertec.dao.UsuarioDAO;

public class MysqlDAOFactory extends DAOFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static Connection obtenerConexion(String nombre_bd) {
		Connection conexion = null;
		if (nombre_bd.equals("furniture")) {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture", "root", "mysql");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conexion;
	}

	@Override
	public TipoDAO getTipo() {
		return new TipoMySQL();
	}

	@Override
	public CategoriaDAO getCategoria() {
		return new CategoriaMySQL();
	}

	@Override
	public ProductoDAO getProducto() {
		return new ProductoMySQL();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioMySQL();
	}
}
