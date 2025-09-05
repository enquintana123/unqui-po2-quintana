package ar.edu.unq.po2.tp2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoContratadoTest {
private EmpleadoContratado ruben;
	
	
	
	@BeforeEach
	public void inicilizar() {
		ruben = new EmpleadoContratado("Ruben contratado", "Con contrato 4", "Casado", LocalDate.of(1970, 04, 27), 10000, 3456, "Cheque");
		
	}
	
	@Test
	public void testSueldoBruto() {
		
		assertEquals((float)10000, (float)ruben.sueldoBruto(), 10);
	}
	
	@Test
	public void testRetenciones() {
		//fijo 50
		assertEquals((float)50, (float)ruben.retenciones(), 10);
	}
	
	@Test void testSueldoNeto() {
		//10000 - 50 = 9950
		assertEquals((float)9950, (float)ruben.sueldoNeto(), 10);
	}
}
