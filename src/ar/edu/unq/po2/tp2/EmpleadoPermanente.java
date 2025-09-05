package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado{

	private int cantidadHijos = 0;
	private int antigueadad = 0;

	public EmpleadoPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			float sueldoBasico) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
	}

	
	private int cantidadHijos() {
		return this.cantidadHijos;
	}
	
	public void cantidadHijos(int cantidadHijos) {
		this.validarCantidadHijos(cantidadHijos);
		this.cantidadHijos = cantidadHijos;
	}
	
	private void validarCantidadHijos(int cantidadHijos) {
		if(cantidadHijos < 0) {
			throw new RuntimeException("Cantidad hijos no puede ser negativo");
		}
	}


	public void antiguedad(int antiguedad) {
		this.validarAntiguedada(antiguedad);
		this.antigueadad = antiguedad;
	}
	
	private void validarAntiguedada(int antiguedad) {
		if(antiguedad < 0) {
			throw new RuntimeException("Antiguedad no puede ser negativo");
		}
		
	}


	private int antiguedad() {
		return this.antigueadad;
	}
	@Override
	public float sueldoBruto() {
		return this.sueldoBasico() + this.salarioFamiliar(); 
	}

	private float salarioFamiliar() {
		return this.asignacionPorHijo() + this.asignacionPorConyuge() + this.extraPorAntiguedad();
	}


	private float extraPorAntiguedad() {
		return 50 * this.antiguedad();
	}


	private float asignacionPorHijo() {
		return 150 * this.cantidadHijos();
	}
	

	private float asignacionPorConyuge() {
		if(this.tieneConyugue()) {
			return 100;
		}
		else {
			return 0;
		}
	}

	private boolean tieneConyugue() {
		return this.estadoCivil() == "Casado";
	}

	
	@Override
	protected float aportesJubilatorios() {
		return (float) (this.sueldoBruto() * 0.15);
		
	}
	
	@Override
	protected float obraSocial() {
		return (float) (this.sueldoBruto() * 0.1 + aporteExtraPorHijo());
	}


	private float aporteExtraPorHijo() {
		return 20 * this.cantidadHijos();
	}
	
	
	@Override
	protected void desgloceDeSueldoBruto(ReciboDeHaber unRecibo) {
		super.desgloceDeSueldoBruto(unRecibo);
		unRecibo.agregarConcepto("Salario Familiar", this.salarioFamiliar());
	}
	
}
