package misClases;

import misClases.Animal;

public class Perro extends Animal {
	public String raza;
	
	public Perro(String n, int e, String r) {
		super("Perro", n, e);
		this.raza = r;
	}
	
	public void moverCola() {
		System.out.println(nombre + " de " + edad + " años, está moviendo la cola.");
	}
}