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

            System.out.printf("\n Stai prenotando l'evento : %s ", event.toString());

            System.out.print("\n Quanti posti vuoi orenotare  per l'evento ? ");
            int postiDaPrenotare = scan.nextInt();

            event.prenota(postiDaPrenotare);

        }

    }
}
