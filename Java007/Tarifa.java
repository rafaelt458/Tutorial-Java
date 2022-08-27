public class Tarifa {
	public static void main(String args[]) {
		int edad;
		String tarifa;
		
		try {
			edad = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Error. La edad debe ser un número.");
			return;
		}
		
		System.out.println("La edad de la persona es: " + edad);
		
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
		
		System.out.println("La tarifa seleccionada es: " + tarifa);
	}
}