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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Resolucion")
public class Resolucion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResolucion;
	
	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Fecha;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="descripcion", nullable=false, length=200)
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

	public Resolucion(int idResolucion, Date Fecha, String descripcion, String plazos, Caso caso) {
		super();
		this.idResolucion = idResolucion;
		this.Fecha = Fecha;
		this.descripcion = descripcion;
		this.plazos = plazos;
		this.caso = caso;
	}

	public int getidResolucion() {
		return idResolucion;
	}

	public void setidResolucion(int idResolucion) {
		this.idResolucion = idResolucion;
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
