package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaNacimiento;
	protected float sueldoBasico;
	
	
	public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento, float sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
	}
	
	protected String estadoCivil() {
		return this.estadoCivil;
	}
	
	public int edad() {
		return calcularEdad(this.fechaNacimiento, LocalDate.now());
	}
		
	private int calcularEdad(LocalDate fechaDeNacimiento, LocalDate fecha) {
	    return Period.between(fechaDeNacimiento, fecha).getYears();
	}
	
	public abstract float sueldoBruto();
	
	
	public float retenciones() {
		return this.obraSocial() + this.aportesJubilatorios();
	}

	public float sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	//getter
	protected float sueldoBasico() {
		return this.sueldoBasico;
	}
	
	protected abstract float obraSocial();
	protected abstract float aportesJubilatorios();

	public String nombre() {
		return this.nombre;
	}

	public String direccion() {
		return this.direccion;
	}
	
	public void completarRecibo(ReciboDeHaber unRecibo) {
		this.desgloceDeSueldoBruto(unRecibo);
		this.desgloceDeRetenciones(unRecibo);
	}

	protected void desgloceDeRetenciones(ReciboDeHaber unRecibo) {
		unRecibo.agregarConcepto("Obra Social", this.obraSocial());
		unRecibo.agregarConcepto("Aportes Jubilatorios", this.aportesJubilatorios());
	};
	protected void desgloceDeSueldoBruto(ReciboDeHaber unRecibo) {
		unRecibo.agregarConcepto("Sueldo Basico", this.sueldoBasico());
	}
}
