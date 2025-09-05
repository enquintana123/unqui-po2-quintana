package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoContratado extends Empleado {

	private int numeroDeContrato;
	private String medioDePago;
	
	public EmpleadoContratado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			float sueldoBasico, int numeroDeContrato, String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.numeroDeContrato = numeroDeContrato;
		this.medioDePago = medioDePago;
		
	}
	
	public float sueldoBruto() {
		return this.sueldoBasico();
	}
	
	@Override
	public float retenciones() {
		return 50;
	}

	@Override
	protected float obraSocial() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected float aportesJubilatorios() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
