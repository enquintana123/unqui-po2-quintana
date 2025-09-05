package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReciboDeHaber {
	private String nombreEmpleado;
	private String direccion;
	private LocalDate fechaEmision;
	private float sueldoBruto ;
	private float sueldoNeto ;
	private ArrayList<Concepto> desgloceDeConceptos;
	
	public ReciboDeHaber(
			String nombreEmpleado, 
			String direccion, 
			LocalDate fechaEmision,  
			float sueldoBruto,
			float sueldoNeto
			) {
		this.nombreEmpleado = nombreEmpleado;
		this.direccion = direccion;
		this.fechaEmision = fechaEmision;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
		this.desgloceDeConceptos = new ArrayList<Concepto>();
		
		
		
	}

	public LocalDate fechaDeEmision() {
		return this.fechaEmision;
	}
	
	public void agregarConcepto(String descripcion, float monto) {
		this.desgloceDeConceptos.add(new Concepto(descripcion, monto));
	}
	
}
