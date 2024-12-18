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
@Table(name = "Status")
public class StatusEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
	private Long id_status;
	
	@Column(name = "tipo_status", length = 45, nullable = false, unique = true)
	private String tipo_status;
	
	// Este código está comentado por si en un futuro ajustamos nuestra base de datos para que la Categoría contenga una descripción
		// @Column(name = "descripcion_status", length = 100, nullable = false)
		// private String descripcion_status;
	
	@OneToMany(mappedBy = "status")
	private List<ProductoEntity> producto;
	
	public StatusEntity() {
		
	}

	public StatusEntity(Long id_status, String tipo_status, List<ProductoEntity> producto) {
		super();
		this.id_status = id_status;
		this.tipo_status = tipo_status;
		this.producto = producto;
	}

	public Long getId_status() {
		return id_status;
	}

	public void setId_status(Long id_status) {
		this.id_status = id_status;
	}

	public String getTipo_status() {
		return tipo_status;
	}

	public void setTipo_status(String tipo_status) {
		this.tipo_status = tipo_status;
	}

	public List<ProductoEntity> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoEntity> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "StatusEntity [id_status=" + id_status + ", tipo_status=" + tipo_status + ", producto=" + producto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_status, producto, tipo_status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusEntity other = (StatusEntity) obj;
		return Objects.equals(id_status, other.id_status) && Objects.equals(producto, other.producto)
				&& Objects.equals(tipo_status, other.tipo_status);
	}

	
	// En caso de ocupar descripcion_status volver a hacer el procedimiento desde el método constructor
	
}
