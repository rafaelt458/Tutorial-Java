import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {
	private JMenuBar menubar;
	private JMenu menu1, menu2, menu3, submenu;
	private JMenuItem opcion1_1, opcion1_2, opcion1_3;
	private JMenuItem opcion2_1, opcion2_2;
	private JMenuItem opcion3_1, opcion3_2, opcion3_3;
	private JLabel label;
	
	public Ventana() {
		// Inicializar la ventana
		super("Ejemplo de menú de opciones");
		setBounds(0,0, 450, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Crear la barra de menú
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		// Creamos el primer menú
		menu1 = new JMenu("Menú 1");
		menubar.add(menu1);
		
		// Agregar las opciones del menú 1
		opcion1_1 = new JMenuItem("Opción 1.1");
		menu1.add(opcion1_1);
		opcion1_2 = new JMenuItem("Opción 1.2");
		menu1.add(opcion1_2);
		opcion1_3 = new JMenuItem("Opción 1.3");
		menu1.add(opcion1_3);
		
		// Creamos el segundo menú
		menu2 = new JMenu("Menú 2");
		menubar.add(menu2);
		
		// Agregar las opciones del menú 2
		opcion2_1 = new JMenuItem("Opción 2.1");
		menu2.add(opcion2_1);
		opcion2_2 = new JMenuItem("Opción 2.2");
		menu2.add(opcion2_2);
		
		// Creamos el tercer menú
		menu3 = new JMenu("Menú 3");
		menubar.add(menu3);
		
		// Agregar las opciones del menú 2
		opcion3_1 = new JMenuItem("Opción 3.1");
		menu3.add(opcion3_1);
		submenu = new JMenu("Submenu");
		menu3.add(submenu);
		opcion3_2 = new JMenuItem("Opción 3.2");
		submenu.add(opcion3_2);
		opcion3_3 = new JMenuItem("Opción 3.3");
		submenu.add(opcion3_3);
		
		// Crear la etiqueta
		label =  new JLabel("Opción seleccionada:");
		label.setBounds(20, 50, 400, 30);
		add(label);
		
		// Asignar los eventos de la ventana principal
		opcion1_1.addActionListener(this);
		opcion1_2.addActionListener(this);
		opcion1_3.addActionListener(this);
		opcion2_1.addActionListener(this);
		opcion2_2.addActionListener(this);
		opcion3_1.addActionListener(this);
		opcion3_2.addActionListener(this);
		opcion3_3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == opcion1_1) {
			label.setText("Opción seleccionada: Opción 1.1");
		}
		if (e.getSource() == opcion1_2) {
			label.setText("Opción seleccionada: Opción 1.2");
		}
		if (e.getSource() == opcion1_3) {
			label.setText("Opción seleccionada: Opción 1.3");
		}
		if (e.getSource() == opcion2_1) {
			label.setText("Opción seleccionada: Opción 2.1");
		}
		if (e.getSource() == opcion2_2) {
			label.setText("Opción seleccionada: Opción 2.2");
		}
		if (e.getSource() == opcion3_1) {
			label.setText("Opción seleccionada: Opción 3.1");
		}
		if (e.getSource() == opcion3_2) {
			label.setText("Opción seleccionada: Opción 3.2");
		}
		if (e.getSource() == opcion3_3) {
			label.setText("Opción seleccionada: Opción 3.3");
		}
	}
	
	public static void main(String args[]) {
		Ventana ventana1;
	
		ventana1 = new Ventana();
		ventana1.setVisible(true);
	}
}