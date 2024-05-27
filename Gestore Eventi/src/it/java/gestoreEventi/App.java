package it.java.gestoreEventi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("\n - TICKETRAFFO © - \n");

        Manager.pausa(2);

        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        ProgrammaEventi listaEventi = new ProgrammaEventi("Eventy TICKETRAFFO ©");
        Evento newEvent = null; // istanzio evento generico che verrà specificato in seguito
        boolean inputValido = false;
        boolean ripeti = true;

        System.out.println("\n A quale servizio sei interessato ? \n");

        Manager.pausa(1000);

        while (!inputValido) {
            System.out.println(
                    "\n [1] INSERISCI UN NUOVO EVENTO   |  [2]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'BABY K - Donna Sulla Luna  •Milano S.Siro(07/07/2025)'' |\n|   [3]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'E FUORI NEVICA prima teatrale (04/08/1999)'' \n");
            System.out.println(
                    "\n -------- ! INSERIRE IL NUMERO CORRISPONDENTE ALLA SCELTA DESIDERATA | ------------- \n");

            String choice = scan.nextLine();

            // controllo validità imput utente

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {

                inputValido = true;

                switch (choice) {
                    case "1": // NUOVO INSERIMENTO

                        System.out.println(
                                "\n Che tipo di evento vuoi inserire ?  [1]  Concerto  |  [2]  Evento generico  \n ");
                        String inserimento = scan.nextLine();

                        switch (inserimento) {
                            case "1": // NUOVO CONCERTO

                                Manager.inputEvento();

                                System.out.print("\n Inserisci il prezzo del biglietto :  ");
                                double prezzoConcerto = input.nextDouble();
                                input.nextLine();

                                System.out.println("\n ... inserimento in corso (please wait) ... \n");

                                Manager.pausa(2000);

                                newEvent = new Concerto(Manager.nomeEvento, Manager.dataEventoFormattata,
                                        prezzoConcerto,
                                        Manager.postiDisponibili);

                                break;

                            case "2": // NUOVO EVENTO GENERICO

                                newEvent = new Evento(Manager.nomeEvento, Manager.dataEventoFormattata,
                                        Manager.postiDisponibili);

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

                    listaEventi.aggiungiEvento(newEvent); // AGGIUNGI EVENTO AD ARRAYLIST EVENTI IN PTOGRAMMA

                    Manager.pausa(500);

                    System.out.printf("\n Hai scelto : %s \n", newEvent.toString());

                    while (ripeti) {
                        Manager.pausa(500);
                        System.out.printf(
                                "\n Posti disponibili per l'evento selezionato : %s  |  Posti attualmente prenotati : %s \n",
                                newEvent.getPostiDisponibili(), newEvent.getPostiPrenotati());

                        System.out.println(
                                "\n Cosa vuoi fare : [1]  PRENOTA UN BIGLIETTO  |  [2]  DISDICI UN BIGLIETTO \n");

                        String ticketChoice = input.nextLine();

                        switch (ticketChoice.toLowerCase()) {
                            case "1":
                                System.out.printf(
                                        "\n Posti ora disponibili per l'evento selezionato : %s  |  Posti attualmente prenotati : %s \n",
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
                                "\n Vuoi prenotare / disdire un altro posto per l'evento selezionato ? \n [S]  [N] ");

                        String sceltaRipeti = scan.nextLine();

                        if (sceltaRipeti.compareToIgnoreCase("n") == 0) {
                            ripeti = false;

                            Manager.listaEventi(listaEventi);

                            System.out.println("\n\n ---- Uscita dal programma in corso ... ---\n\n");

                            Manager.pausa(3000);

                            System.out.println("\n TICKETRAFFO © -> GOODBYE \n");
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
