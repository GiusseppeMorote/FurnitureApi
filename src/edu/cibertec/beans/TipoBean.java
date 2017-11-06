package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idTipo;
	private String codigo;
	private String nombre;
	private CategoriaBean categoria;
	private String estado;

	public TipoBean() {
		// TODO Auto-generated constructor stub
	}
	

	public CategoriaBean getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaBean categoria) {
		this.categoria = categoria;
	}


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
