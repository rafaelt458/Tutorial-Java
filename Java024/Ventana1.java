import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import clasesCasino.Dado;

public class Ventana1 extends JFrame {
	private JButton lanzarD1, lanzarD2, lanzarD3;
	private Dado dado1, dado2, dado3;
	private EventosVentana ev;
	
	public Ventana1() {
		// Inicializar la ventana
		super("Ejemplo de botones y eventos");
		setSize(440, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 3, 5, 5));
		
		// Añadir el botón 1
		lanzarD1 = new JButton("Lanzar dado 1");
		add(lanzarD1);
		// Asociar eventos al botón
		ev = new EventosVentana();
		lanzarD1.addActionListener(ev);
		
		// Añadir el botón 2
		lanzarD2 = new JButton("Lanzar dado 2");
		add(lanzarD2);
		// Asociar eventos al botón
		lanzarD2.addActionListener(ev);
		
		// Añadir el botón 3
		lanzarD3 = new JButton("Lanzar dado 3");
		add(lanzarD3);
		// Asociar eventos al botón
		lanzarD3.addActionListener(ev);
		
		// Añadir el dado 1
		dado1 = new Dado();
		dado1.setNumero(1);
		add(dado1);
		
		// Añadir el dado 2
		dado2 = new Dado();
		dado2.setNumero(1);
		add(dado2);
		
		// Añadir el dado 3
		dado3 = new Dado();
		dado3.setNumero(1);
		add(dado3);
	}
	
	public static void main(String args[]) {
		Ventana1 ventana1;
		
		ventana1 = new Ventana1();
		ventana1.setVisible(true);
	}
	
	class EventosVentana implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Lanzar los dados
			if (e.getSource() == lanzarD1) {
				dado1.lanzar();
			}
			if (e.getSource() == lanzarD2) {
				dado2.lanzar();
			}
			if (e.getSource() == lanzarD3) {
				dado3.lanzar();
			}
		}
	}
}