import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Ventana extends JFrame implements ActionListener {
	private JList<String> lista;
	private JScrollPane panel;
	private DefaultListModel<String> modelo;
	private JButton guardar;
	
	public Ventana() {
		// Inicializar ventana
		super("Escritura en arhivo");
		setBounds(0, 0, 450, 310);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		int i;
		String str;
		
		// Agregar la lista
		lista = new JList<>();
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel<>();
		for (i=0; i<10; i++) {
			str = "este es el contenido para el fichero " + (i+1);
			modelo.addElement(str);
		}
		lista.setModel(modelo);
		panel = new JScrollPane(lista);
		panel.setBounds(10, 10, 410, 220);
		add(panel);
		
		// Agregar el botón guardar
		guardar = new JButton("Guardar");
		guardar.setBounds(170, 240, 80, 20);
		add(guardar);
		
		// Agregar los eventos de la ventana
		guardar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == guardar) {
			File file;
			
			file = new File("fichero.txt");
			if (file.exists()) {
				modificarFichero();
			} else {
				crearFichero();
			}
		}
	}
	
	public void crearFichero() {
		FileWriter file = null;
		BufferedWriter buffer = null;
		int i;
		String str;
		
		try {
			file = new FileWriter("fichero.txt");
			buffer = new BufferedWriter(file);
			for (i=0; i<modelo.size(); i++) {
				str = modelo.get(i) + "\n";
				buffer.write(str);
			}
		} catch(Exception e) {
			// Manejo de la excepción
		} finally {
			try {
				buffer.close();
				file.close();
			} catch (Exception e) {
				// Manejo de la excepción
			}
		}
	}
	
	public void modificarFichero() {
		FileWriter file = null;
		BufferedWriter buffer = null;
		int i;
		String str;
		
		try {
			file = new FileWriter("fichero.txt", true);
			buffer = new BufferedWriter(file);
			for (i=0; i<modelo.size(); i++) {
				str = modelo.get(i) + "\n";
				buffer.write(str);
			}
		} catch(Exception e) {
			// Manejo de la excepción
		} finally {
			try {
				buffer.close();
				file.close();
			} catch (Exception e) {
				// Manejo de la excepción
			}
		}
	}
	
	public static void main(String args[]) {
		Ventana ventana;
		
		ventana = new Ventana();
		ventana.setVisible(true);
	}
}