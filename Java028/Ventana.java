import javax.swing.*;
import javax.swing.event.*;

public class Ventana extends JFrame implements ChangeListener {
	private JRadioButton radio1, radio2, radio3, radio4;
	private ButtonGroup grupo;
	private JLabel label1, label2;
	
	public Ventana() {
		// Inicializar la ventana
		super("Ejemplo de botones de selección simple");
		setBounds(0, 0, 450, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Crear el grupo de botones
		grupo = new ButtonGroup();
		
		// Agregar el radiobutton 1
		radio1 = new JRadioButton("Regla");
		radio1.setBounds(10, 10, 150, 30);
		add(radio1);
		grupo.add(radio1);
		
		// Agregar el radiobutton 2
		radio2 = new JRadioButton("Compás");
		radio2.setBounds(10, 50, 150, 30);
		add(radio2);
		grupo.add(radio2);
		
		// Agregar el radiobutton 3
		radio3 = new JRadioButton("Escalímetro");
		radio3.setBounds(10, 90, 150, 30);
		add(radio3);
		grupo.add(radio3);
		
		// Agregar el radiobutton 4
		radio4 = new JRadioButton("Sacapuntas");
		radio4.setBounds(10, 130, 150, 30);
		add(radio4);
		grupo.add(radio4);
		
		// Agregar la etiqueta 1
		label1 = new JLabel("Material a usar:");
		label1.setBounds(180, 10, 250, 30);
		add(label1);
		
		// Agregar la etiqueta 2
		label2 = new JLabel("");
		label2.setBounds(180, 50, 250, 30);
		add(label2);
		
		// Asignar los eventos a la ventana principal
		radio1.addChangeListener(this);
		radio2.addChangeListener(this);
		radio3.addChangeListener(this);
		radio4.addChangeListener(this);
	}
	
	public void stateChanged(ChangeEvent e) {
		if (radio1.isSelected()) {
			label2.setText("Regla");
		}
		if (radio2.isSelected()) {
			label2.setText("Compás");
		}
		if (radio3.isSelected()) {
			label2.setText("Escalímetro");
		}
		if (radio4.isSelected()) {
			label2.setText("Sacapuntas");
		}
	}
	
	public static void main(String args[]) {
		Ventana ventana1;
		
		ventana1 = new Ventana();
		ventana1.setVisible(true);
	}
}