package pe.edu.upc.model;

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
@Table(name="Especialidad")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspecialidad;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombreRaza", length=60, nullable=false)
	private String nameEspecialidad;

	public Especialidad() {
		super();
	}

	public Especialidad(int idEspecialidad, String nameEspecialidad) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.nameEspecialidad = nameEspecialidad;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNameEspecialidad() {
		return nameEspecialidad;
	}

	public void setNameEspecialidad(String nameEspecialidad) {
		this.nameEspecialidad = nameEspecialidad;
	}
	
}
