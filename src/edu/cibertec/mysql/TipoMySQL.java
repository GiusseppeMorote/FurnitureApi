package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cibertec.beans.CategoriaBean;
import edu.cibertec.beans.TipoBean;
import edu.cibertec.dao.TipoDAO;

public class TipoMySQL implements TipoDAO {

	@Override
	public ArrayList<TipoBean> getTipoAll() throws Exception {
		ArrayList<TipoBean> lista = new ArrayList<>();
		String base = "furniture";
		TipoBean bean = null;
		CategoriaBean categoria = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select a.idTipo, a.codigo, a.nombre, a.idCategoria, "
					+ "b.codigo, b.nombre, b.estado, a.estado "
					+ "from tipo a inner join categoria b "
					+ "on a.idCategoria = b.idCategoria";
			connection = MysqlDAOFactory.obtenerConexion(base);
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new TipoBean();
				categoria = new CategoriaBean();
				int i = 1;
				bean.setIdTipo(rs.getString(i++));
				bean.setCodigo(rs.getString(i++));
				bean.setNombre(rs.getString(i++));
				
				categoria.setIdCategoria(rs.getString(i++));
				categoria.setCodigo(rs.getString(i++));
				categoria.setNombre(rs.getString(i++));
				categoria.setEstado(rs.getString(i++));
				bean.setCategoria(categoria);
				
				bean.setEstado(rs.getString(i++));
				
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
	
//	public static void main(String[] args) throws Exception {
//		TipoMySQL metodo = new TipoMySQL();
//		for (TipoBean lista : metodo.getTipoAll()) {
//			System.out.println("lista ==> "+lista.getCodigo()+" "+lista.getIdTipo() + " " + lista.getCategoria().getNombre());
//		}
//	}

}
