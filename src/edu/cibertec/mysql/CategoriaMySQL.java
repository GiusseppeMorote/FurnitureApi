package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cibertec.beans.CategoriaBean;
import edu.cibertec.dao.CategoriaDAO;

public class CategoriaMySQL implements CategoriaDAO {

	@Override
	public ArrayList<CategoriaBean> getCategoriaAll() throws Exception {
		ArrayList<CategoriaBean> lista = new ArrayList<CategoriaBean>();
		CategoriaBean bean = null;
		String base = "furniture";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL_SELECT = "";

		try {
			connection = MysqlDAOFactory.obtenerConexion(base);
			SQL_SELECT = "select idCategoria,codigo,nombre,estado from categoria";
			ps = connection.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			System.out.println("SQL SELECT => " + SQL_SELECT);
			while (rs.next()) {
				bean = new CategoriaBean();
				bean.setIdCategoria(rs.getString(1));
				bean.setCodigo(rs.getString(2));
				bean.setNombre(rs.getString(3));
				bean.setEstado(rs.getString(4));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en getCategoria() ==> " + e.getMessage());
			e.getLocalizedMessage();
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}

		return lista;
	}

	@Override
	public ArrayList<CategoriaBean> getCategoriaEspecifica(String idCategoria) throws Exception {
		ArrayList<CategoriaBean> lista = new ArrayList<CategoriaBean>();
		CategoriaBean bean = null;
		String base = "furniture";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL_SELECT_FOR = "";
		try {
			connection = MysqlDAOFactory.obtenerConexion(base);
			SQL_SELECT_FOR = "select idCategoria,codigo,nombre,estado from categoria where idCategoria = ?";
			ps = connection.prepareStatement(SQL_SELECT_FOR);

			// String value = request.getParameter(idCategoria);
			ps.setString(1, idCategoria);
			System.out.println("SQL FOR => " + SQL_SELECT_FOR);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CategoriaBean();
				bean.setIdCategoria(rs.getString(1));
				bean.setCodigo(rs.getString(2));
				bean.setNombre(rs.getString(3));
				bean.setEstado(rs.getString(4));
				lista.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en getCategoriaEspecifica() ==> " + e.getMessage());
			e.getLocalizedMessage();
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}

		return lista;
	}

	@Override
	public int cantidadCategoria() throws Exception {
		int cant = 0;

		return cant;
	}

	private int validarExistenciaCategoria(String nombre) throws Exception {

		int cant = 0;
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String base = "furniture";
		Connection cn = null;

		try {
			cn = MysqlDAOFactory.obtenerConexion(base);
			sql = " select count(*) as cant from categoria where nombre = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, nombre);
			rs = ps.executeQuery();
			while (rs.next()) {
				cant = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("validarExistenciaCategoria => " + e.getMessage());
			cant = 0;
		} finally {
			rs.close();
			ps.close();
			cn.close();
		}

		return cant;
	}

	public static void main(String[] args) throws Exception {
		CategoriaMySQL d = new CategoriaMySQL();
		System.out.println(d.insertarCategoria("asd"));
	}

	@Override
	public int insertarCategoria(String nombre) throws Exception {
		int cant = 0;
		
		return cant;
	}

	@Override
	public CategoriaBean obtenerCategoria(String idCategoria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int desactivarCategoria(String idCategoria) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int activarCategoria(String idCategoria) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
