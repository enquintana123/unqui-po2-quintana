package ar.edu.unq.po2.tp2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTest {
	
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private EmpleadoTemporal juan;
	private EmpleadoPermanente carlos;
	private EmpleadoContratado ruben;
	private Empresa miEmpresa;
	
	@BeforeEach
	public void inicializar() { 
	
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
	}
	
	@Test
	public void montoTotalSueldosNetos() {
		//sueldo bruto 251650 + 10000 = 261650
		//retenciones 30185 + 25322.50 + 50= 55557.50
		assertEquals(206092.5, miEmpresa.totalSueldosNetos(), 10);
	}
	
	@Test
	public void montoTotalSueldosBrutos() {
		//101050 + 150600 + 10000
		assertEquals(261650, miEmpresa.totalSueldosBrutos(), 10);
	}
	
	@Test
	public void montoTotalRetenciones() {
		//25322.50 + 30185	+ 50
		assertEquals(55557.50, miEmpresa.totalRetenciones(), 10);
	}
	
	@Test
	public void liquidarSueldosTest() {
		miEmpresa.liquidarSueldos();
		
	}
	
}
