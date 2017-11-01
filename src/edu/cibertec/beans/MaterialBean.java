package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class MaterialBean implements Serializable{
	private String idMaterial;
	private String codigo;
	private String nombre;
	private String estado;
	
	public MaterialBean() {
		// TODO Auto-generated constructor stub
	}
	
	public MaterialBean(String idMaterial,String codigo,String nombre,String estado) {
		this.idMaterial=idMaterial;
		this.codigo=codigo;
		this.nombre=nombre;
		this.estado=estado;
	}
	public String getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(String idMaterial) {
		this.idMaterial = idMaterial;
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
