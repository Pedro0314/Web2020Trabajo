package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Detalle")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombreDetalle", length=300, nullable=false)
	private String nameDetalle;
	
	@Min(0)
	@Max(9)
	@Column(name="puntDetalle", nullable=false)
	private int puntDetalle;
	
	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaDetalle")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaDetalle;
	
	public Detalle() {
		super();
	}

	public Detalle(int idDetalle, String nameDetalle,int puntDetalle,  Date fechaDetalle) {
		super();
		this.idDetalle = idDetalle;
		this.nameDetalle = nameDetalle;
		this.puntDetalle = puntDetalle;
		this.fechaDetalle = fechaDetalle;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getNameDetalle() {
		return nameDetalle;
	}

	public void setNameDetalle(String nameDetalle) {
		this.nameDetalle = nameDetalle;
	}

	public int getPuntDetalle() {
		return puntDetalle;
	}

	public void setPuntDetalle(int puntDetalle) {
		this.puntDetalle = puntDetalle;
	}

	public Date getFechaDetalle() {
		return fechaDetalle;
	}

	public void setFechaDetalle(Date fechaDetalle) {
		this.fechaDetalle = fechaDetalle;
	}

	

	
}
