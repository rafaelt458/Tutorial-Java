import javax.swing.*;

public class Ventana extends JFrame {
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	
	public Ventana() {
		// Inicializar la ventana
		super("Ejemplo 01 - Interfaz gráfica de usuario");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 200);
		setLocationRelativeTo(null);
		
		// Agregar etiqueta 1
		etiqueta1 = new JLabel("Interfaz gráfica de usuario");
		etiqueta1.setBounds(10, 10, 200, 30);
		add(etiqueta1);
		
		// Agregar etiqueta 2
		etiqueta2 = new JLabel("Ejemplo práctico 01");
		etiqueta2.setBounds(10, 60, 200, 30);
		add(etiqueta2);
	}
	
	public static void main(String args[]) {
		Ventana ventana1;

		ventana1 = new Ventana();
		ventana1.setVisible(true);
	}
}