package edu.cibertec.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cibertec.beans.CategoriaBean;
import edu.cibertec.beans.MarcaBean;
import edu.cibertec.beans.MaterialAcabadoBean;
import edu.cibertec.beans.MaterialBean;
import edu.cibertec.beans.ProductoBean;
import edu.cibertec.beans.TipoBean;
import edu.cibertec.dao.ProductoDAO;

public class ProductoMySQL implements ProductoDAO {

	@Override
	public ArrayList<ProductoBean> getProductos() throws Exception {
		ArrayList<ProductoBean> lista = new ArrayList<>();
		MarcaBean beanMarca = null;
		MaterialAcabadoBean beanMaterialAcabada = null;
		MaterialBean beanMaterial = null;
		TipoBean tipo = null;
		ProductoBean bean = null;
		String base = "furniture";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL_SELECT = "";

		try {
			connection = MysqlDAOFactory.obtenerConexion(base);
			SQL_SELECT = "select * from producto";
			ps = connection.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProductoBean();

				tipo = new TipoBean();
				beanMarca = new MarcaBean();
				beanMaterial = new MaterialBean();
				beanMaterialAcabada = new MaterialAcabadoBean();

				bean.setIdProducto(rs.getString(1));
				bean.setCodigoProducto(rs.getString(2));
				bean.setNombreProducto(rs.getString(3));
				bean.setImagenProducto(rs.getString(4));
				bean.setPrecioProducto(rs.getString(5));
				bean.setStockMinimoProducto(rs.getString(6));
				bean.setStockActualProducto(rs.getString(7));
				bean.setGarantiaProducto(rs.getString(8));
				bean.setRecomendacionProducto(rs.getString(9));
				bean.setFechaRegistroProducto(rs.getString(10));
				bean.setColor(rs.getString(11));
				bean.setDescuento(rs.getString(12));

				tipo.setIdTipo(rs.getString(13));
				bean.setTipo(tipo);

				beanMarca.setIdMarca(rs.getString(14));
				bean.setMarca(beanMarca);

				beanMaterial.setIdMaterial(rs.getString(15));
				bean.setMaterial(beanMaterial);

				beanMaterialAcabada.setIdMaterialAcabado(rs.getString(16));
				bean.setMaterialAcabado(beanMaterialAcabada);

				bean.setAltoProducto(rs.getString(16));
				bean.setAnchoProducto(rs.getString(17));
				bean.setPesoProducto(rs.getString(18));
				bean.setCantidadCajas(rs.getString(19));
				bean.setCantidadPersonas(rs.getString(20));
				bean.setResistencia(rs.getString(21));
				bean.setApoyaBrazos(rs.getString(22));
				bean.setReclinable(rs.getString(23));
				bean.setEspesor(rs.getString(24));
				bean.setEstadoProducto(rs.getString(25));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en getProductos() ==> " + e.getMessage());
			e.getLocalizedMessage();
		} finally {

		}

		return lista;
	}

	public static void main(String[] args) throws Exception {
		ProductoMySQL p = new ProductoMySQL();

		for (ProductoBean lista : p.getProductos()) {
			System.out.println(lista.getCodigoProducto() + " " + lista.getNombreProducto());
		}
	}

}
