package edu.cibertec.dao;

import java.util.ArrayList;

import edu.cibertec.beans.TipoBean;

public interface TipoDAO {
	ArrayList<TipoBean> getTipo() throws Exception;
}
