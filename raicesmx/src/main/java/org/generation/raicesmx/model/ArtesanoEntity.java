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
@Table(name = "artesano")
public class ArtesanoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_artesano")
	private Long id_artesano;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 100, nullable = false)
	private String apellido;
	
	@Column(name = "empresa", length = 45, nullable = false)
	private String empresa;
	
	@Column(name = "correo", length = 100, nullable = false, unique = true)
	private String correo;
	
	@Column(name = "password", length = 45, nullable = false)
	private String password;
	
	@Column(name = "direccion", length = 300, nullable = false)
	private String direccion;
	
	@Column(name = "telefono", length = 15, nullable = false)
	private String telefono;
	
	@Column(name = "codigo_postal", length = 6, nullable = false)
	private String codigo_postal;
	
	@Column(name = "estado", length = 45, nullable = false)
	private String estado;
	
	@Column(name = "tipo_usuario", length = 45, nullable = false)
	private String tipo_usuario;

	@OneToMany(mappedBy = "artesano")
	private List<ProductoEntity> producto;
	
	public ArtesanoEntity() {
		
	}

	public ArtesanoEntity(Long id_artesano, String nombre, String apellido, String empresa, String correo,
			String password, String direccion, String telefono, String codigo_postal, String estado,
			String tipo_usuario, List<ProductoEntity> producto) {
		super();
		this.id_artesano = id_artesano;
		this.nombre = nombre;
		this.apellido = apellido;
		this.empresa = empresa;
		this.correo = correo;
		this.password = password;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigo_postal = codigo_postal;
		this.estado = estado;
		this.tipo_usuario = tipo_usuario;
		this.producto = producto;
	}

	public Long getId_artesano() {
		return id_artesano;
	}

	public void setId_artesano(Long id_artesano) {
		this.id_artesano = id_artesano;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public List<ProductoEntity> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoEntity> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "ArtesanoEntity [id_artesano=" + id_artesano + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", empresa=" + empresa + ", correo=" + correo + ", password=" + password + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", codigo_postal=" + codigo_postal + ", estado=" + estado
				+ ", tipo_usuario=" + tipo_usuario + ", producto=" + producto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, codigo_postal, correo, direccion, empresa, estado, id_artesano, nombre, password,
				producto, telefono, tipo_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtesanoEntity other = (ArtesanoEntity) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(codigo_postal, other.codigo_postal)
				&& Objects.equals(correo, other.correo) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(empresa, other.empresa) && Objects.equals(estado, other.estado)
				&& Objects.equals(id_artesano, other.id_artesano) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(producto, other.producto)
				&& Objects.equals(telefono, other.telefono) && Objects.equals(tipo_usuario, other.tipo_usuario);
	}

	
}
