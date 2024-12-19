package org.generation.raicesmx.service.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PedidoDto {

	private Long id_clientes;
	private BigDecimal total;
	private String descripcion;
	private String estado_pedido;
	private Date fecha;
	
	public Long getId_clientes() {
		return id_clientes;
	}
	public void setId_clientes(Long id_clientes) {
		this.id_clientes = id_clientes;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
