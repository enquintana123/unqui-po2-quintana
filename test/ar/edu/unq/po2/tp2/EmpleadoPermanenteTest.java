package ar.edu.unq.po2.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmpleadoPermanenteTest {
	
	private EmpleadoPermanente carlos;
	
	
	
	@BeforeEach
	public void inicilizar() {
		carlos = new EmpleadoPermanente("Juan", "Las casas 45", "Casado", LocalDate.of(1980, 04, 27), 100000);
		carlos.antiguedad(10); //500
		carlos.cantidadHijos(3); 
	}
	
	@Test
	public void testEdad() {
		assertEquals(45, carlos.edad());
	}
	
	@Test
	public void testCantidadHijosNegativos() {
		assertThrows(RuntimeException.class, ()->carlos.cantidadHijos(-3));
	}

	@Test
	public void testAntiguedadNegativa() {
		assertThrows(RuntimeException.class, ()->carlos.antiguedad(-3));
	}
	@Test
	public void testSueldoBruto() {
		//450 + 100 conyuge = 550
		//100000 + 550 + 500
		assertEquals((float)101050, (float)carlos.sueldoBruto(), 10);
	}
	
	@Test
	public void testRetencionesEmpleado() {
		//450 + 100 conyuge = 550
		//500 antiguedad
		//sueldo bruto 101050 = 10105 + 60 + 15157,50(15% SB)
		assertEquals((float)25322.50, (float)carlos.retenciones(), 10);
	}
	
	@Test
	public void testRetencionesMayorEdad() {
		EmpleadoTemporal personaMayor = new EmpleadoTemporal("Juan", "Las casas 45", "Soltero", LocalDate.of(1950, 04, 27), 150000);
		personaMayor.horasExtras(15);
		//aportes jub (15060 + 25) + 15060 + (5 * 15) = 30075
		assertEquals((float)30210, (float)personaMayor.retenciones(), 10);
	}
	
	
}
