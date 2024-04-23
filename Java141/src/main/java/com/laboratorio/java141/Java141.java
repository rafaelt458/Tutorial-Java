package com.laboratorio.java141;

import com.laboratorio.java141.modelo.Alumno;
import com.laboratorio.java141.modelo.Persona;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java141 {

    public static void main(String[] args) {
        Function<Integer, Integer> alCuadradoFunction = (Integer valor) -> valor * valor;
        System.out.println("Cuadrado: " + alCuadradoFunction.apply(5));
        
        Function<Integer, Integer> alCuadradoFunction2 = valor -> valor * valor;
        System.out.println("Cuadrado: " + alCuadradoFunction2.apply(5));
        
        Function<Integer[], Integer> sumaFunction = num -> num[0] + num[1];
        Integer[] numeros = {5, 3};
        System.out.println("Suma: " + sumaFunction.apply(numeros));
        
        Function<String, String> saludarFunction = nombre -> "Hola " + nombre;
        System.out.println("Suma: " + saludarFunction.apply("Rafa"));
        
        Function<String, String> convertirFunction = nombre -> nombre.toUpperCase();
        System.out.println("Suma: " + convertirFunction.apply("Rafa"));
        
        Function<String, String> convertirFunction2 = String::toUpperCase;
        System.out.println("Suma: " + convertirFunction2.apply("Rafa"));
        
        Persona p1 = new Persona(1, "Pedro", LocalDate.of(1981, 4, 25), 18, 1200.0);
        Persona p2 = new Persona(2, "María", LocalDate.of(2013, 8, 3), 0, 0.0);
        Persona p3 = new Persona(3, "Luisa", LocalDate.of(1979, 3, 11), 21, 1400.0);
        Persona p4 = new Persona(4, "Javier", LocalDate.of(2008, 5, 15), 0, 0.0);
        Persona p5 = new Persona(5, "Angel", LocalDate.of(1985, 1, 12), 8, 1000.0);
        Persona p6 = new Persona(6, "Beatriz", LocalDate.of(1987, 2, 17), 14, 1100.0);
        Persona p7 = new Persona(7, "Alberto", LocalDate.of(1977, 6, 6), 21, 1500.0);
        Persona p8 = new Persona(8, "Carlos", LocalDate.of(1980, 9, 22), 19, 1350.0);
        
        List<Persona> personas = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
        
        System.out.println("**************************************************");
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i).toString());
        }
        
        System.out.println("**************************************************");
        personas.forEach(p -> System.out.println(p.toString()));
        
        System.out.println("**************************************************");
        personas.forEach(System.out::println);
        
        System.out.println("**************************************************");
        personas.forEach(p -> {
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Fecha de nacimiento: " + p.getFechaNac());
            System.out.println("Experiencia: " + p.getExperiencia());
            System.out.println("Salario: " + p.getSalario());
        });
        
        
        System.out.println("**************************************************");
        System.out.println("***************** STREAMS ************************");
        System.out.println("**************************************************");
        
        System.out.println("**************************************************");
        for (Persona p: personas) {
            if (p.getEdad() >= 18) {
                System.out.println(p.toString());
            }
        }
        
        System.out.println("***************** FILTER ************************");
        System.out.println("**************************************************");
        List<Persona> personasFiltrada = personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .collect(Collectors.toList());
        personasFiltrada.forEach(System.out::println);
        
        System.out.println("**************************************************");
        personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        Predicate<Persona> esMayor = p -> p.getEdad() >= 18;
        personas.stream()
                .filter(esMayor)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("");
        System.out.println("******************* MAP ***************************");
        System.out.println("**************************************************");
        List<Integer> edades = personas.stream()
                .map(p -> p.getEdad())
                .collect(Collectors.toList());
        edades.forEach(System.out::println);
        
        System.out.println("**************************************************");
        Function<Persona, Integer> extraerEdadFunction = p -> p.getEdad();
        personas.stream()
                .map(extraerEdadFunction)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        List<Alumno> alumnos = personas.stream()
                .filter(p -> p.getEdad() < 18)
                .map(p -> new Alumno(p.getNombre(), p.getEdad()))
                .collect(Collectors.toList());
        alumnos.forEach(System.out::println);
        
        System.out.println("");
        System.out.println("******************* SORTED ***********************");
        System.out.println("**************************************************");
        Comparator<Persona> ordenaNombreAsc = (o1, o2) -> o1.getNombre().compareTo(o2.getNombre());
        personas.stream()
                .sorted(ordenaNombreAsc)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        Comparator<Persona> ordenaNombreDesc = (o1, o2) -> o2.getNombre().compareTo(o1.getNombre());
        personas.stream()
                .sorted(ordenaNombreDesc)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        Comparator<Persona> ordenarFechaNacAsc = (o1, o2) -> o1.getFechaNac().compareTo(o2.getFechaNac());
        personas.stream()
                .sorted(ordenarFechaNacAsc)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        personas.stream()
                .filter(esMayor)
                .sorted(ordenarFechaNacAsc)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        
        System.out.println("");
        System.out.println("******************* Match ************************");
        System.out.println("**************************************************");
        boolean encontro = false;
        for (Persona p: personas) {
            if (p.getNombre().startsWith("A")) {
                encontro = true;
                break;
            }
        }
        System.out.println(encontro);
        
        System.out.println("**************************************************");
        boolean resultado = personas.stream()
                .anyMatch(p -> p.getNombre().startsWith("A"));
        System.out.println(resultado);
        
        resultado = personas.stream()
                .allMatch(p -> p.getNombre().startsWith("A"));
        System.out.println(resultado);
        
        resultado = personas.stream()
                .noneMatch(p -> p.getNombre().startsWith("A"));
        System.out.println(resultado);
        
        System.out.println("");
        System.out.println("***************** LIMIT / SKIP********************");
        System.out.println("**************************************************");
        personas.stream()
                .skip(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        personas.stream()
                .limit(4)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        personas.stream()
                .sorted(ordenaNombreAsc)
                .limit(4)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        int pagina = 2;
        int tamPagina = 3;
        personas.stream()
                .sorted(ordenaNombreAsc)
                .skip((pagina - 1) * tamPagina)
                .limit(tamPagina)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        
        System.out.println("");
        System.out.println("***************** COLLECTORS  ********************");
        System.out.println("**************************************************");
        Map<Integer, List<Persona>> agrupado = personas.stream()
                .filter(p -> p.getExperiencia() > 15)
                .collect(Collectors.groupingBy(Persona::getExperiencia));
        System.out.println(agrupado);
        
        System.out.println("**************************************************");
        Map<Integer, Long> agrupado2 = personas.stream()
                .filter(p -> p.getExperiencia() > 15)
                .collect(Collectors.groupingBy(Persona::getExperiencia, Collectors.counting()));
        System.out.println(agrupado2);
        
        System.out.println("**************************************************");
        Map<Integer, Double> agrupado3 = personas.stream()
                .filter(p -> p.getExperiencia() > 15)
                .collect(Collectors.groupingBy(Persona::getExperiencia, Collectors.summingDouble(Persona::getSalario)));
        System.out.println(agrupado3);
        
        System.out.println("**************************************************");
        DoubleSummaryStatistics statistics1 = personas.stream()
                .collect(Collectors.summarizingDouble(Persona::getExperiencia));
        System.err.println(statistics1);
        
        DoubleSummaryStatistics statistics2 = personas.stream()
                .collect(Collectors.summarizingDouble(Persona::getSalario));
        System.err.println(statistics2);
    }
}
