package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idCategoria;
	private String codigo;
	private String nombre;
	private String estado;

	public CategoriaBean() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaBean(String idCategoria, String codigo, String nombre, String estado) {
		this.idCategoria = idCategoria;
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
