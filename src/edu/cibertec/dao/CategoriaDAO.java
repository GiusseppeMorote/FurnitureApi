package edu.cibertec.dao;

import java.util.ArrayList;

import org.json.JSONObject;

import edu.cibertec.beans.CategoriaBean;

public interface CategoriaDAO {
	ArrayList<CategoriaBean> getCategoria() throws Exception;
	
	ArrayList<CategoriaBean> getCategoriaEspecifica(String idCategoria) throws Exception;
}
