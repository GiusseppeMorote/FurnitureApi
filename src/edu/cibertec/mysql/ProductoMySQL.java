package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cibertec.beans.CategoriaBean;
import edu.cibertec.beans.MarcaBean;
import edu.cibertec.beans.MaterialBean;
import edu.cibertec.beans.ProductoBean;
import edu.cibertec.beans.TipoBean;
import edu.cibertec.dao.ProductoDAO;
import sun.net.www.content.image.x_xpixmap;

public class ProductoMySQL implements ProductoDAO {

	@Override
	public ArrayList<ProductoBean> getProductoPorTipo(String idTipo) throws Exception {
		ArrayList<ProductoBean> lista = new ArrayList<>();
		MarcaBean marca = null;
		MaterialBean material = null;
		TipoBean tipo = null;
		ProductoBean bean = null;
		String base = "furniture";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL_SELECT = "";

		try {
			connection = MysqlDAOFactory.obtenerConexion(base);
			SQL_SELECT = " select a.idProducto, a.codigo, a.nombre, a.imagen, a.precio, "
					+ " a.descuento, a.stockMinimo, a.stockActual, a.garantia, a.recomendacion, "
					+ " a.fechaRegistro, a.color, a.idTipo, b.codigo, b.nombre, b.estado, a.idMarca, "
					+ " c.codigo, c.nombre, c.estado, a.idMaterial, d.codigo, d.nombre, d.estado, a.alto, a.ancho, "
					+ " a.peso, a.cantidadCajas, a.numeroPuertas, a.cantidadPersonas, a.resistencia, "
					+ " a.apoyaBrazos, a.reclinable, a.espesor, a.estado " + " from producto a inner join tipo b "
					+ " on a.idTipo=b.idTipo inner join marca c" + " on a.idMarca=c.idMarca inner join material d "
					+ " on a.idMaterial=d.idMaterial " + " where a.idTipo = ?";
			ps = connection.prepareStatement(SQL_SELECT);
			ps.setString(1, idTipo);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new ProductoBean();

				tipo = new TipoBean();
				marca = new MarcaBean();
				material = new MaterialBean();

				int i = 1;

				bean.setIdProducto(rs.getString(i++));
				bean.setCodigo(rs.getString(i++));
				bean.setNombre(rs.getString(i++));
				bean.setImagen(rs.getString(i++));
				bean.setPrecio(rs.getString(i++));
				bean.setDescuento(rs.getString(i++));
				bean.setStockMinimo(rs.getString(i++));
				bean.setStockActual(rs.getString(i++));
				bean.setGarantia(rs.getString(i++));
				bean.setRecomendacion(rs.getString(i++));
				bean.setFechaRegistro(rs.getString(i++));
				bean.setColor(rs.getString(i++));

				tipo.setIdTipo(rs.getString(i++));
				tipo.setCodigo(rs.getString(i++));
				tipo.setNombre(rs.getString(i++));
				tipo.setEstado(rs.getString(i++));
				bean.setTipo(tipo);

				marca.setIdMarca(rs.getString(i++));
				marca.setCodigo(rs.getString(i++));
				marca.setNombre(rs.getString(i++));
				marca.setEstado(rs.getString(i++));
				bean.setMarca(marca);

				material.setIdMaterial(rs.getString(i++));
				material.setCodigo(rs.getString(i++));
				material.setNombre(rs.getString(i++));
				material.setEstado(rs.getString(i++));
				bean.setMaterial(material);

				bean.setAlto(rs.getString(i++));
				bean.setAncho(rs.getString(i++));
				bean.setPeso(rs.getString(i++));
				bean.setCantidadCajas(rs.getString(i++));
				bean.setNumeroPuertas(rs.getString(i++));
				bean.setCantidadPersonas(rs.getString(i++));
				bean.setResistencia(rs.getString(i++));
				bean.setApoyaBrazos(rs.getString(i++));
				bean.setReclinable(rs.getString(i++));
				bean.setEspesor(rs.getString(i++));
				bean.setEstado(rs.getString(i++));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en getProductos() ==> " + e.getMessage());
			e.getLocalizedMessage();
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}

		return lista;
	}

