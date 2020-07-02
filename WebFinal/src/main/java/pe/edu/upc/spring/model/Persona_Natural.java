package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Persona")
public class Persona_Natural implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dni;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombrePersonaN", length=50, nullable=false)
	private String namePersonaN;

	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="apellidoPersonaN", length=50, nullable=false)
	private String apellidoPersonaN;
	public Persona_Natural() {
		super();
	}

	public Persona_Natural(int dni, String namePersonaN, String apellidoPersonaN) {
		super();
		this.dni = dni;
		this.namePersonaN = namePersonaN;
		this.apellidoPersonaN = apellidoPersonaN;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNamePersonaN() {
		return namePersonaN;
	}

	public void setNamePersonaN(String namePersonaN) {
		this.namePersonaN = namePersonaN;
	}

	public String getApellidoPersonaN() {
		return apellidoPersonaN;
	}

	public void setApellidoPersonaN(String apellidoPersonaN) {
		this.apellidoPersonaN = apellidoPersonaN;
	}
	
}
