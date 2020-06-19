package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="detalleabogado")

public class DetalleAbogado implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	
	@Column(name="nombre",nullable=false,length=60)
	private	String nombre;
	
	@Column(name="apellido",nullable=false,length=60)
	private	String apellido;
	
	@Column(name="telefono",nullable=false,length=60)
	private	String telefono;
	
	@Column(name="correo",nullable=false,length=60)
	private	String correo;
	
	@Column(name="direccion",nullable=false,length=60)
	private	String direccion;
	
	@Column(name="contraseña",nullable=false,length=60)
	private	String contraseña;

	@ManyToOne
	@JoinColumn(name="idEspecialidad", nullable = false)
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable = false)	
	private Cliente cliente;
	
	public DetalleAbogado() {
		super();
	}

	public DetalleAbogado(int idCliente, String nombre, String apellido, String telefono, String correo, String direccion,
			String contraseña,Especialidad especialidad, Cliente cliente) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.contraseña = contraseña;
		this.especialidad = especialidad;
		this.cliente= cliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setRace(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
