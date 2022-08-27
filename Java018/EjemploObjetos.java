import misClases.Animal;

public class EjemploObjetos {
	public static void main(String args[]) {
		Animal objeto1, objeto2;
		
		// Creación de los objetos
		objeto1 = new Animal("Perro", "Rintintin", 4);
		objeto2 = new Animal("Gato", "Capitán", 5);
		
		// Ejecución de los métodos
		objeto1.comer();
		objeto2.caminar();
	}
}