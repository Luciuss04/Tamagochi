package org.example;

public class Main {

    public static void main(String[] args) {
        int opcion = menuPrincipal();
        System.out.println("Opción elegida: " + opcion);
    }

    private static int menuPrincipal() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("----------------");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción del menú: ");

        while (!sc.hasNextInt()) {
            System.out.println("Opción no válida. Introduzca un número.");
            sc.next(); // descartar entrada incorrecta
            System.out.print("Seleccione una opción del menú: ");
        }

        opcion = sc.nextInt();

        if (opcion < 0 || opcion > 4) {
            System.out.println("Opción no válida. Inténtelo de nuevo.\n");
        }

    } while (opcion < 0 || opcion > 4);

    return opcion;
}
