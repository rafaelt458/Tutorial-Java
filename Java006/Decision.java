public class Decision {
	public static void main(String args[]) {
		int operando1, operando2;
		int resultado_suma, resultado_resta;
		
		operando1 = Integer.parseInt(args[0]);
		operando2 = Integer.parseInt(args[1]);
		
		if (operando1 < operando2) {
			resultado_suma = operando1 + operando2;
			System.out.println("El resultado de la suma es: " + resultado_suma);
		} else {
			resultado_resta = operando1 - operando2;
			System.out.println("El resultado de la resta es: " + resultado_resta);
		}
		
		int resultado_division;
		
		try {
			resultado_division = operando1 / operando2;
			System.out.println("El resultado de la division es: " + resultado_division);
		} catch (Exception e) {
			System.out.println("Error, division por cero");
		}
		
		System.out.println("Fin del programa");
	}
}