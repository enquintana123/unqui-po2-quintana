package ar.edu.unq.po2.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmpleadoTemporalTest {
	
	private EmpleadoTemporal juan;
	
	
	
	
	@BeforeEach
	public void inicilizar() {
		juan = new EmpleadoTemporal("Juan", "Las casas 45", "Soltero", LocalDate.of(1990, 04, 27), 150000);
		juan.horasExtras(15); //15 * 40 = 600
	}
	
	@Test
	public void testEdad() {
		assertEquals(35, juan.edad());
	}
	
	@Test
	public void testHorasExtrasNegativas() {
		assertThrows(RuntimeException.class, ()->juan.horasExtras(-3));
	}

	@Test
	public void testSueldoBruto() {
		
		assertEquals((float)150600, (float)juan.sueldoBruto(), 10);
	}
	
	@Test
	public void testRetencionesEmpleado() {
		
		assertEquals((float)30185, (float)juan.retenciones(), 10);
	}
	
	@Test
	public void testRetencionesMayorEdad() {
		EmpleadoTemporal personaMayor = new EmpleadoTemporal("Juan", "Las casas 45", "Soltero", LocalDate.of(1950, 04, 27), 150000);
		personaMayor.horasExtras(15);
		//aportes jub (15060 + 25) + 15060 + (5 * 15) = 30075
		assertEquals((float)30210, (float)personaMayor.retenciones(), 10);
	}
	
	@Test
	public void testSueldoNeto() {
		//sueldo bruto 150600
		//retenciones 30185
		assertEquals((float)120415, (float)juan.sueldoNeto(), 10);
	}
}
