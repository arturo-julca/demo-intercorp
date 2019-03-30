package com.arturo.demointercorp.model;

public class ResponseKPI {

	private double promedioEdadClientes;
	private double desviacionEstandarEdadClientes;
	
	public ResponseKPI(double promedioEdadClientes, double desviacionEstandarEdadClientes) {
		super();
		this.promedioEdadClientes = promedioEdadClientes;
		this.desviacionEstandarEdadClientes = desviacionEstandarEdadClientes;
	}
	public double getPromedioEdadClientes() {
		return promedioEdadClientes;
	}
	public void setPromedioEdadClientes(double promedioEdadClientes) {
		this.promedioEdadClientes = promedioEdadClientes;
	}
	public double getDesviacionEstandarEdadClientes() {
		return desviacionEstandarEdadClientes;
	}
	public void setDesviacionEstandarEdadClientes(double desviacionEstandarEdadClientes) {
		this.desviacionEstandarEdadClientes = desviacionEstandarEdadClientes;
	}
}