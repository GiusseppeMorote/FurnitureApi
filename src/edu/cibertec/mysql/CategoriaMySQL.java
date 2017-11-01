package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpServer;

import edu.cibertec.beans.CategoriaBean;
import edu.cibertec.dao.CategoriaDAO;

public class CategoriaMySQL implements CategoriaDAO {
	// obtengo mi
	HttpServletRequest request;

	@Override
	public ArrayList<CategoriaBean> getCategoria() throws Exception {
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

		}

		return lista;
	}

	// public static void main(String[] args) throws Exception {
	// CategoriaMySQL m = new CategoriaMySQL();
	// for (CategoriaBean lista : m.getCategoria()) {
	// System.out.println("lista=>" + lista.getCodigo());
	// }
	// }

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

//			String value = request.getParameter(idCategoria);
			ps.setString(1, idCategoria);

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

		}

		return lista;
	}

//	 public static void main(String[] args) throws Exception {
//	 CategoriaMySQL m = new CategoriaMySQL();
//	 for (CategoriaBean lista : m.getCategoriaEspecifica("2")) {
//	 System.out.println("lista=>" + lista.getCodigo());
//	 }
//	 }

}
