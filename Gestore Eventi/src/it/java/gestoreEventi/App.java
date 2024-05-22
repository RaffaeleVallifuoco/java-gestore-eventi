package it.java.gestoreEventi;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n - TICKETRAFFO - \n");

        Scanner scan = new Scanner(System.in);
        boolean inputValido = false;
        LocalDateTime dataEventoFormattata = null;
        boolean validInput = false;

        System.out.println("\n A quale servizio sei interessato ? \n");

        while (!inputValido) {
            System.out.println(
                    "\n [1] INSERISCI UN NUOVO EVENTO   |  [2]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'BABY K - Donna Sulla Luna  •Milano S.Siro(07/07/2025)''   |   [3]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'E FUORI NEVICA prima teatrale (04/08/1999)'' \n");
            System.out.println(
                    "\n -------- ! INSERIRE IL NUMERO CORRISPONDENTE ALLA SCELTA DESIDERATA | ------------- \n");

            int choice = scan.nextInt();

            // istanzio evento generico che verrà specificato in seguito

            Evento newEvent = null;

            // controllo validità imput utente

            if (choice == 1 || choice == 2 || choice == 3) {

                inputValido = true;

                switch (choice) {
                    case 1: // NUOVO INSERIMENTO

                        System.out.println(
                                "\n Che stipo di evento vuoi inserire ?  [1]  Concerto  |  [2]  Evento generico  \n ");
                        int inserimento = scan.nextInt();

                        switch (inserimento) {
                            case 1: // NUOVO CONCERTO

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy.HH:mm");

                                System.out.print("\n Inserisci il nome dell'evento :  ");
                                String nomeEvento = scan.nextLine();
                                scan.nextLine();

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
                                        System.out.println(
                                                "\n Formato data non valido. Per favore, inserisci un valore corretto.\n");
                                    }
                                }

                                System.out.print("\n Inserisci il prezzo del biglietto :  ");
                                double prezzoConcerto = scan.nextDouble();
                                scan.nextLine();

                                System.out.print("\n Inserisci i posti disponibili per l'evento : ");
                                int postiDisponibili = scan.nextInt();

                                System.out.println("\n ... inserimento in corso (wait a second) ... \n");

                                newEvent = new Concerto(nomeEvento, dataEventoFormattata, prezzoConcerto,
                                        postiDisponibili);

                                break;

                            case 2: // NUOVO EVENTO GENERICO

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
                                        System.out.println(
                                                "\n Formato data non valido. Per favore, inserisci un valore corretto.\n");
                                    }
                                }

                                System.out.print("\n Inserisci i posti disponibili per l'evento : ");
                                postiDisponibili = scan.nextInt();

                                System.out.println("\n ... inserimento in corso (wait a second) ... \n");

                                newEvent = new Evento(nomeEvento, dataEventoFormattata, postiDisponibili);

                                break;

                        }

                        break;

                    case 2: // CONCERTO BABY K
                        boolean validator = false;

                        System.out.println("\n A che posto sei interessato ? (PRATO  |  I ANELLO  |  TRIBUNA)");
                        Scanner input = new Scanner(System.in);
                        String ticketChoice = input.nextLine();

                        while (!validator) {

                            switch (ticketChoice.toLowerCase()) {
                                case "prato":

                                    newEvent = new ConcertoPrato();
                                    validator = true;

                                    break;

                                case "ianello":

                                    newEvent = new ConcertoIAnello();
                                    validator = true;

                                    break;

                                case "tribuna":

                                    newEvent = new ConcertoTribuna();
                                    validator = true;

                                    break;

                                default:
                                    System.out.println("\n Scelta non corretta \n");
                                    break;
                            }
                        }

                        break;

                    case 3: // E FUORI NEVICA

                        newEvent = new SpettacoloTeatrale();

                        break;

                    default:
                        System.out.println("\n Scelta non corretta \n");
                        break;
                }

                // STAMPA INFO E AVVIA FUNZIONI DI PRENOTAZIONE

                if (newEvent != null) {

                    System.out.printf("\n Hai scelto : %s \n", newEvent.toString());

                    System.out.println(
                            "\n Cosa vuoi fare : PRENOTA UN BIGLIETTO  (digita : prenota) |   DISDICI UN BIGLIETTO (digita : disdici) \n");

                    scan.nextLine();
                    String ticketChoice = scan.nextLine();

                    switch (ticketChoice.toLowerCase()) {
                        case "prenota":
                            System.out.printf(
                                    "Posti disponibili per l'evento selezionato : %s  |  Posti attualmente prenotati : %s \n",
                                    newEvent.getPostiDisponibili(), newEvent.getPostiPrenotati());

                            newEvent.prenota();
                            break;

                        case "disdici":
                            System.out.printf(
                                    "Posti disponibili per l'evento selezionato : %s  |  Posti attualmente prenotati : %s \n",
                                    newEvent.getPostiDisponibili(), newEvent.getPostiPrenotati());

                            newEvent.disdici();
                            break;

                        default:
                            System.out.println("\n Scelta non corretta \n");
                            break;

                    }

                }

            } else {
                System.out.println("Errore: l'input non è valido. Riprova.");
            }
        }
        scan.close();
    }

}
