package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.cibertec.beans.UsuarioBean;
import edu.cibertec.dao.UsuarioDAO;

public class UsuarioMySQL implements UsuarioDAO {

//	public static void main(String[] args) throws Exception {
//		UsuarioMySQL d = new UsuarioMySQL();
//		System.out.println(d.Credenciales("ramp_alonso@outlook.com", "123"));
//	}

	@Override
	public int validarCredenciales(String email, String password) throws Exception {
		int dato = 0;
		Connection cn = MysqlDAOFactory.obtenerConexion("furniture");
		String sql = " select count(*) as cant from usuario a where a.email = ? and a.clave = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		rs.next();
		dato = rs.getInt("cant");
		rs.close();
		ps.close();
		cn.close();
		return dato;
	}

	@Override
	public UsuarioBean Credenciales(String email, String password) throws Exception {
		UsuarioBean b =  new UsuarioBean();
		String base = "furniture";
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cn = null;

		try {
			cn = MysqlDAOFactory.obtenerConexion(base);
			sql = " select idUsuario, nickname, email, clave, fechaRegistro, "
					+ " tipo, nombre, apellido, dni, fechaNacimiento, telefono, direccion, estado from usuario a "
					+ " where a.email = ?  and a.clave = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			rs.next();
			int i = 1;
			b.setIdUsuario(rs.getString(i++));
			b.setNickname(rs.getString(i++));
			b.setEmail(rs.getString(i++));
			b.setClave(rs.getString(i++));
			b.setFechaRegistro(rs.getString(i++));
			b.setTipo(rs.getString(i++));
			b.setNombre(rs.getString(i++));
			b.setApellido(rs.getString(i++));
			b.setDni(rs.getString(i++));
			b.setFechaNacimiento(rs.getString(i++));
			b.setTelefono(rs.getString(i++));
			b.setDireccion(rs.getString(i++));
			b.setEstado(rs.getString(i++));

		} catch (Exception e) {
			System.out.println("Error Credenciales() => " + e.getMessage());
		} finally {
			rs.close();
			ps.close();
			cn.close();
		}
		return b;
	}

	@Override
	public int registrarUsuario(UsuarioBean b) throws Exception {
		int dato = 0;
		return dato;
	}

}
