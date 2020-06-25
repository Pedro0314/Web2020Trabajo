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
@Table(name="Abogado")
public class Abogado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAbogado;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	
	@Column(name="nombreAbogado", nullable=false, length=50)
	private String nameAbogado;
	
	
	
	@ManyToOne
	@JoinColumn(name="idEspecialidad", nullable = false)
	private Especialidad especialidad;

	public Abogado() {
		super();
	}

	public Abogado(int idAbogado, String nameAbogado, Especialidad especialidad) {
		super();
		this.idAbogado = idAbogado;
		this.nameAbogado = nameAbogado;
		this.especialidad = especialidad;
		
	}

	public int getIdAbogado() {
		return idAbogado;
	}

	public void setIdAbogado(int idAbogado) {
		this.idAbogado = idAbogado;
	}

	public String getNameAbogado() {
		return nameAbogado;
	}

	public void setNameAbogado(String nameAbogado) {
		this.nameAbogado = nameAbogado;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	

}
