package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		EmpleadoTemporal juan;
		EmpleadoPermanente carlos;
		EmpleadoContratado ruben;
		Empresa miEmpresa;
		// TODO Auto-generated method stub
		juan = new EmpleadoTemporal("Juan", "Las casas 45", "Soltero", LocalDate.of(1990, 04, 27), 150000);
		carlos = new EmpleadoPermanente("Carlos", "Montanias 134", "Casado", LocalDate.of(1980, 04, 27), 100000);
		ruben = new EmpleadoContratado("Ruben contratado", "Con contrato 4", "Casado", LocalDate.of(1970, 04, 27), 10000, 3456, "Cheque");
		juan.horasExtras(15);
		carlos.cantidadHijos(3);
		carlos.antiguedad(10); //500
		empleados.add(carlos);
		empleados.add(juan);
		empleados.add(ruben);
		miEmpresa = new Empresa("Mi Empresa I", empleados);
		miEmpresa.totalSueldosNetos();
		miEmpresa.liquidarSueldos();
		
	}

}
