package edu.cibertec.dao;

import java.util.ArrayList;

import edu.cibertec.beans.TipoBean;

public interface TipoDAO {
	public ArrayList<TipoBean> getTipoAll() throws Exception;
}
