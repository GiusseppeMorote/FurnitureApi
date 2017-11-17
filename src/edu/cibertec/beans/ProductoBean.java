package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idProducto;
	private String codigo;
	private String nombre;
	private String imagen;
	private String precio;
	private String descuento;
	private String stockMinimo;
	private String stockActual;
	private String garantia;
	private String recomendacion;
	private String fechaRegistro;
	private String color;

	// private String idTipo;
	// private String nombreTipo;
	// private String idMarca;
	// private String nombreMarca;
	// private String idMaterial;
	// private String nombreMaterial;
	private TipoBean tipo;
	private MarcaBean marca;
	private MaterialBean material;

	private String alto;
	private String ancho;
	private String peso;

	private String cantidadCajas;
	private String numeroPuertas;
	private String cantidadPersonas;
	private String resistencia;
	private String apoyaBrazos;
	private String reclinable;
	private String espesor;

	private String estado;

	public ProductoBean() {
		
	}

	public TipoBean getTipo() {
		return tipo;
	}

	public void setTipo(TipoBean tipo) {
		this.tipo = tipo;
	}

	public MarcaBean getMarca() {
		return marca;
	}

	public void setMarca(MarcaBean marca) {
		this.marca = marca;
	}

	public MaterialBean getMaterial() {
		return material;
	}

	public void setMaterial(MaterialBean material) {
		this.material = material;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(String stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public String getStockActual() {
		return stockActual;
	}

	public void setStockActual(String stockActual) {
		this.stockActual = stockActual;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAlto() {
		return alto;
	}

	public void setAlto(String alto) {
		this.alto = alto;
	}

	public String getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getCantidadCajas() {
		return cantidadCajas;
	}

	public void setCantidadCajas(String cantidadCajas) {
		this.cantidadCajas = cantidadCajas;
	}

	public String getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(String numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	public String getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(String cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getResistencia() {
		return resistencia;
	}

	public void setResistencia(String resistencia) {
		this.resistencia = resistencia;
	}

	public String getApoyaBrazos() {
		return apoyaBrazos;
	}

	public void setApoyaBrazos(String apoyaBrazos) {
		this.apoyaBrazos = apoyaBrazos;
	}

	public String getReclinable() {
		return reclinable;
	}

	public void setReclinable(String reclinable) {
		this.reclinable = reclinable;
	}

	public String getEspesor() {
		return espesor;
	}

	public void setEspesor(String espesor) {
		this.espesor = espesor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
