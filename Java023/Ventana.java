import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import clasesCasino.Dado;

public class Ventana extends JFrame {
	private JButton lanzar;
	private Dado dado1, dado2;
	
	public Ventana() {
		// Inicializar la ventana
		super("Ejemplo de botones y eventos");
		setSize(440, 180);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 3, 5, 5));
		
		// Añadir el botón
		lanzar = new JButton("Lanzar");
		add(lanzar);
		// Asociar eventos al botón
		lanzar.addActionListener(new EventosVentana());
		
		// Añadir el dado 1
		dado1 = new Dado();
		dado1.setNumero(1);
		add(dado1);
		
		// Añadir el dado 2
		dado2 = new Dado();
		dado2.setNumero(1);
		add(dado2);
	}
	
	public static void main(String args[]) {
		Ventana ventana1;
		
		ventana1 = new Ventana();
		ventana1.setVisible(true);
	}
	
	class EventosVentana implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Lanzar los dados
			dado1.lanzar();
			dado2.lanzar();
		}
	}
}