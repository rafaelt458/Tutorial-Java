import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {
	private JTextField campo;
	private JScrollPane panel;
	private JTextArea texto;
	private JButton limpiar;
	
	public Ventana() {
		// Inicilizar la ventana
		super("Ejemplo de campos y áreas de texto");
		setBounds(0, 0, 440, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Agregar el campo
		campo = new JTextField();
		campo.setBounds(10, 10, 300, 30);
		add(campo);
		campo.addActionListener(this);
		
		// Agregar el area de texto
		texto = new JTextArea();
		panel = new JScrollPane(texto);
		panel.setBounds(10, 50, 300, 250);
		add(panel);
		
		// Agregar el botón
		limpiar = new JButton("Limpiar");
		limpiar.setBounds(320, 270, 90, 30);
		add(limpiar);
		limpiar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// Manejo del evento del campo
		if (e.getSource() == campo) {
			String str1, str2;
			
			str1 = texto.getText();
			if (str1.length() > 0) {
				str1 += "\n";
			}
			
			str2 = campo.getText();
			
			texto.setText(str1 + str2);
			campo.setText("");
		}
		
		// Manejo del evento del botón
		if (e.getSource() == limpiar) {
			texto.setText("");
		}
	}
	
	public static void main(String args[]) {
		Ventana ventana1;
		
		ventana1 = new Ventana();
		ventana1.setVisible(true);
	}
}