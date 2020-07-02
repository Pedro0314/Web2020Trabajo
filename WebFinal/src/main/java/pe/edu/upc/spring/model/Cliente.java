package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="domicilioLegal", nullable=false, length=50)
	private String domicilioLegal;
	
	
	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingrese telefono")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="correo", nullable=false, length=50)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable = false)
	private Persona_Juridica persona;
	
	@ManyToOne
	@JoinColumn(name="idPersonaN", nullable = false)
	private Persona_Natural personaN;

	public Cliente() {
		super();
	}

	public Cliente(int idCliente, String domicilioLegal, String telefono, String correo, Persona_Juridica persona, Persona_Natural personaN) {
		super();
		this.idCliente = idCliente;
		this.domicilioLegal = domicilioLegal;
		this.telefono = telefono;
		this.correo = correo;
		this.persona = persona;
		this.personaN = personaN;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDomicilioLegal() {
		return domicilioLegal;
	}

	public void setDomicilioLegal(String domicilioLegal) {
		this.domicilioLegal = domicilioLegal;
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

	public Persona_Juridica getPersona() {
		return persona;
	}

	public void setPersona(Persona_Juridica persona) {
		this.persona = persona;
	}

	public Persona_Natural getPersonaN() {
		return personaN;
	}

	public void setPersonaN(Persona_Natural personaN) {
		this.personaN = personaN;
	}

}
