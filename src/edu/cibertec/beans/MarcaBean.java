package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class MarcaBean implements Serializable {
	private String idMarca;
	private String codigo;
	private String nombre;
	private String estado;
	
	public MarcaBean() {
		// TODO Auto-generated constructor stub
	}
	
	public MarcaBean(String idMarca,String codigo,String nombre,String estado) {
		this.idMarca=idMarca;
		this.codigo=codigo;
		this.nombre=nombre;
		this.estado=estado;
	}
	
	public String getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
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
