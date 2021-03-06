package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String marca;
	private String nombre;

	private Double precio;
	private Double puntajePromedio;
	private Long kilometrajeActual;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Double getPuntajePromedio() {
		return puntajePromedio;
	}
	public void setPuntajePromedio(Double puntajePromedio) {
		this.puntajePromedio = puntajePromedio;
	}

	public Long getKilometrajeActual() {
		return kilometrajeActual;
	}
	public void setKilometrajeActual(Long kilometrajeActual) {
		this.kilometrajeActual = kilometrajeActual;
	}

}
