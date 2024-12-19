package org.generation.raicesmx.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id_producto;
	
	@Column(name = "imagen_url", length = 300, nullable = false)
	private String imagen_url;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "precio", precision = 10, scale = 2, nullable = false)
	private BigDecimal precio;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_categorias", referencedColumnName = "id_categorias")
	@JsonIgnore
	private CategoriasEntity categorias;
	
	@ManyToOne
	@JoinColumn(name = "id_status", referencedColumnName = "id_status")
	@JsonIgnore
	private StatusEntity status;
	
	@ManyToOne
	@JoinColumn(name = "id_artesano", referencedColumnName = "id_artesano")
	@JsonIgnore
	private ArtesanoEntity artesano;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")  // "productos" es el atributo en la entidad Pedido
	@JsonIgnore
	private PedidoEntity pedido;

	public ProductoEntity() {
		
	}

	public ProductoEntity(Long id_producto, String imagen_url, String nombre, BigDecimal precio, Integer stock,
			String descripcion, CategoriasEntity categorias, StatusEntity status, ArtesanoEntity artesano,
			PedidoEntity pedido) {
		super();
		this.id_producto = id_producto;
		this.imagen_url = imagen_url;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.categorias = categorias;
		this.status = status;
		this.artesano = artesano;
		this.pedido = pedido;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
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

	public CategoriasEntity getCategorias() {
		return categorias;
	}

	public void setCategorias(CategoriasEntity categorias) {
		this.categorias = categorias;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public ArtesanoEntity getArtesano() {
		return artesano;
	}

	public void setArtesano(ArtesanoEntity artesano) {
		this.artesano = artesano;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ProductoEntity [id_producto=" + id_producto + ", imagen_url=" + imagen_url + ", nombre=" + nombre
				+ ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", categorias="
				+ categorias + ", status=" + status + ", artesano=" + artesano + ", pedido=" + pedido + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(artesano, categorias, descripcion, id_producto, imagen_url, nombre, pedido, precio, status,
				stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoEntity other = (ProductoEntity) obj;
		return Objects.equals(artesano, other.artesano) && Objects.equals(categorias, other.categorias)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(id_producto, other.id_producto)
				&& Objects.equals(imagen_url, other.imagen_url) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pedido, other.pedido) && Objects.equals(precio, other.precio)
				&& Objects.equals(status, other.status) && Objects.equals(stock, other.stock);
	}

	
}
