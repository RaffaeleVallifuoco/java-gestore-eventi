package it.java.gestoreEventi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n - TICKETRAFFO - \n");

        Scanner scan = new Scanner(System.in);
        boolean inputValido = false;

        System.out.println("\n A quale evento sei interessato ? \n");

        while (!inputValido) {
            System.out.println(
                    "\n Eventi disponibili :    COLDPLAY concerto evento Milano S.Siro(07/07/2025)   |    E FUORI NEVICA prima teatrale (04/08/1999) \n");
            System.out.println("\n ! INSERIRE SOLO NOME EVENTO (coldplay / efuorinevica) SENZA SPAZI ! \n");

            String choice = scan.nextLine();

            // istanzio evento generico che verrà specificato in seguito

            Evento newEvent = null;

            // controllo validità imput utente

            if (choice.equalsIgnoreCase("coldplay") || choice.equalsIgnoreCase("efuorinevica")) {
                inputValido = true;

                switch (choice.toLowerCase()) {
                    case "efuorinevica":

                        newEvent = new SpettacoloTeatrale();

                        break;

                    case "coldplay":

                        System.out.println("\n A che posto sei interessato ? (PRATO  |  I ANELLO  |  TRIBUNA)");
                        String ticketChoice = scan.nextLine();

                        switch (ticketChoice.toLowerCase()) {
                            case "prato":

                                newEvent = new ConcertoPrato();

                                break;

                            case "ianello":

                                newEvent = new ConcertoIAnello();

                                break;

                            case "tribuna":

                                newEvent = new ConcertoTribuna();

                                break;

                            default:
                                System.out.println("\n Scelta non corretta \n");
                                break;
                        }

                        break;

                    default:
                        System.out.println("\n Scelta non corretta \n");
                        break;
                }

                if (newEvent != null) {

                    System.out.printf("\n Hai scelto : %s ", newEvent.toString());

                }

            } else {
                System.out.println("Errore: l'input non è valido. Riprova.");
            }
        }
    }

    // if (choice.equalsIgnoreCase("")) {

    // Evento event = new ConcertoPrato();

    // System.out.printf("\n Stai prenotando : %s ", event.toString());

    // System.out.print("\n Quanti posti vuoi orenotare per l'evento ? ");
    // int postiDaPrenotare = scan.nextInt();

    // event.prenota(postiDaPrenotare);

    // }

    // }
}
