package edu.cibertec.dao;

import java.util.ArrayList;


import edu.cibertec.beans.CategoriaBean;

public interface CategoriaDAO {

	public ArrayList<CategoriaBean> getCategoriaAll() throws Exception;

	public ArrayList<CategoriaBean> getCategoriaEspecifica(String idCategoria) throws Exception;
}
