package org.example;

public class Main {

    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;

    public static void main(String[] args) {

        int opcion = menuPrincipal();

        switch (opcion) {
            case 1:
                mostrarEstado();
                break;
            case 2:
                comer();
                break;
            case 0:
                System.out.println("Saliendo del juego...");
                break;
        }
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
                sc.next();
                System.out.print("Seleccione una opción válida: ");
            }

            opcion = sc.nextInt();

        } while (opcion < 0 || opcion > 4);

        return opcion;
    }

    private static void mostrarEstado() {

        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("💀 FIN DEL JUEGO");
        } else if (saciedad > 5 && energia > 5 && diversion > 5) {
            System.out.println("😄 TAMAGOTCHI CONTENTO");
        } else if (diversion <= 4) {
            System.out.println("😢 TAMAGOTCHI TRISTE");
        } else if (energia <= 4) {
            System.out.println("😴 TAMAGOTCHI CANSADO");
        } else if (saciedad <= 4) {
            System.out.println("🍽️ TAMAGOTCHI HAMBRIENTO");
        }
    }

    private static void comer() {

        if (saciedad >= 10) {
            System.out.println("No tengo hambre");
        } else {
            saciedad += 3;
            if (saciedad > 10) {
                saciedad = 10;
            }
            diversion -= 1;
            System.out.println("🍽️ El tamagotchi ha comido");
        }
    }
}
