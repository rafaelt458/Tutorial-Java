import javax.swing.*;
import java.awt.*;

class Ejemplo02 extends JFrame {
	public Ejemplo02() {
		// Inicializar la ventana
		super("Ejemplo usando BorderLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		// Configurar el layout
		setLayout(new BorderLayout(10, 10));
		
		// Agregar los botones
		add(new JButton("Este"), BorderLayout.EAST);
		add(new JButton("Oeste"), BorderLayout.WEST);
		add(new JButton("Norte"), BorderLayout.NORTH);
		add(new JButton("Sur"), BorderLayout.SOUTH);
		add(new JButton("Centro"), BorderLayout.CENTER);
	}
	
	public static void main(String args[]) {
		Ejemplo02 ventana;
		
		ventana = new Ejemplo02();
		ventana.setVisible(true);
	}
}