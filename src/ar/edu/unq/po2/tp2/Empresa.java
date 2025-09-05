package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {

	private String nombre;

	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<ReciboDeHaber> reciboDeHaberes = new ArrayList<ReciboDeHaber>();

	public Empresa(String nombre, ArrayList<Empleado> empleados) {
		this.nombre = nombre;
		this.empleados = empleados;
	}

	private ArrayList<Empleado> empleados() {
		return this.empleados;
	}

	public float totalSueldosNetos() {
		return (float) this.empleados().stream().mapToDouble(Empleado::sueldoNeto).sum();
	}

	public float totalSueldosBrutos() {
		return (float) this.empleados().stream().mapToDouble(Empleado::sueldoBruto).sum();
	}

	public float totalRetenciones() {
		return (float) this.empleados().stream().mapToDouble(Empleado::retenciones).sum();
	}

	public void liquidarSueldos() {
		for (Empleado unEmpleado : this.empleados()) {
			ReciboDeHaber unRecibo = this.generarReciboDeHaber(unEmpleado);
			unEmpleado.completarRecibo(unRecibo);
			this.guardarReciboDeHaber(unRecibo);
		}
	}

	private void guardarReciboDeHaber(ReciboDeHaber reciboDeHaber) {
		this.reciboDeHaberes.add(reciboDeHaber);

	}

	private ReciboDeHaber generarReciboDeHaber(Empleado unEmpleado) {
		return new ReciboDeHaber(unEmpleado.nombre(), unEmpleado.direccion(), LocalDate.now(), unEmpleado.sueldoBruto(),
				unEmpleado.sueldoNeto());
	}
}
