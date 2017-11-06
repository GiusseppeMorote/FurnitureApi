package edu.cibertec.dao;

import java.util.ArrayList;

import edu.cibertec.beans.ProductoBean;

public interface ProductoDAO {
	
	public ArrayList<ProductoBean> getProductosAll() throws Exception;
	public ArrayList<ProductoBean> getProductoPorTipo(String idTipo) throws Exception;
	
}
