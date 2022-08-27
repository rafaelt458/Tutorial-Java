class MetodosString {
	public static void main (String[] args) {
		String s= "Laboratorio de Rafa";
		
		// Longitud de la cadena
		System.out.println("String length = " + s.length());
		// Caracteres de una posición
		System.out.println("Caracter de la posición 3 = " + s.charAt(3));
		// Subcadena a partir de una posición
		System.out.println("Substring = " + s.substring(12));
		// Subcadena a entre 2 posiciones
		System.out.println("Substring  = " + s.substring(2,6));
		
		String s1 = "Laboratorio ";
		String s2 = "de Rafa";
		
		// Concatenar 2 cadenas
		System.out.println("String concatenado  = " + s1.concat(s2));
		System.out.println("String concatenado  = " + s1 + s2);
		// Posición de la primera ocurrencia de una subcadenas
		System.out.println("Índice de Rafa: " + s.indexOf("Rafa"));
		
		boolean out;
		
		// Resultado de varias comparaciones
		out = "Java".equals("java");
		System.out.println("Comprobando la igualdad: " + out);
		out = "Java".equals("Java");
		System.out.println("Comprobando la igualdad: " + out);
		out = "Java".equalsIgnoreCase("jaVA");
		System.out.println("Comprobando la igualdad: " + out);
		
		int res;
		
		// Comparación lexográfica.
		// Si s1 > s2 entonces res > 0,  s1 < s2 entonces res < 0, si s1 = s2 entonces res = 0
		res = s1.compareTo(s2);
		System.out.println("Si s1 = s2: " + res);
		
		// Conversiones a mayúsculas y minúsculas
		System.out.println("Cambiando a minúsculas: " + s.toLowerCase());
		System.out.println("Cambiando a MAYÚSCULAS: " + s.toUpperCase());
		
		String s3 = "  con espacios  ";
		
		// Quitando espacios en blanco
		System.out.println("Recortando la palabra: [" + s3.trim() + "]");
		
		// Reemplazando un caracter por otro
		System.out.println("Reemplazando a por @ -> " + s.replace('a', '@'));
	}
}