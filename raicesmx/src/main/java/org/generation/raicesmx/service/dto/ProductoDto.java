package org.generation.raicesmx.service.dto;

import java.math.BigDecimal;

public class ProductoDto {

	private Long id_artesano;
	private Long id_categorias;
	private Long id_pedido;
	private Long id_status;
	
	private String imagen_url; 
    private String nombre;
    private BigDecimal precio; 
    private Integer stock;
    private String descripcion;
    
	public Long getId_artesano() {
		return id_artesano;
	}
	public void setId_artesano(Long id_artesano) {
		this.id_artesano = id_artesano;
	}
	public Long getId_categorias() {
		return id_categorias;
	}
	public void setId_categorias(Long id_categorias) {
		this.id_categorias = id_categorias;
	}
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Long getId_status() {
		return id_status;
	}
	public void setId_status(Long id_status) {
		this.id_status = id_status;
	}
	public String getImagen_url() {
		return imagen_url;
	}
	public void setImagen_url(String imagen_url) {
		this.imagen_url = imagen_url;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
}
