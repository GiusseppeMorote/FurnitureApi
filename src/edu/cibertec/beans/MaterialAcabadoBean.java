package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MaterialAcabadoBean implements Serializable {
	private String idMaterialAcabado;
	private String codigo;
	private String nombre;
	private String estado;

	public MaterialAcabadoBean() {
		// TODO Auto-generated constructor stub
	}

	public MaterialAcabadoBean(String idMaterialAcabado, String codigo, String nombre, String estado) {
		this.idMaterialAcabado = idMaterialAcabado;
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public String getIdMaterialAcabado() {
		return idMaterialAcabado;
	}

	public void setIdMaterialAcabado(String idMaterialAcabado) {
		this.idMaterialAcabado = idMaterialAcabado;
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
