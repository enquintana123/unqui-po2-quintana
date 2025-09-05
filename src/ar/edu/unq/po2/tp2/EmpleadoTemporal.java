package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoTemporal extends Empleado{

	private int horasExtras = 0;

	public EmpleadoTemporal(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento, float sueldoBasico) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
	}
	
	public void horasExtras(int horasExtras) {
		this.validarHorasExtras(horasExtras);
		this.horasExtras = horasExtras;
	}
	
	private int horasExtras() {
		return this.horasExtras;
	}
	
	private void validarHorasExtras(int horasExtras) {
		if(horasExtras < 0) {
			throw new RuntimeException("Las horas extras no pueden ser negativas");
		}
	}
	
	public float sueldoBruto() {
		return this.sueldoBasico() + this.sueldoPorHsExtras(); 
	}

	
	
	private float sueldoPorHsExtras() {
		return this.valorHoraExtra() * this.horasExtras;
	}
	
	private float valorHoraExtra() {
		return 40;
	}
	
	
	@Override
	protected float obraSocial() {
		return (float) (this.sueldoBruto() * 0.1 + aporteExtraPorEdad());  
	}
	
	private int aporteExtraPorEdad() {
		if(this.edad() > 50) {
			return 25;
		}
		return 0;
	}
	
	@Override
	protected float aportesJubilatorios() {
		return (float) (this.sueldoBruto() * 0.1 + this.horasExtras() * this.valorHoraAporteJubilatorio());
	}

	private int valorHoraAporteJubilatorio() {
		return 5;
	}
	
	@Override
	protected void desgloceDeSueldoBruto(ReciboDeHaber unRecibo) {
		super.desgloceDeSueldoBruto(unRecibo);
		unRecibo.agregarConcepto("Horas Extras", this.sueldoPorHsExtras());
	}
	
}
