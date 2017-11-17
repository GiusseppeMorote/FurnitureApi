package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.cibertec.beans.UsuarioBean;
import edu.cibertec.dao.UsuarioDAO;

public class UsuarioMySQL implements UsuarioDAO {

	@Override
	public int validarCredenciales(UsuarioBean b) throws Exception {
		int dato = 0;
		Connection cn = MysqlDAOFactory.obtenerConexion("furniture");
		String sql = " select count(*) as cant from usuario a where a.email = ? and a.clave = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, b.getEmail());
		ps.setString(2, b.getClave());
		ResultSet rs = ps.executeQuery();
		rs.next();
		dato = rs.getInt("cant");
		rs.close();
		ps.close();
		cn.close();
		return dato;
	}

	@Override
	public UsuarioBean Credenciales(UsuarioBean bean) throws Exception {
		UsuarioBean b = new UsuarioBean();
		String base = "furniture";
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cn = null;

		try {
			cn = MysqlDAOFactory.obtenerConexion(base);
			sql = " select idUsuario, email, clave, fechaRegistro, "
					+ " tipo, nombre, apellido, dni, fechaNacimiento, telefono, direccion, estado from usuario a "
					+ " where a.email = ?  and a.clave = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, bean.getEmail());
			ps.setString(2, bean.getClave());
			rs = ps.executeQuery();
			rs.next();
			int i = 1;
			b.setIdUsuario(rs.getString(i++));
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

	private int validateExistencedUser(String email) throws Exception {
		int cant = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cn = null;
		String sql = "";
		String base = "furniture";

		try {
			cn = MysqlDAOFactory.obtenerConexion(base);
			sql = " select count(*) as cant from usuario a  where a.email = ? ";
			ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				cant = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("validateExistencedUser => " + e.getMessage());
		} finally {
			ps.close();
			rs.close();
			cn.close();
		}

		return cant;
	}

	public static void main(String[] args) throws Exception {
		UsuarioMySQL u = new UsuarioMySQL();
		System.out.println(
				u.registrarUsuario(new UsuarioBean("giovvani@gmail.com", "", "", "", "", "", "", "", "", "", "")));
	}

	@Override
	public int registrarUsuario(UsuarioBean b) throws Exception {
		int dato = 0;
		PreparedStatement ps = null;
		Connection cn = null;
		String sql = "";
		String base = "furniture";
//		System.out.println(b.getEmail());
//		{
//			"email":"yefrioscar@gmail.com",
//			"clave":"123",
//			"nombre":"yefri",
//			"apellido":"laura",
//			"dni":"12345678",
//			"fechaNacimiento":"1997-04-02",
//			"telefono":"98745245",
//			"direccion":"cerro san cristobal"
//		}
		if (validateExistencedUser(b.getEmail()) == 0) {
			cn = MysqlDAOFactory.obtenerConexion(base);
			sql = " insert into usuario ( email,clave,fechaRegistro,tipo,nombre,apellido,dni,fechaNacimiento,telefono,direccion,estado) "
					+ " values (?,?,now(),?,?,?,?,?,?,?,?) ";
			ps = cn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, b.getEmail());
			ps.setString(i++, b.getClave());
			ps.setString(i++, "C");
			ps.setString(i++, b.getNombre());
			ps.setString(i++, b.getApellido());
			ps.setString(i++, b.getDni());
			ps.setString(i++, b.getFechaNacimiento());
			ps.setString(i++, b.getTelefono());
			ps.setString(i++, b.getDireccion());
			ps.setInt(i++, 1);
			dato = ps.executeUpdate();
//			cn.commit();
			ps.close();
			cn.close();
		} else {
			dato = 2; // email repetido
		}

		return dato;
	}

}
