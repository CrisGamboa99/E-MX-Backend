package org.generation.raicesmx.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

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
@Table(name = "Producto")
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
	
	@ManyToOne
	@JoinColumn(name = "Categorias_idCategorias", nullable = false)
	private CategoriasEntity categorias_idCategorias;
	
	@ManyToOne
	@JoinColumn(name = "status", nullable = false)
	private StatusEntity status;
	
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "artesano_idArtesano", nullable = false)
	private ArtesanoEntity artesano_idArtesano;
	
	@ManyToMany(mappedBy = "Producto_idProducto")  // "productos" es el atributo en la entidad Pedido
	private Set<PedidoEntity> Pedido_idPedidos;

	public ProductoEntity() {
		
	}

	public ProductoEntity(Long id_producto, String imagen_url, String nombre, BigDecimal precio, Integer stock,
			CategoriasEntity categorias_idCategorias, StatusEntity status, String descripcion,
			ArtesanoEntity artesano_idArtesano, Set<PedidoEntity> pedido_idPedidos) {
		super();
		this.id_producto = id_producto;
		this.imagen_url = imagen_url;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categorias_idCategorias = categorias_idCategorias;
		this.status = status;
		this.descripcion = descripcion;
		this.artesano_idArtesano = artesano_idArtesano;
		Pedido_idPedidos = pedido_idPedidos;
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

	public CategoriasEntity getCategorias_idCategorias() {
		return categorias_idCategorias;
	}

	public void setCategorias_idCategorias(CategoriasEntity categorias_idCategorias) {
		this.categorias_idCategorias = categorias_idCategorias;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArtesanoEntity getArtesano_idArtesano() {
		return artesano_idArtesano;
	}

	public void setArtesano_idArtesano(ArtesanoEntity artesano_idArtesano) {
		this.artesano_idArtesano = artesano_idArtesano;
	}

	public Set<PedidoEntity> getPedido_idPedidos() {
		return Pedido_idPedidos;
	}

	public void setPedido_idPedidos(Set<PedidoEntity> pedido_idPedidos) {
		Pedido_idPedidos = pedido_idPedidos;
	}

	@Override
	public String toString() {
		return "ProductoEntity [id_producto=" + id_producto + ", imagen_url=" + imagen_url + ", nombre=" + nombre
				+ ", precio=" + precio + ", stock=" + stock + ", categorias_idCategorias=" + categorias_idCategorias
				+ ", status=" + status + ", descripcion=" + descripcion + ", artesano_idArtesano=" + artesano_idArtesano
				+ ", Pedido_idPedidos=" + Pedido_idPedidos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Pedido_idPedidos, artesano_idArtesano, categorias_idCategorias, descripcion, id_producto,
				imagen_url, nombre, precio, status, stock);
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
		return Objects.equals(Pedido_idPedidos, other.Pedido_idPedidos)
				&& Objects.equals(artesano_idArtesano, other.artesano_idArtesano)
				&& Objects.equals(categorias_idCategorias, other.categorias_idCategorias)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(id_producto, other.id_producto)
				&& Objects.equals(imagen_url, other.imagen_url) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio) && Objects.equals(status, other.status)
				&& Objects.equals(stock, other.stock);
	}

	
	
}
