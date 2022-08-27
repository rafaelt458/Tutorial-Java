import javax.swing.*;
import java.awt.*;

class Ejemplo03 extends JFrame {
	public Ejemplo03() {
		// Inicializar la ventana
		super("Ejemplo usando GridLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		// Configurar el layout
		setLayout(new GridLayout(4, 3, 10, 10));
		
		// Agregar los botones
		int i;
		String str;
		
		for (i=1; i<=12; i++) {
			str = "Botón " + i;
			add(new JButton(str));
		}
	}
	
	public static void main(String args[]) {
		Ejemplo03 ventana;
		
		ventana = new Ejemplo03();
		ventana.setVisible(true);
	}
}