package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoBean implements Serializable {
	
	private String idTipo;
	private String codigo;
	private String nombre;
	private String idCategoria;
	
	public TipoBean() {
		// TODO Auto-generated constructor stub
	}
	public TipoBean(String idTipo,String codigo,String nombre,String idCategoria) {
		this.idTipo = idTipo;
		this.codigo=codigo;
		this.nombre=nombre;
		this.idCategoria=idCategoria;
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
	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
}
