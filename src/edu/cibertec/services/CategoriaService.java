package edu.cibertec.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import edu.cibertec.beans.CategoriaBean;
import edu.cibertec.dao.CategoriaDAO;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.parameter.MyJaxBean;

@Path("/categoria")
public class CategoriaService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	CategoriaDAO categoriaService = factory.getCategoria();

	// http://localhost:8080/ApiRestFurniture/categoria/getCategoria
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCategoria")
	public ArrayList<CategoriaBean> getCategoria() {
		ArrayList<CategoriaBean> lista = null;
		try {
			lista = categoriaService.getCategoria();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en CategoriaService() - getCategoria()" + e.getMessage());
			e.getLocalizedMessage();
		}
		return lista;
	}

	// http://localhost:8080/ApiRestFurniture/categoria/getCategoriaEspecifica
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCategoriaEspecifica")
	public ArrayList<CategoriaBean> getCategoriaEspecifica(final MyJaxBean input) {
		System.out.println("param1 = " + input.param1);
//	    System.out.println("param2 = " + input.param2);
		ArrayList<CategoriaBean> lista = null;
//		try {
//
//			lista = categoriaService.getCategoriaEspecifica(idCategoria);
//			System.out.println("idCategoria==>" + idCategoria);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println("Error en CategoriaService() - getCategoriaEspecifica()" + e.getMessage());
//			e.getLocalizedMessage();
//		}
		return lista;
	}

}
