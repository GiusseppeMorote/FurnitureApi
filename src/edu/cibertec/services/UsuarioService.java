package edu.cibertec.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.cibertec.beans.UsuarioBean;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.dao.UsuarioDAO;

@Path("/login")
public class UsuarioService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO usuarioService = factory.getUsuarioDAO();
	

	// http://localhost:8080/ApiRestFurniture/login/CredencialUser?email=rampalonso_outlook.com&password=123
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("CredencialUser/{email}/{password}")
	public Response CredencialUser(String email, String password) throws Exception{
		UsuarioBean b = new UsuarioBean();
		System.out.println("EMAIL " + email + " PASS " + password );
		int valid = usuarioService.validarCredenciales(email, password);
		if(valid == 0){
			return Response.status(400).build();	
		} else{
			b = usuarioService.Credenciales(email, password);
			return Response.status(200).entity(b).build();
		}
		
	}
	

}
