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



import javax.validation.constraints.NotBlank;

@Entity
@Table(name="RegistroCaso")
public class RegistroCaso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegistro;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="descripcion", nullable=false, length=50)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="idAbogado", nullable = false)
	private Abogado abogado;
	
	@ManyToOne
	@JoinColumn(name="idCaso", nullable = false)
	private Caso caso;

	public RegistroCaso() {
		super();
	}

	public RegistroCaso(int idRegistro, String descripcion, Abogado abogado, Caso caso) {
		super();
		this.idRegistro = idRegistro;
		this.descripcion = descripcion;
		this.abogado = abogado;
		this.caso = caso;
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Abogado getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

}
