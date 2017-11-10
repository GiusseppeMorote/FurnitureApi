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

	public static void main(String[] args) throws Exception {
		CategoriaMySQL d = new CategoriaMySQL();
		ArrayList<CategoriaBean> lista = d.getCategoriaEspecifica("1");
		for(CategoriaBean b : lista){
			System.out.println(b.getIdCategoria() + " / " + b.getNombre());
		}
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
}
