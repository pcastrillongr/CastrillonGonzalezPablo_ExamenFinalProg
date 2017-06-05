package models;

import org.joda.time.LocalTime;

public class Coche {
	
	private LocalTime entrada;
	private LocalTime salida;
	private float pago;
	private String matricula;
	
	public Coche(){}
	
	
	public Coche(LocalTime entrada, LocalTime salida, float pago, String matricula) {
		super();
		this.entrada = entrada;
		this.salida = salida;
		this.pago = pago;
		this.matricula = matricula;
	}


	public LocalTime getEntrada() {
		return entrada;
	}


	public void setEntrada(LocalTime entrada) {
		this.entrada = entrada;
	}


	public LocalTime getSalida() {
		return salida;
	}


	public void setSalida(LocalTime salida) {
		this.salida = salida;
	}


	public float getPago() {
		return pago;
	}


	public void setPago(float pago) {
		this.pago = pago;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	

	
}
