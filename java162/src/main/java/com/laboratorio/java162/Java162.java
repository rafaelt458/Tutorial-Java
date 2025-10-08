
import com.laboratorio.java162.model.Estudiante;

void main(String[] args) {
    // System.out.println("Hello World!");
    saludar();
    
    int resultado = sumar();
    if (resultado == -1) {
        IO.println("Ha ocurrido un error ejecutando la suma");
    } else {
        IO.println("Resultado de la suma: " + resultado);
    }
    
    Estudiante estudiante = new Estudiante("Juan");
    IO.println("Nombre del estudiante: " + estudiante.getNombre());
}

void saludar() {
    IO.println("Hello World!");
}

int sumar() {
    try {
        String valor1 = IO.readln("Ingrese el primer número: ");
        String valor2 = IO.readln("Ingrese el segundo número: ");
        return Integer.parseInt(valor1) + Integer.parseInt(valor2);
    } catch (Exception e) {
        IO.println("Error: " + e.getMessage());
        return -1;
    }
}