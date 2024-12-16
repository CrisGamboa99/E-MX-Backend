package org.generation.raicesmx.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Pedido")
public class PedidoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id_pedido;

    @Column(name = "total", precision = 10, scale = 2,nullable = false)
    private BigDecimal total;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "estado_pedido", length = 100, nullable = false)
    private String estado_pedido;

    @Temporal(TemporalType.TIMESTAMP) //Este es para que fecha menciones que es eso, una fecha
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne //creo, no recuerdo bien
    @JoinColumn(name = "Clientes_idClientes")
    private ClienteEntity Clientes_idClientes;

    @ManyToMany
    @JoinTable(
            name = "Pedido_has_Producto",  // Tabla intermedia
            joinColumns = @JoinColumn(name = "id_pedido"),  // Columna de llave foránea a Pedido
            inverseJoinColumns = @JoinColumn(name = "id_producto")  // Columna de llave foránea a Producto
        )
    private Set<ProductoEntity> Producto_idProducto;

	public PedidoEntity() {
		
	}

	public PedidoEntity(Long id_pedido, BigDecimal total, String descripcion, String estado_pedido, Date fecha,
			ClienteEntity clientes_idClientes, Set<ProductoEntity> producto_idProducto) {
		super();
		this.id_pedido = id_pedido;
		this.total = total;
		this.descripcion = descripcion;
		this.estado_pedido = estado_pedido;
		this.fecha = fecha;
		Clientes_idClientes = clientes_idClientes;
		Producto_idProducto = producto_idProducto;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
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

	public ClienteEntity getClientes_idClientes() {
		return Clientes_idClientes;
	}

	public void setClientes_idClientes(ClienteEntity clientes_idClientes) {
		Clientes_idClientes = clientes_idClientes;
	}

	public Set<ProductoEntity> getProducto_idProducto() {
		return Producto_idProducto;
	}

	public void setProducto_idProducto(Set<ProductoEntity> producto_idProducto) {
		Producto_idProducto = producto_idProducto;
	}

	@Override
	public String toString() {
		return "PedidoEntity [id_pedido=" + id_pedido + ", total=" + total + ", descripcion=" + descripcion
				+ ", estado_pedido=" + estado_pedido + ", fecha=" + fecha + ", Clientes_idClientes="
				+ Clientes_idClientes + ", Producto_idProducto=" + Producto_idProducto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Clientes_idClientes, Producto_idProducto, descripcion, estado_pedido, fecha, id_pedido,
				total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoEntity other = (PedidoEntity) obj;
		return Objects.equals(Clientes_idClientes, other.Clientes_idClientes)
				&& Objects.equals(Producto_idProducto, other.Producto_idProducto)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(estado_pedido, other.estado_pedido)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(id_pedido, other.id_pedido)
				&& Objects.equals(total, other.total);
	}

	
}
