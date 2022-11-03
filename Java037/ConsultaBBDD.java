import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ConsultaBBDD extends JFrame {
	private static DefaultTableModel modelo;
	private JTable tabla;
	private JScrollPane panel;
	private static Connection conexion;
	
	public ConsultaBBDD() {
		// Inicializar la ventana
		super("Consulta de base de datos");
		setBounds(0, 0, 600, 310);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Inicializar el modelo de la tabla
		String[] etiquetas;
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Documento");
		modelo.addColumn("Compras");
		modelo.addColumn("Registro");
		etiquetas = new String[5];
		etiquetas[0] = "Id";
		etiquetas[1] = "Nombre";
		etiquetas[2] = "Documento";
		etiquetas[3] = "# compras";
		etiquetas[4] = "Registro";
		modelo.setColumnIdentifiers(etiquetas);
		
		// Inicializamos la tabla
		tabla = new JTable(modelo);
		panel = new JScrollPane(tabla);
		panel.setBounds(10, 10, 560, 250);
		add(panel);
	}
	
	public static void main(String args[]) {
		ConsultaBBDD ventana;
		Statement statement;
		ResultSet rs;
		Object[] fila;
		int i;
		
		ventana = new ConsultaBBDD();
		ventana.setVisible(true);
		
		if (!conectarBBDD()) {
			System.exit(0);
			return;
		}
		
		try {
			// Crear la consulta y ejecutarla
			statement = conexion.createStatement();
			rs = statement.executeQuery("select IDCliente, Nombre, NumeroDocumento, NumeroCompras, FechaRegistro from cliente");
			
			// Recorrer los resultados de la consulta
			while (rs.next()) {
				fila = new Object[5];
				for (i=1; i<=5; i++) {
					fila[i-1] = rs.getObject(i);
				}
				
				modelo.addRow(fila);
			}
			
			conexion.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean conectarBBDD() {
		// Registrar el driver PostgresSQL
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al registrar el driver PostgresSQL");
			return false;
		}
		
		// Establecer la conexión con la base datos
		try {
			boolean conValida;
			
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/laboratorio", "comercio", "comercio");
			
			conValida = conexion.isValid(10);
			if (!conValida) {
				System.out.println("No se ha podido establer la conexión con la base de datos");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al establer la conexión con la base de datos");
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
}