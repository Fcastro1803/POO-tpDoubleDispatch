package org.example.ejer1;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    // Opciones posibles
    private String[] opciones = {"piedra", "papel", "tijera"};
    // Crear un objeto Scanner para leer la entrada del usuario
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            Elemento eleccionUsuario = elegirElementoUsuario(scanner);
            Elemento eleccionComputadora = elegirElementoComputadora();
            // DOBLE DESPACHO
            // eleccionUsuario inicia el juego pasándole la pelota a eleccionComputadora
            String resultado = eleccionUsuario.competirCon(eleccionComputadora);
            System.out.println("Resultado: " + resultado);
            continuar = preguntarSiQueremosContinuar();
        }// end while
        System.out.println("¡Hasta pronto!");
        scanner.close();
    }

    private Elemento elegirElementoUsuario(Scanner scanner) {
        System.out.println("Elige una opción: 1 (Piedra), 2 (Papel) o 3 (Tijera)");
        String eleccion = scanner.nextLine().trim();

        // Mapeamos la entrada del usuario a las nuevas clases
        switch (eleccion) {
            case "1": case "piedra": return new Piedra();
            case "2": case "papel":  return new Papel();
            case "3": case "tijera": return new Tijera();
            default:
                System.out.println("Opción inválida, se elige Piedra por defecto.");
                return new Piedra();
        }
    }

    // Lo mismo para la computadora
    private Elemento elegirElementoComputadora() {
        Random random = new Random();
        int indice = random.nextInt(3);

        if (indice == 0) return new Piedra();
        if (indice == 1) return new Papel();
        return new Tijera();
    }

    private boolean preguntarSiQueremosContinuar() {
        System.out.println("¿Desea continuar? s/n");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        return respuesta.toLowerCase().charAt(0) == 's';
    }
}
