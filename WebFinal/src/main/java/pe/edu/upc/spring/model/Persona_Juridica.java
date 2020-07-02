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
import javax.validation.constraints.Size;

@Entity
@Table(name="Persona")
public class Persona_Juridica implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombrePersona", length=100, nullable=false)
	private String namePersona;

	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="razon", length=300, nullable=false)
	private String razon;
	
	@Size(min = 11, max = 11, message="El ruc del repartidor debe tener 11 digitos")
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="ruc", length=11, nullable=false)
	private String ruc;
	
	private int numeroRepresen;
	public Persona_Juridica() {
		super();
	}

	public Persona_Juridica(int idPersona, String namePersona, String razon, String ruc, int numeroRepresen) {
		super();
		this.idPersona = idPersona;
		this.namePersona = namePersona;
		this.razon = razon;
		this.ruc = ruc;
		this.numeroRepresen = numeroRepresen;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNamePersona() {
		return namePersona;
	}

	public void setNamePersona(String namePersona) {
		this.namePersona = namePersona;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public int getNumeroRepresen() {
		return numeroRepresen;
	}

	public void setNumeroRepresen(int numeroRepresen) {
		this.numeroRepresen = numeroRepresen;
	}
	
}
