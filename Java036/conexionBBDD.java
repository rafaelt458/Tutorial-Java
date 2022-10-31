import java.sql.*;

public class conexionBBDD {
	public static void main(String args[]) {
		// Registrar el driver PostgresSQL
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al registrar el driver PostgresSQL");
			return;
		}
		
		// Establecer la conexión con la base datos
		try {
			Connection conexion;
			boolean conValida;
			
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/laboratorio", "comercio", "comercio");
			
			conValida = conexion.isValid(10);
			if (conValida) {
				System.out.println("Se ha establecido la conexión con la base de datos");
			} else {
				System.out.println("No se ha podido establer la conexión con la base de datos");
				return;
			}
			
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al establer la conexión con la base de datos");
			System.out.println(e.getMessage());
		}
	}
}