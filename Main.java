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
            case 3:
                jugar();
                break;
            case 4:
                dormir();
                break;
            case 5:
                bañar();
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
            System.out.println("5. Bañar");
            System.out.println("----------------");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción del menú: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Seleccione una opción válida: ");
            }

            opcion = sc.nextInt();

        } while (opcion < 0 || opcion > 5);

        return opcion;
    }

    private static void mostrarEstado() {

        // FIN DEL JUEGO
        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("(x_x) :( Game Over ):");
            System.out.println(" /|_|\\");
            System.out.println("  | |");
            return;
        }

        // CONTENTO
        if (saciedad > 5 && energia > 5 && diversion > 5) {
            System.out.println("(•‿•) ¡Estoy feliz!");
            System.out.println(" /|_|\\");
            System.out.println("  | |");
            return;
        }

        // TRISTE
        if (diversion <= 4) {
            System.out.println("(-︵-) Estoy aburrido");
            System.out.println(" /|_|\\ ¡Juega conmigo!");
            System.out.println(" / \\");
            return;
        }

        // CANSADO
        if (energia <= 4) {
            System.out.println("(-_-) Zzz");
            System.out.println(" /|_|\\");
            System.out.println("  | |");
            return;
        }

        // HAMBRIENTO
        if (saciedad <= 4) {
            System.out.println("(•︵•) ¡Tengo hambre! 🍗");
            System.out.println(" /|x|\\");
            System.out.println("  | |");
            return;
        }
    }

    private static void comer() {

        if (saciedad >= 10) {
            System.out.println("No tengo hambre");
        } else {
            saciedad += 3;
            if (saciedad > 10) saciedad = 10;

            diversion -= 1;
            if (diversion < 0) diversion = 0;

            System.out.println("🍽️ El tamagotchi ha comido");
        }

        mostrarEstado();
    }

    private static void jugar() {

        if (diversion >= 10) {
            System.out.println("Ahora no me apetece jugar");
        } else {
            diversion += 3;
            if (diversion > 10) diversion = 10;

            saciedad -= 1;
            energia -= 1;

            if (saciedad < 0) saciedad = 0;
            if (energia < 0) energia = 0;

            System.out.println(" El tamagotchi ha jugado");
        }

        mostrarEstado();
    }

    private static void dormir() {

        if (energia >= 10) {
            System.out.println("No tengo sueño");
        } else {
            energia += 3;
            if (energia > 10) energia = 10;

            saciedad -= 3;
            diversion -= 2;

            if (saciedad < 0) saciedad = 0;
            if (diversion < 0) diversion = 0;

            System.out.println(" El tamagotchi ha dormido");
        }

        mostrarEstado();
    }

    private static void bañar() {

        System.out.println(" El tamagotchi se está bañando...");

        diversion += 2;
        if (diversion > 10) diversion = 10;

        energia -= 1;
        if (energia < 0) energia = 0;

        System.out.println(" El tamagotchi está limpio y feliz");

        mostrarEstado();
    }
}
