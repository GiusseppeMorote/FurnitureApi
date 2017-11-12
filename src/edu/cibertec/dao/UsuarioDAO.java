package edu.cibertec.dao;

import edu.cibertec.beans.UsuarioBean;

public interface UsuarioDAO {

	public UsuarioBean Credenciales(String email, String password) throws Exception;
	
	public int validarCredenciales(String email, String password) throws Exception;
	
	public int registrarUsuario(UsuarioBean b) throws Exception;
}
