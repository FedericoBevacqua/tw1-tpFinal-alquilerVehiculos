package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String marca;
	String nombre;
	
	Double precio;
	public Boolean getSeguro() {
		return seguro;
	}
	public void setSeguro(Boolean seguro) {
		this.seguro = seguro;
	}
	public Boolean getConChofer() {
		return conChofer;
	}
	public void setConChofer(Boolean conChofer) {
		this.conChofer = conChofer;
	}
	public Boolean getTanqueLleno() {
		return tanqueLleno;
	}
	public void setTanqueLleno(Boolean tanqueLleno) {
		this.tanqueLleno = tanqueLleno;
	}
	Boolean seguro;
	Boolean conChofer;
	Boolean tanqueLleno;
	
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
	

}
