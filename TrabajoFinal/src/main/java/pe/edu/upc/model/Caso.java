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
@Table(name="Caso")
public class Caso implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCaso;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombreCaso", length=60, nullable=false)
	private String nameCaso;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="descripJuzgado", length=60, nullable=false)
	private String descripJuzgado;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="especialista", length=60, nullable=false)
	private String especialista;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="Juez", length=60, nullable=false)
	private String juez;
	
	

	public Caso() {
		super();
	}




	public Caso(int idCaso,String nameCaso,String descripJuzgado,String especialista,String juez) {
		super();
		this.idCaso = idCaso;
		this.nameCaso = nameCaso;
		this.descripJuzgado = descripJuzgado;
		this.especialista = especialista;
		this.juez = juez;
	}

	public int getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(int idCaso) {
		this.idCaso = idCaso;
	}

	public String getNameCaso() {
		return nameCaso;
	}

	public void setNameCaso(String nameCaso) {
		this.nameCaso = nameCaso;
	}

	public String getDescripJuzgado() {
		return descripJuzgado;
	}

	public void setDescripJuzgado(String descripJuzgado) {
		this.descripJuzgado = descripJuzgado;
	}

	public String getEspecialista() {
		return especialista;
	}

	public void setEspecialista(String especialista) {
		this.especialista = especialista;
	}

	public String getJuez() {
		return juez;
	}

	public void setJuez(String juez) {
		this.juez = juez;
	}

	
}
