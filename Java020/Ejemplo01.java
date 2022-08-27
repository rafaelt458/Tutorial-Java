import javax.swing.*;
import java.awt.*;

class Ejemplo01 extends JFrame {
	public Ejemplo01() {
		// Inicializar la ventana
		super("Ejemplo usando FlowLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		
		// Configurar el layout
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		// Agregar los botones
		int i;
		String str;
		
		for (i=1; i<=4; i++) {
			str = "Botón " + i;
			add(new JButton(str));
		}
	}
	
	public static void main(String args[]) {
		Ejemplo01 ventana;
		
		ventana = new Ejemplo01();
		ventana.setVisible(true);
	}
}