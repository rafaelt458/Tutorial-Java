import java.util.Scanner;

public class Areas {
	static char menuOpciones() {
		char opcion;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("");
		System.out.println("****************");
		System.out.println("Menú de opciones");
		System.out.println("****************");
		System.out.println("(1) Calcular el área de un círculo");
		System.out.println("(2) Calcular el área de un triángulo");
		System.out.println("(3) Calcular el área de un cuadrado");
		System.out.println("(4) Fin del programa");
		System.out.println("");
		System.out.print("Indique su opción: ");
		
		opcion = teclado.next().charAt(0);
		
		return opcion;
	}
	
	static double obtenerDato(String nombreDato) {
		double dato;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Ingrese " + nombreDato + ": ");
		try {
			dato = teclado.nextDouble();
		} catch (Exception e) {
			System.out.println("Error. El valor debe ser numérico.");
			return 0;
		}
		
		return dato;
	}
	
	static double areaCirculo(double radio) {
		double area;
		
		area = radio * radio * Math.PI;
		
		return area;
	}
	
	static double areaTringulo(double base, double altura) {
		double area;
		
		area = base * altura / 2;
		
		return area;
	}
	
	static double areaCuadrado(double lado) {
		double area;
		
		area = lado * lado;
		
		return area;
	}
	
	static void mostrarResultado(double area) {
		System.out.println("");
		System.out.println("*********");
		System.out.println("Resultado");
		System.out.println("*********");
		System.out.println("El área calculada es: " + area);
	}
	
	public static void main(String args[]) {
		char opcion;
		double radio, base, altura, lado, area;
		
		do {
			opcion = menuOpciones();
			
			switch (opcion) {
				case '1':	radio = obtenerDato("la longitud del radio del circulo");
							if (radio != 0) {
								area = areaCirculo(radio);
								mostrarResultado(area);
							}
							break;
				case '2':	base = obtenerDato("la longitud de la base del triángulo");
							if (base != 0) {
								altura = obtenerDato("la longitud de la altura del triángulo");
								if (altura != 0) {
									area = areaTringulo(base, altura);
									mostrarResultado(area);
								}
							}
							break;
				case '3':	lado = obtenerDato("la longitud de unlado del cuadrado");
							if (lado != 0) {
								area = areaCuadrado(lado);
								mostrarResultado(area);
							}
							break;
				case '4':	break;
				default:	System.out.println("Error. Opción inexistente.");
							break;
			}
		} while (opcion != '4');
	}
}