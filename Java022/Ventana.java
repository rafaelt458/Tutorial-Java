import clasesCasino.Dado;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
	private Dado dado1, dado2, dado3, dado4, dado5, dado6;
	
	public Ventana() {
		// Inicializar ventana
		super("Ejemplo con Graphics");
		setSize(820, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 6, 5, 5));
		
		// Agregar el dado 1
		dado1 = new Dado();
		dado1.setNumero(1);
		add(dado1);
		
		// Agregar el dado 2
		dado2 = new Dado();
		dado2.setNumero(2);
		add(dado2);
		
		// Agregar el dado 3
		dado3 = new Dado();
		dado3.setNumero(3);
		add(dado3);
		
		// Agregar el dado 4
		dado4 = new Dado();
		dado4.setNumero(4);
		add(dado4);
		
		// Agregar el dado 5
		dado5 = new Dado();
		dado5.setNumero(5);
		add(dado5);
		
		// Agregar el dado 6
		dado6 = new Dado();
		dado6.setNumero(6);
		add(dado6);
	}
	
	public static void main(String args[]) {
		Ventana ventana1;
		
		ventana1 = new Ventana();
		ventana1.setVisible(true);
	}
}