import java.util.Scanner;

public class Tarifa2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int edad;
		String tarifa, nombre;
		
		System.out.print("Ingrese el nombre de la persona: ");
		nombre = in.nextLine();
		
		System.out.print("Ingrese la edad de la persona: ");
		try {
			edad = in.nextInt();
		} catch (Exception e) {
			System.out.println("Error. La edad debe ser un número.");
			return;
		}
		
		if (edad > 65) {
			tarifa = "Jubilado";
		} else {
			if (edad > 25) {
				tarifa = "Adulto";
			} else {
				if (edad > 12) {
					tarifa = "Estudiante";
				} else {
					tarifa = "Niño";
				}
			}
		}
		
		System.out.println("La tarifa seleccionada para " + nombre + " es: " + tarifa);
	}
}