package ar.edu.unq.po2.tp2;

public class Concepto {
	private String concepto;
	private float monto;
	
	public Concepto(String concepto, float monto) {
		this.concepto = concepto;
		this.monto = monto;
	}
	
	public String concepto() {
		return this.concepto;
	}
	
	public float monto() {
		return this.monto;
	}
}
