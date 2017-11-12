package edu.cibertec.dao;

import java.util.ArrayList;

import edu.cibertec.beans.ProductoBean;

public interface ProductoDAO {
	
	public ArrayList<ProductoBean> getProductosAll(String forSale, String now, String popular) throws Exception;
	public ArrayList<ProductoBean> getProductoPorTipo(String idTipo) throws Exception;
	
	
	
}
