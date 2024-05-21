package it.java.gestoreEventi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n - TICKETRAFFO - \n");

        Scanner scan = new Scanner(System.in);

        System.out.println("\n A quale evento sei interessato ? \n");
        System.out.println(
                "\n Eventi disponibili :    COLDPLAY concerto evento Milano S.Siro(07/07/2025)   |    E FUORI NEVICA prima teatrale (04/08/1999) \n");
        System.out.println("\n ! INSERIRE SOLO NOME EVENTO (coldplay / efuorinevica) SENZA SPAZI ! \n");

        String choice = scan.nextLine();

        if (choice.equalsIgnoreCase("")) {

            Evento event = new ConcertoPrato();

            System.out.printf("\n Stai prenotando : %s ", event.toString());

            System.out.print("\n Quanti posti vuoi orenotare  per l'evento ? ");
            int postiDaPrenotare = scan.nextInt();

            event.prenota(postiDaPrenotare);

        }

    }
}
