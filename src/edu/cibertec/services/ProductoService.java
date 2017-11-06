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

	//http://localhost:8080/ApiRestFurniture/producto/getProducto
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProducto")
	public ArrayList<ProductoBean> getProductos() {
		ArrayList<ProductoBean> lista = null;
		try {
			lista = objProducto.getProductosAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en ProductoService - getProductos");
		}
		return lista;
	}
	
	
	
	

}
