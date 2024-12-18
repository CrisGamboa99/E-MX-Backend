package org.generation.raicesmx.model;

import java.util.List;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categorias")
public class CategoriasEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorias")
	private Long id_categorias;
	
	@Column(name = "nombre_categoria", length = 45, nullable = false, unique = true)
	private String nombre_categoria;
	
	// Este código está comentado por si en un futuro ajustamos nuestra base de datos para que la Categoría contenga una descripción
	// @Column(name = "descripcion_categoria", length = 100, nullable = false)
	// private String descripcion_categoria;

	@OneToMany(mappedBy = "categorias")
	private List<ProductoEntity> producto;
	
	public CategoriasEntity() {
		
	}

	public CategoriasEntity(Long id_categorias, String nombre_categoria, List<ProductoEntity> producto) {
		super();
		this.id_categorias = id_categorias;
		this.nombre_categoria = nombre_categoria;
		this.producto = producto;
	}

	public Long getId_categorias() {
		return id_categorias;
	}

	public void setId_categorias(Long id_categorias) {
		this.id_categorias = id_categorias;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public List<ProductoEntity> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoEntity> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "CategoriasEntity [id_categorias=" + id_categorias + ", nombre_categoria=" + nombre_categoria
				+ ", producto=" + producto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_categorias, nombre_categoria, producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriasEntity other = (CategoriasEntity) obj;
		return Objects.equals(id_categorias, other.id_categorias)
				&& Objects.equals(nombre_categoria, other.nombre_categoria) && Objects.equals(producto, other.producto);
	}

	
}
