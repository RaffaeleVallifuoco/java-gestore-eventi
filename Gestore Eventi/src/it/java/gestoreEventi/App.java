package it.java.gestoreEventi;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n - TICKETRAFFO - \n");

        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean inputValido = false;
        LocalDateTime dataEventoFormattata = null;
        boolean validInput = false;
        boolean ripeti = true;

        // istanzio evento generico che verrà specificato in seguito

        Evento newEvent = null;

        System.out.println("\n A quale servizio sei interessato ? \n");

        while (!inputValido) {
            System.out.println(
                    "\n [1] INSERISCI UN NUOVO EVENTO   |  [2]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'BABY K - Donna Sulla Luna  •Milano S.Siro(07/07/2025)'' |1n|   [3]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'E FUORI NEVICA prima teatrale (04/08/1999)'' \n");
            System.out.println(
                    "\n -------- ! INSERIRE IL NUMERO CORRISPONDENTE ALLA SCELTA DESIDERATA | ------------- \n");

            String choice = scan.nextLine();

            // controllo validità imput utente

            if (choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("3")) {

                inputValido = true;

                switch (choice) {
                    case "1": // NUOVO INSERIMENTO

                        System.out.println(
                                "\n Che tipo di evento vuoi inserire ?  [1]  Concerto  |  [2]  Evento generico  \n ");
                        String inserimento = scan.nextLine();

                        switch (inserimento) {
                            case "1": // NUOVO CONCERTO

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy.HH:mm");

                                System.out.print("\n Inserisci il nome dell'evento :  ");
                                String nomeEvento = input.nextLine();

                                // LocalDateTime dataEventoFormattata = null;
                                // boolean validInput = false;

                                while (!validInput) {
                                    System.out.print(
                                            "\n Inserisci la data dell'evento ( FORMATO (dd/MM/yyyy.HH:mm) :  ");
                                    String dataEvento = scan.nextLine();

                                    try {

                                        dataEventoFormattata = LocalDateTime.parse(dataEvento, formatter);
                                        validInput = true;
                                    } catch (DateTimeParseException e) {
                                        System.err.println(
                                                "\n Formato data non valido. Per favore, inserisci un valore corretto.\n");
                                    }
                                }

                                System.out.print("\n Inserisci il prezzo del biglietto :  ");
                                double prezzoConcerto = input.nextDouble();
                                input.nextLine();

                                System.out.print("\n Inserisci i posti disponibili per l'evento : \n");
                                int postiDisponibili = input.nextInt();
                                input.nextLine();

                                System.out.println("\n ... inserimento in corso (wait a second) ... \n");

                                try {
                                    // Pausa di 2 secondi (2000 millisecondi)
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                }

                                newEvent = new Concerto(nomeEvento, dataEventoFormattata, prezzoConcerto,
                                        postiDisponibili);

                                break;

                            case "2": // NUOVO EVENTO GENERICO

                                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy.HH:mm");
                                System.out.print("\n Inserisci il nome dell'evento :  ");
                                nomeEvento = scan.nextLine();
                                scan.nextLine();

                                dataEventoFormattata = null;
                                validInput = false;

                                while (!validInput) {
                                    System.out.print(
                                            "\n Inserisci la data dell'evento ( FORMATO (dd/MM/yyyy.HH:mm) :  ");
                                    String dataEvento = scan.nextLine();

                                    try {

                                        dataEventoFormattata = LocalDateTime.parse(dataEvento, formatter);
                                        validInput = true;
                                    } catch (DateTimeParseException e) {
                                        System.err.println(
                                                "\n -Formato data non valido. Per favore, inserisci un valore corretto-\n");
                                    }
                                }

                                System.out.print("\n Inserisci i posti disponibili per l'evento : ");
                                postiDisponibili = input.nextInt();
                                input.nextLine();

                                System.out.println("\n ... inserimento in corso (wait a second) ... \n");

                                try {
                                    // Pausa di 2 secondi (2000 millisecondi)
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                }

                                newEvent = new Evento(nomeEvento, dataEventoFormattata, postiDisponibili);

                                break;

                        }

                        break;

                    case "2": // CONCERTO BABY K
                        boolean validator = false;

                        System.out.println(
                                "\n A che posto sei interessato ? ( [1] PRATO  | [2] I ANELLO  |  [3] TRIBUNA)");
                        String ticketChoice = input.nextLine();

                        while (!validator) {

                            switch (ticketChoice.toLowerCase()) {
                                case "1":

                                    newEvent = new ConcertoPrato();
                                    validator = true;

                                    break;

                                case "2":

                                    newEvent = new ConcertoIAnello();
                                    validator = true;

                                    break;

                                case "3":

                                    newEvent = new ConcertoTribuna();
                                    validator = true;

                                    break;

                                default:
                                    System.out.println("\n Scelta non corretta \n");
                                    break;
                            }
                        }

                        break;

                    case "3": // E FUORI NEVICA

                        newEvent = new SpettacoloTeatrale();

                        break;

                    default:
                        System.err.println("\n Scelta non corretta \n");
                        break;
                }

                // STAMPA INFO E AVVIA FUNZIONI DI PRENOTAZIONE

                if (newEvent != null) {

                    try {
                        // Pausa di 0,5 secondi (500 millisecondi)
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }

                    System.out.printf("\n Hai scelto : %s \n", newEvent.toString());

                    while (ripeti) {

                        System.out.println(
                                "\n Cosa vuoi fare : [1]  PRENOTA UN BIGLIETTO  |  [2]  DISDICI UN BIGLIETTO \n");

                        String ticketChoice = input.nextLine();

                        switch (ticketChoice.toLowerCase()) {
                            case "1":
                                System.out.printf(
                                        "\n Posti disponibili per l'evento selezionato : %s  |  Posti attualmente prenotati : %s \n",
                                        newEvent.getPostiDisponibili(), newEvent.getPostiPrenotati());

                                newEvent.prenota();
                                break;

                            case "2":
                                System.out.printf(
                                        "\n Posti disponibili per l'evento selezionato : %s  |  Posti attualmente prenotati : %s \n",
                                        newEvent.getPostiDisponibili(), newEvent.getPostiPrenotati());

                                newEvent.disdici();
                                break;

                            default:
                                System.err.println("\n Scelta non corretta \n");
                                break;

                        }

                        System.out.println(
                                "\n Vuoi prenotare / disdire un altro posto per l'evento selezionato ? \n [SI]  [NO] ");

                        String sceltaRipeti = scan.nextLine();

                        if (sceltaRipeti.compareToIgnoreCase("no") == 0) {
                            ripeti = false;

                            System.out.println("\n\n ---- Uscita dal programma in corso ... ---\n\n");

                            try {
                                // Pausa di 2 secondi (2000 millisecondi)
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                            }

                            System.out.println("\n TICKETRAFFO -> GOODBYE \n");
                        }

                    }
                } else {
                    System.err.println("Errore: l'input non è valido. Riprova.");
                }
            }

        }
        scan.close();
        input.close();

    }

}
