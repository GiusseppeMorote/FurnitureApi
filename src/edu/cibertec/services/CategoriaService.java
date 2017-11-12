package edu.cibertec.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;



import edu.cibertec.beans.CategoriaBean;
import edu.cibertec.dao.CategoriaDAO;
import edu.cibertec.dao.DAOFactory;

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
			lista = categoriaService.getCategoriaAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en CategoriaService() - getCategoria()" + e.getMessage());
			e.getLocalizedMessage();
		}
		return lista;
	}

	// http://localhost:8080/ApiRestFurniture/categoria/getCategoriaEspecifica
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCategoriaEspecifica")
	public Response getCategoriaEspecifica(String idCategoria) {
//		System.out.println(json);
		List<CategoriaBean> lista = new ArrayList<>();
		try {
			
//			String x_idCategoria = json.getString("id");
			String cadenaId[] = idCategoria.split("=");
			String id = cadenaId[1];
			lista = categoriaService.getCategoriaEspecifica(id);
			
			
			System.out.println("idCategoria==>" + idCategoria);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en CategoriaService() - getCategoriaEspecifica()" + e.getMessage());
			e.getLocalizedMessage();
		}
		return Response.ok(lista).status(200).build();
	}
	
	// http://localhost:8080/ApiRestFurniture/categoria/getCategoriaEspecifica
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("getCategoriaEspecifica")
//	public Response getCategoriaEspecifica(JSONObject json) {
////		System.out.println(json);
//		List<CategoriaBean> lista = new ArrayList<>();
//		try {
//			
//			String x_idCategoria = json.getString("id");
//			lista = categoriaService.getCategoriaEspecifica(x_idCategoria);
//			System.out.println("idCategoria==>" + x_idCategoria);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println("Error en CategoriaService() - getCategoriaEspecifica()" + e.getMessage());
//			e.getLocalizedMessage();
//		}
//		return Response.ok(lista).status(200).build();
//	}
	// http://localhost:8080/ApiRestFurniture/categoria/getCategoriaEspecifica/{idCategoria}
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("getCategoriaEspecifica/{idCategoria}")
//	public Response getCategoriaEspecifica(@PathParam("idCategoria") String idCategoria) {
//
//		List<CategoriaBean> lista = new ArrayList<>();
//		try {
//
//			lista = categoriaService.getCategoriaEspecifica(idCategoria);
//			System.out.println("idCategoria==>" + idCategoria);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println("Error en CategoriaService() -getCategoriaEspecifica()" + e.getMessage());
//			e.getLocalizedMessage();
//		}
//		return Response.ok(lista).status(200).build();
//	}

}
