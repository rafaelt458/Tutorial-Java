import java.util.Random;

public class Casino1 {
	public static void main(String args[]) {
		int dado1, dado2;
		boolean ganaJugador, ganaCasino;
		Random numAleatorio = new Random();
		
		dado1 = numAleatorio.nextInt(6) + 1;
		dado2 = numAleatorio.nextInt(6) + 1;
		
		System.out.println("El valor del dado 1 es: " + dado1);
		System.out.println("El valor del dado 2 es: " + dado2);
		
		if ((dado1 == 6) && (dado2 == 6)) {
			ganaJugador = true;
			System.out.println("Gana el jugador");
		} else {
			ganaJugador = false;
		}
		
		if (((dado1 == 1) && (dado2 == 2)) || ((dado1 == 2) && (dado2 == 1))) {
			ganaCasino = true;
			System.out.println("Gana el casino");
		} else {
			ganaCasino = false;
		}
		
		if (!ganaJugador && !ganaCasino) {
			System.out.println("No hay ganador");
		}
	}
}