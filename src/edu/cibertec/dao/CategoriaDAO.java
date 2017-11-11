package edu.cibertec.dao;

import java.util.ArrayList;


import edu.cibertec.beans.CategoriaBean;

public interface CategoriaDAO {

	public ArrayList<CategoriaBean> getCategoriaAll() throws Exception;
	public ArrayList<CategoriaBean> getCategoriaEspecifica(String idCategoria) throws Exception;
	
	public CategoriaBean obtenerCategoria(String idCategoria) throws Exception;
	public int cantidadCategoria() throws Exception;
	
	public int insertarCategoria (String nombre) throws Exception;
	public int desactivarCategoria (String idCategoria) throws Exception;
	public int activarCategoria (String idCategoria) throws Exception;
}
