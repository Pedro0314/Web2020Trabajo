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
@Table(name="Caso")
public class Caso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCaso;
	
	private int numeroJuzgado;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="descripcionJuzgado", nullable=false, length=50)
	private String descripcionJuzgado;
	
	private int sala;
	
	private int juez;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="estado", nullable=false, length=50)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idcliente", nullable = false)
	private Cliente cliente;

	public Caso() {
		super();
	}

	public Caso(int idCaso, int numeroJuzgado, String descripcionJuzgado, int sala, int juez, String estado, Cliente cliente) {
		super();
		this.idCaso = idCaso;
		this.numeroJuzgado = numeroJuzgado;
		this.descripcionJuzgado = descripcionJuzgado;
		this.sala = sala;
		this.juez = juez;
		this.estado = estado;
		this.cliente = cliente;
	}

	public int getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(int idCaso) {
		this.idCaso = idCaso;
	}

	public int getNumeroJuzgado() {
		return numeroJuzgado;
	}

	public void setNumeroJuzgado(int numeroJuzgado) {
		this.numeroJuzgado = numeroJuzgado;
	}

	public String getDescripcionJuzgado() {
		return descripcionJuzgado;
	}

	public void setDescripcionJuzgado(String descripcionJuzgado) {
		this.descripcionJuzgado = descripcionJuzgado;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getJuez() {
		return juez;
	}

	public void setJuez(int juez) {
		this.juez = juez;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
