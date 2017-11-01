package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cibertec.beans.TipoBean;
import edu.cibertec.dao.TipoDAO;

public class TipoMySQL implements TipoDAO {

	@Override
	public ArrayList<TipoBean> getTipo() throws Exception {
		ArrayList<TipoBean> lista = new ArrayList<>();
		String base = "furniture";
		TipoBean bean = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select * from tipo";
			connection = MysqlDAOFactory.obtenerConexion(base);
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new TipoBean();				
				bean.setIdTipo(rs.getString(1));
				bean.setCodigo(rs.getString(2));
				bean.setNombre(rs.getString(3));
				bean.setIdCategoria(rs.getString(4));
				lista.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en getTipo() ==> " + e.getMessage());
			e.getLocalizedMessage();
		} finally {

		}

		return lista;
	}
	
	public static void main(String[] args) throws Exception {
		TipoMySQL metodo = new TipoMySQL();
		for (TipoBean lista : metodo.getTipo()) {
			System.out.println("lista ==> "+lista.getCodigo()+" "+lista.getIdTipo());
		}
	}

}
