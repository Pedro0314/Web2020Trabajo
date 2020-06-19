package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name="RegistroCaso")
public class RegistroCaso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegistroCaso;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	
	@Column(name="descripRegistroCaso", nullable=false, length=60)
	private String descripRegistroCaso;
	
	
	@ManyToOne
	@JoinColumn(name="idCaso", nullable = false)
	private Caso caso;
	
	@ManyToOne
	@JoinColumn(name="idAbogado", nullable = false)	
	private Abogado abogado;

	public RegistroCaso() {
		super();
	}

	public RegistroCaso(int idRegistroCaso, String descripRegistroCaso,Caso caso, Abogado abogado) {
		super();
		this.idRegistroCaso = idRegistroCaso;
		this.descripRegistroCaso = descripRegistroCaso;
		this.caso = caso;
		this.abogado = abogado;
	}

	public int getIdRegistroCaso() {
		return idRegistroCaso;
	}

	public void setIdRegistroCaso(int idRegistroCaso) {
		this.idRegistroCaso = idRegistroCaso;
	}

	public String getDescripRegistroCaso() {
		return descripRegistroCaso;
	}

	public void setDescripRegistroCaso(String descripRegistroCaso) {
		this.descripRegistroCaso = descripRegistroCaso;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Abogado getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	
}
