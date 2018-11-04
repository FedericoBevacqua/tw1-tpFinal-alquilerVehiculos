package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

public class Busqueda {
	
	Date fechaDesde;
	Date fechaHasta;
	
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	
}
