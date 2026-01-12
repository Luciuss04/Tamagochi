package org.example;

import java.util.Scanner;

public class Main {

    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;
    static boolean vivo = true;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            opcion = menuPrincipal();

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
                    banar();
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    break;
            }

            if (opcion != 0 && vivo) pausa();

        } while (opcion != 0 && vivo);

        System.out.println("Juego terminado.");
    }

    private static int menuPrincipal() {

        int opcion;

        do {
            System.out.println("\n1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("5. Bañar");
            System.out.println("----------------");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion del menu: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Seleccione una opcion valida: ");
            }

            opcion = sc.nextInt();

        } while (opcion < 0 || opcion > 5);

        return opcion;
    }

    private static void mostrarEstado() {

        System.out.println("\nESTADO ACTUAL");
        System.out.println("Saciedad : " + saciedad + "/10");
        System.out.println("Energia  : " + energia + "/10");
        System.out.println("Diversion: " + diversion + "/10");

        // FIN DEL JUEGO
        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("(x_x) :( Game Over ):");
            System.out.println(" /|_|\\");
            System.out.println("  | |");
            vivo = false;
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
            System.out.println("(•︵•) ¡Tengo hambre!");
            System.out.println(" /|x|\\");
            System.out.println("  | |");
            return;
        }

        // ESTADO NORMAL
        System.out.println("(^_^) Estoy normal");
        System.out.println(" /|_|\\");
        System.out.println("  | |");
    }

    private static void comer() {

        System.out.println("\nAccion: COMER");

        if (saciedad >= 10) {
            System.out.println("No tengo hambre");
        } else {
            System.out.println("Saciedad  +3");
            System.out.println("Diversion -1");

            saciedad += 3;
            diversion -= 1;

            if (saciedad > 10) saciedad = 10;
            if (diversion < 0) diversion = 0;
        }

        mostrarEstado();
    }

    private static void jugar() {

        System.out.println("\nAccion: JUGAR");

        if (diversion >= 10) {
            System.out.println("Ahora no me apetece jugar");
        } else {
            System.out.println("Diversion +3");
            System.out.println("Saciedad  -1");
            System.out.println("Energia   -1");

            diversion += 3;
            saciedad -= 1;
            energia -= 1;

            if (diversion > 10) diversion = 10;
            if (saciedad < 0) saciedad = 0;
            if (energia < 0) energia = 0;
        }

        mostrarEstado();
    }

    private static void dormir() {

        System.out.println("\nAccion: DORMIR");

        if (energia >= 10) {
            System.out.println("No tengo sueño");
        } else {
            System.out.println("Energia   +3");
            System.out.println("Saciedad  -3");
            System.out.println("Diversion -2");

            energia += 3;
            saciedad -= 3;
            diversion -= 2;

            if (energia > 10) energia = 10;
            if (saciedad < 0) saciedad = 0;
            if (diversion < 0) diversion = 0;
        }

        mostrarEstado();
    }

    private static void banar() {

        System.out.println("\nAccion: BAÑAR");

        System.out.println("Diversion +2");
        System.out.println("Energia   -1");

        diversion += 2;
        energia -= 1;

        if (diversion > 10) diversion = 10;
        if (energia < 0) energia = 0;

        mostrarEstado();
    }

    private static void pausa() {
        System.out.println("\nPulsa ENTER para continuar...");
        sc.nextLine();
        sc.nextLine();
    }
}