	@Override
	public ArrayList<ProductoBean> getProductosAll(String letter) throws Exception {
		ArrayList<ProductoBean> lista = new ArrayList<>();
		MarcaBean marca = null;
		MaterialBean material = null;
		TipoBean tipo = null;
		ProductoBean bean = null;
		CategoriaBean categoria = null;
		String base = "furniture";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL_SELECT = "";

		String x_forSale = "";
		String x_now = "";
		String x_popular = "";
		try {
			connection = MysqlDAOFactory.obtenerConexion(base);
			if (letter.equals("a")) {
				x_forSale = "";
			} else if (letter.equals("b")) {
				x_now = " order by a.fechaRegistro desc ";
			} else if (letter.equals("c")) {
				x_popular = " where a.stockActual <=25 ";
			} else {
				x_forSale = "";
				x_now = "";
				x_popular = "";
			}
			SQL_SELECT = " select a.idProducto, a.codigo, a.nombre, a.imagen, a.precio, "
					+ " a.descuento, a.stockMinimo, a.stockActual, a.garantia, a.recomendacion, "
					+ " a.fechaRegistro, a.color, a.idTipo, b.codigo, b.nombre, b.estado, "
					+ " b.idCategoria,e.codigo,e.nombre,e.estado, a.idMarca, "
					+ " c.codigo, c.nombre, c.estado, a.idMaterial, d.codigo, d.nombre, d.estado, a.alto, a.ancho, "
					+ " a.peso, a.cantidadCajas, a.numeroPuertas, a.cantidadPersonas, a.resistencia, "
					+ " a.apoyaBrazos, a.reclinable, a.espesor, a.estado " + " from producto a inner join tipo b "
					+ " on a.idTipo=b.idTipo inner join marca c" + " on a.idMarca=c.idMarca inner join material d "
					+ " on a.idMaterial=d.idMaterial inner join categoria e" + " on b.idCategoria = e.idCategoria "
					+ x_forSale + " " + x_now + " " + x_popular + " ";
//			System.out.println("SQL => " + SQL_SELECT);
			ps = connection.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new ProductoBean();

				tipo = new TipoBean();
				marca = new MarcaBean();
				material = new MaterialBean();
				categoria = new CategoriaBean();
				int i = 1;

				bean.setIdProducto(rs.getString(i++));
				bean.setCodigo(rs.getString(i++));
				bean.setNombre(rs.getString(i++));
				bean.setImagen(rs.getString(i++));
				bean.setPrecio(rs.getString(i++));
				bean.setDescuento(rs.getString(i++));
				bean.setStockMinimo(rs.getString(i++));
				bean.setStockActual(rs.getString(i++));
				bean.setGarantia(rs.getString(i++));
				bean.setRecomendacion(rs.getString(i++));
				bean.setFechaRegistro(rs.getString(i++));
				bean.setColor(rs.getString(i++));

				tipo.setIdTipo(rs.getString(i++));
				tipo.setCodigo(rs.getString(i++));
				tipo.setNombre(rs.getString(i++));
				tipo.setEstado(rs.getString(i++));
				categoria.setIdCategoria(rs.getString(i++));
				categoria.setCodigo(rs.getString(i++));
				categoria.setNombre(rs.getString(i++));
				categoria.setEstado(rs.getString(i++));
				tipo.setCategoria(categoria);
				bean.setTipo(tipo);

				marca.setIdMarca(rs.getString(i++));
				marca.setCodigo(rs.getString(i++));
				marca.setNombre(rs.getString(i++));
				marca.setEstado(rs.getString(i++));
				bean.setMarca(marca);

				material.setIdMaterial(rs.getString(i++));
				material.setCodigo(rs.getString(i++));
				material.setNombre(rs.getString(i++));
				material.setEstado(rs.getString(i++));
				bean.setMaterial(material);

				bean.setAlto(rs.getString(i++));
				bean.setAncho(rs.getString(i++));
				bean.setPeso(rs.getString(i++));
				bean.setCantidadCajas(rs.getString(i++));
				bean.setNumeroPuertas(rs.getString(i++));
				bean.setCantidadPersonas(rs.getString(i++));
				bean.setResistencia(rs.getString(i++));
				bean.setApoyaBrazos(rs.getString(i++));
				bean.setReclinable(rs.getString(i++));
				bean.setEspesor(rs.getString(i++));
				bean.setEstado(rs.getString(i++));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en getProductos() ==> " + e.getMessage());
			e.getLocalizedMessage();
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}

		return lista;
	}

	// public static void main(String[] args) throws Exception {
	// ProductoMySQL p = new ProductoMySQL();
	//
	// // for sale - now - popular
	// for (ProductoBean lista : p.getProductosAll("", "", "")) {
	// System.out.println(lista.getCodigo() + " / " + lista.getNombre() + " / "
	// + lista.getTipo().getIdTipo()
	// + " / " + lista.getTipo().getNombre() + " / " +
	// lista.getTipo().getCategoria().getNombre());
	// }
	// }

}
