package edu.cibertec.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.cibertec.beans.ProductoBean;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.dao.ProductoDAO;

@Path("producto")
public class ProductoService {

	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProductoDAO objProducto = factory.getProducto();

	// http://localhost:8080/ApiRestFurniture/producto/getProductosForSale
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProductosForSale")
	public ArrayList<ProductoBean> getProductosForSale() {
		ArrayList<ProductoBean> lista = null;
		try {
			lista = objProducto.getProductosAll("a");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en ProductoService - getProductos");
		}
		return lista;
	}

	// http://localhost:8080/ApiRestFurniture/producto/getProductosNow
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProductosNow")
	public ArrayList<ProductoBean> getProductosNow() {
		ArrayList<ProductoBean> lista = null;
		try {
			lista = objProducto.getProductosAll("b");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en ProductoService - getProductos");
		}
		return lista;
	}

	// http://localhost:8080/ApiRestFurniture/producto/getProductosPopular
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProductosPopular")
	public ArrayList<ProductoBean> getProductosPopular() {
		ArrayList<ProductoBean> lista = null;
		try {
			lista = objProducto.getProductosAll("c");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en ProductoService - getProductos");
		}
		return lista;
	}

}
