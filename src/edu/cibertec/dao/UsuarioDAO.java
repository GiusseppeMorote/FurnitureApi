package edu.cibertec.dao;

import edu.cibertec.beans.UsuarioBean;

public interface UsuarioDAO {

	public UsuarioBean Credenciales(UsuarioBean b) throws Exception;
	
	public int validarCredenciales(UsuarioBean b) throws Exception;
	
	public int registrarUsuario(UsuarioBean b) throws Exception;
}
