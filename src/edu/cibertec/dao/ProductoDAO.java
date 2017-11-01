package edu.cibertec.dao;

import java.util.ArrayList;

import edu.cibertec.beans.ProductoBean;

public interface ProductoDAO {
	ArrayList<ProductoBean> getProductos() throws Exception;
}
