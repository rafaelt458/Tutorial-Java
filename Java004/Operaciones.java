public class Operaciones {
	public static void main(String args[]) {
		int operando1 = 10;
		int operando2 = 2;
		int resultado_suma;
		int resultado_resta;
		int resultado_multiplicacion;
		int resultado_division;
		
		resultado_suma = operando1 + operando2;
		resultado_resta = operando1 - operando2;
		resultado_multiplicacion = operando1 * operando2;
		resultado_division = operando1 / operando2;
		
		System.out.println("Operaciones aritméticas");
		System.out.println("");
		System.out.println("El resultado de la suma es: " + resultado_suma);
		System.out.println("El resultado de la resta es: " + resultado_resta);
		System.out.println("El resultado de la multiplicación es: " + resultado_multiplicacion);
		System.out.println("El resultado de la división es: " + resultado_division);
	}
}