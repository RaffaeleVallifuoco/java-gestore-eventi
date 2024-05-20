package it.java.gestoreEventi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n - PRENOTAZIONE EVENTI - \n");

        Scanner scan = new Scanner(System.in);

        System.out.println("\n Vuoi prenotare l'evento ? \n");

        String choice = scan.nextLine();

        if (choice.equalsIgnoreCase("si")) {

            Evento event = new Evento("concerto");

            event.toString();

        }

    }
}
