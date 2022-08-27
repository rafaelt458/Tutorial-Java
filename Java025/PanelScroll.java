import javax.swing.*;

public class PanelScroll extends JFrame {
	private JTextArea texto;
	private JScrollPane panel;
	
	public PanelScroll() {
		// Iniciar la ventana
		super("Ejemplo de área de texto");
		setBounds(0, 0, 340, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Agregar el area de texto
		texto = new JTextArea();
		panel = new JScrollPane(texto);
		panel.setBounds(10, 10, 300, 240);
		add(panel);
	}
	
	public static void main(String args[]) {
		PanelScroll ventana1;
		
		ventana1 = new PanelScroll();
		ventana1.setVisible(true);
	}
}