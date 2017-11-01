package edu.cibertec.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductoBean implements Serializable {
	private String idProducto;
	private String codigoProducto;
	private String nombreProducto;
	private String imagenProducto;
	private String precioProducto;
	private String stockMinimoProducto;
	private String stockActualProducto;
	private String garantiaProducto;
	private String recomendacionProducto;
	private String fechaRegistroProducto;

	private String color;
	private String descuento;

	private TipoBean tipo;
	private MarcaBean marca;
	private MaterialBean material;
	private MaterialAcabadoBean materialAcabado;

	private String altoProducto;
	private String anchoProducto;
	private String pesoProducto;
	private String cantidadCajas;
	private String numeroPuertas;
	private String cantidadPersonas;
	private String resistencia;
	private String apoyaBrazos;
	private String reclinable;
	private String espesor;
	private String estadoProducto;

	public ProductoBean() {
		// TODO Auto-generated constructor stub
	}

	public ProductoBean(String idProducto, String codigoProducto, String nombreProducto, String imagenProducto,
			String precioProducto, String stockMinimoProducto, String stockActualProducto, String garantiaProducto,
			String recomendacionProducto, String fecharegistroProducto, String color, String descuento, TipoBean tipo,
			MarcaBean marca, MaterialBean material, MaterialAcabadoBean materialAcabado, String altoProducto,
			String anchoProducto, String pesoProducto, String cantidadCajas, String numeroPuertas,
			String cantidadPersonas, String resistencia, String apoyaBrazos, String reclinable, String espesor,
			String estadoProducto) {
		this.idProducto = idProducto;
		this.codigoProducto=codigoProducto;
		this.imagenProducto=imagenProducto;
		this.precioProducto=precioProducto;
		this.stockMinimoProducto=stockMinimoProducto;
		this.stockActualProducto=stockActualProducto;
		this.garantiaProducto=garantiaProducto;
		this.recomendacionProducto=recomendacionProducto;
		this.fechaRegistroProducto=fecharegistroProducto;
		this.color=color;
		this.descuento=descuento;
		this.tipo=tipo;
		this.marca=marca;
		this.material=material;
		this.materialAcabado=materialAcabado;
		this.altoProducto=altoProducto;
		this.anchoProducto=anchoProducto;
		this.pesoProducto=pesoProducto;
		this.cantidadCajas=cantidadCajas;
		this.numeroPuertas=numeroPuertas;
		this.cantidadPersonas=cantidadPersonas;
		this.resistencia=resistencia;
		this.apoyaBrazos=apoyaBrazos;
		this.reclinable=reclinable;
		this.espesor=espesor;
		this.estadoProducto=estadoProducto;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public String getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getStockMinimoProducto() {
		return stockMinimoProducto;
	}

	public void setStockMinimoProducto(String stockMinimoProducto) {
		this.stockMinimoProducto = stockMinimoProducto;
	}

	public String getStockActualProducto() {
		return stockActualProducto;
	}

	public void setStockActualProducto(String stockActualProducto) {
		this.stockActualProducto = stockActualProducto;
	}

	public String getGarantiaProducto() {
		return garantiaProducto;
	}

	public void setGarantiaProducto(String garantiaProducto) {
		this.garantiaProducto = garantiaProducto;
	}

	public String getRecomendacionProducto() {
		return recomendacionProducto;
	}

	public void setRecomendacionProducto(String recomendacionProducto) {
		this.recomendacionProducto = recomendacionProducto;
	}

	public String getFechaRegistroProducto() {
		return fechaRegistroProducto;
	}

	public void setFechaRegistroProducto(String fechaRegistroProducto) {
		this.fechaRegistroProducto = fechaRegistroProducto;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
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

	public MaterialAcabadoBean getMaterialAcabado() {
		return materialAcabado;
	}

	public void setMaterialAcabado(MaterialAcabadoBean materialAcabado) {
		this.materialAcabado = materialAcabado;
	}

	public String getAltoProducto() {
		return altoProducto;
	}

	public void setAltoProducto(String altoProducto) {
		this.altoProducto = altoProducto;
	}

	public String getAnchoProducto() {
		return anchoProducto;
	}

	public void setAnchoProducto(String anchoProducto) {
		this.anchoProducto = anchoProducto;
	}

	public String getPesoProducto() {
		return pesoProducto;
	}

	public void setPesoProducto(String pesoProducto) {
		this.pesoProducto = pesoProducto;
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

	public String getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

}
