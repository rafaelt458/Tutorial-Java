public class Variable {
	public static void main(String args[]) {
		byte variable_byte = 2;
		short variable_short = 4;
		int variable_int = 8;
		long variable_long = 16;
		float variable_float = 1;
		double variable_double = 4.67;
		boolean variable_boolean = true;
		char variable_char = 'V';
		String variable_string = "valor de la variable";
		
		System.out.println("Tipos de variable en Java");
		System.out.println("");
		System.out.println("Valor de la variable byte: " + variable_byte);
		System.out.println("Valor de la variable short: " + variable_short);
		System.out.println("Valor de la variable int: " + variable_int);
		System.out.println("Valor de la variable long: " + variable_long);
		System.out.println("Valor de la variable float: " + variable_float);
		System.out.println("Valor de la variable double: " + variable_double);
		System.out.println("Valor de la variable boolean: " + variable_boolean);
		System.out.println("Valor de la variable char: " + variable_char);
		System.out.println("Valor de la variable String: " + variable_string);
		
		System.out.println("");
		System.out.println("Argumentos recibidos");
		System.out.println("Argumento 1: " + args[0]);
		System.out.println("Argumento 2: " + args[1]);
		System.out.println("Argumento 3: " + args[2]);
	}
}