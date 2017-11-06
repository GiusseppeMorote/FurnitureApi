package edu.cibertec.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.cibertec.beans.TipoBean;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.dao.TipoDAO;

@Path("/tipo")
public class TipoService {

	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	TipoDAO tipoService = factory.getTipo();
	
	
	//http://localhost:8080/ApiRestFurniture/tipo/getTipo
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getTipo")
	public ArrayList<TipoBean> getTipo() {
		ArrayList<TipoBean> lista = null;
		try {
			lista = tipoService.getTipoAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en TipoServices() - getTipo()" + e.getMessage());
			e.getLocalizedMessage();
		}
		return lista;
	}	
}
