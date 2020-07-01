package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleAbogado")
public class DetalleAbogado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleAbogado;
	
	@ManyToOne
	@JoinColumn(name="idEspecialidad", nullable = false)
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name="idDetalle", nullable = false)	
	private Detalle detalle;

	public DetalleAbogado() {
		super();
	}

	public DetalleAbogado(int idDetalleAbogado, Especialidad especialidad, Detalle detalle) {
		super();
		this.idDetalleAbogado = idDetalleAbogado;
		this.especialidad = especialidad;
		this.detalle = detalle;
	}

	public int getIdDetalleAbogado() {
		return idDetalleAbogado;
	}

	public void setIdDetalleAbogado(int idDetalleAbogado) {
		this.idDetalleAbogado = idDetalleAbogado;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}


	
	
}
