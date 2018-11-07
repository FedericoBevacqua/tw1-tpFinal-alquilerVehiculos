package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Devolucion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne //TODO: Preguntar si hace falta tener el objeto Reserva en Devolucion. o con solo el IdReserva es suficiente.
	private Reserva reserva;
	
	private Date fechaDevolucion;
	
	private Double precioExtra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Double getPrecioExtra() {
		return precioExtra;
	}

	public void setPrecioExtra(Double precioExtra) {
		this.precioExtra = precioExtra;
	}

}
