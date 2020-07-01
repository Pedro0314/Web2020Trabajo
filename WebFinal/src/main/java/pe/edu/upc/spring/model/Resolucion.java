package pe.edu.upc.spring.model;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Resolucion")
public class Resolucion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResol;
	
	@NotNull
	@Column(name="fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Fecha;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="descripcion", nullable=false, length=50)
	private String descripcion;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="plazos", nullable=false, length=50)
	private String plazos;
	
	@ManyToOne
	@JoinColumn(name="idcaso", nullable = false)
	private Caso caso;

	public Resolucion() {
		super();
	}

	public Resolucion(int idResol, Date Fecha, String descripcion, String plazos, Caso caso) {
		super();
		this.idResol = idResol;
		this.Fecha = Fecha;
		this.descripcion = descripcion;
		this.plazos = plazos;
		this.caso = caso;
	}

	public int getIdResol() {
		return idResol;
	}

	public void setIdResol(int idResol) {
		this.idResol = idResol;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPlazos() {
		return plazos;
	}

	public void setPlazos(String plazos) {
		this.plazos = plazos;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

}
