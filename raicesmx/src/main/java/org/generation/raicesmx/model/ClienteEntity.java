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
@Table(name = "Clientes")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clientes")
	private Long id_clientes;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 100, nullable = false)
	private String apellido;
	
	@Column(name = "correo", length = 100, nullable = false, unique=true)
	private String correo;
	
	@Column(name = "contraseña", length = 45, nullable = false)
	private String contrasena;
	
	@Column(name = "telefono", length = 12, nullable = false)
	private String telefono;
	
	@Column(name = "direccion", length = 200, nullable = false)
	private String direccion;
	
	@Column(name = "ciudad", length = 45, nullable = false)
	private String ciudad;
	
	@Column(name = "estado", length = 45, nullable = false)
	private String estado;
	
	@Column(name = "codigo_postal", length = 6, nullable = false)
	private String codigo_postal;
	
	@Column(name = "tipo_usuario", length = 45, nullable = false)
	private String tipo_usuario;

	@OneToMany(mappedBy = "clientes")
	private List<PedidoEntity> pedido;
	
	public ClienteEntity() {
		
	}

	public ClienteEntity(Long id_clientes, String nombre, String apellido, String correo, String contrasena,
			String telefono, String direccion, String ciudad, String estado, String codigo_postal, String tipo_usuario,
			List<PedidoEntity> pedido) {
		super();
		this.id_clientes = id_clientes;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigo_postal = codigo_postal;
		this.tipo_usuario = tipo_usuario;
		this.pedido = pedido;
	}

	public Long getId_clientes() {
		return id_clientes;
	}

	public void setId_clientes(Long id_clientes) {
		this.id_clientes = id_clientes;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public List<PedidoEntity> getPedido() {
		return pedido;
	}

	public void setPedido(List<PedidoEntity> pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ClienteEntity [id_clientes=" + id_clientes + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", contrasena=" + contrasena + ", telefono=" + telefono + ", direccion="
				+ direccion + ", ciudad=" + ciudad + ", estado=" + estado + ", codigo_postal=" + codigo_postal
				+ ", tipo_usuario=" + tipo_usuario + ", pedido=" + pedido + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, ciudad, codigo_postal, contrasena, correo, direccion, estado, id_clientes, nombre,
				pedido, telefono, tipo_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(codigo_postal, other.codigo_postal) && Objects.equals(contrasena, other.contrasena)
				&& Objects.equals(correo, other.correo) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(estado, other.estado) && Objects.equals(id_clientes, other.id_clientes)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(telefono, other.telefono) && Objects.equals(tipo_usuario, other.tipo_usuario);
	}

	
}
