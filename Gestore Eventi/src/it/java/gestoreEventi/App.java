package it.java.gestoreEventi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Manager.pausa(5000); // Pausa necessaria per aprire il terminale :)

        System.out.println("\n \u001B[36m - TICKETRAFFO © - \u001B[0m"); // ciano - reset

        Manager.pausa(100);

        System.out.println(" \u001B[33m     Welcome \u001B[0m \n"); // SPAZI NECESSARI PER CENTRATURA CARATTERI

        Manager.pausa(2000);

        // GLOBAL VAR.

        Scanner scan = new Scanner(System.in); // SCANNER PER INPUT STRING
        Scanner input = new Scanner(System.in); // SCANNER PER INPUT INT E DOUBLE
        ProgrammaEventi listaEventi = new ProgrammaEventi("\n \u001B[32m Eventy TICKETRAFFO ©\u001B[0m \n");
        Evento newEvent = null; // istanzio evento generico che verrà specificato in seguito
        boolean inputValido = false;
        boolean ripeti = true;

        System.out.println("\n A quale servizio sei interessato ? \n");

        Manager.pausa(500);

        while (!inputValido) { // LOOP RIPETIZIONE SCELTA IN CASO DI INPUT NON VALIDO
            System.out.println(
                    "\n [1] INSERISCI UN NUOVO EVENTO   |  [2]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'BABY K - Donna Sulla Luna  •Milano S.Siro(07/07/2025)'' |\n| [3]  PRENOTA O DISDICI UN TICKET PER L'EVENTO :  'E FUORI NEVICA prima teatrale (04/08/1999)'' \n");
            System.out.println(
                    "\n \u001B[35m -------- ! INSERIRE IL NUMERO CORRISPONDENTE ALLA SCELTA DESIDERATA | ------------- \u001B[0m \n");

            String choice = scan.nextLine();

            // controllo validità imput utente

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {

                inputValido = true;

                switch (choice) { // SWITCH SCELTA UTENTE

                    case "1": // NUOVO INSERIMENTO

                        System.out.println(
                                "\n Che tipo di evento vuoi inserire ?  [1]  Concerto  |  [2]  Evento generico  \n ");
                        String inserimento = scan.nextLine();

                        switch (inserimento) {

                            case "1": // NUOVO CONCERTO

                                Manager.inputEvento();
                                boolean validDouble = false;
                                double prezzoConcerto = 0;

                                while (!validDouble) {
                                    try {
                                        System.out.print("\n Inserisci il prezzo del biglietto :  ");
                                        prezzoConcerto = input.nextDouble();

                                        validDouble = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("\n \u001B[31m !! Prezzo non valido!!\u001B[0m\n");
                                        input.nextLine(); // Clear the invalid input
                                    }
                                }

                                System.out.println("\n ... inserimento in corso (please wait) ... \n");

                                Manager.pausa(2000);

                                // CREAZIONE OGGETTO DI TIPO EVENTO CON COSTRUTTORE SPECIFICO

                                newEvent = new Concerto(Manager.nomeEvento, Manager.dataEventoFormattata,
                                        prezzoConcerto,
                                        Manager.postiDisponibili);

                                break;

                            case "2": // NUOVO EVENTO GENERICO

                                Manager.inputEvento();

                                // CREAZIONE OGGETTO DI TIPO EVENTO CON COSTRUTTORE SPECIFICO

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

                                    // CREAZIONE OGGETTO DI TIPO EVENTO CON COSTRUTTORE SPECIFICO

                                    newEvent = new ConcertoPrato();

                                    validator = true;

                                    break;

                                case "2":

                                    // CREAZIONE OGGETTO DI TIPO EVENTO CON COSTRUTTORE SPECIFICO

                                    newEvent = new ConcertoIAnello();

                                    validator = true;

                                    break;

                                case "3":

                                    // CREAZIONE OGGETTO DI TIPO EVENTO CON COSTRUTTORE SPECIFICO

                                    newEvent = new ConcertoTribuna();

                                    validator = true;

                                    break;

                                default:
                                    System.out.println("\n\u001B[31m !! Scelta non corretta !! \u001B[0m \n");
                                    break;
                            }
                        }

                        break;

                    case "3": // E FUORI NEVICA

                        // CREAZIONE OGGETTO DI TIPO EVENTO CON COSTRUTTORE SPECIFICO

                        newEvent = new SpettacoloTeatrale();

                        break;

                    default:
                        System.err.println("\n \u001B[31m !!  Scelta non corretta !!\u001B[0m \n");
                        break;
                }

                // STAMPA INFO E AVVIA FUNZIONI DI PRENOTAZIONE

                if (newEvent != null) { // CHECK INIZIALIZZAZIONE EVENTO CREATO

                    listaEventi.aggiungiEvento(newEvent); // AGGIUNGI EVENTO AD ARRAYLIST EVENTI IN PTOGRAMMA

                    Manager.pausa(500);

                    System.out.printf("\n Hai scelto : %s \n", newEvent.toString());

                    while (ripeti) { // LOOP PRENOTAZIONE

                        Manager.pausa(500);

                        System.out.printf(
                                "\n \u001B[35m• Posti disponibili per l'evento selezionato : %s  |  Posti attualmente prenotati : %s \u001B[0m \n",
                                newEvent.getPostiDisponibili(), newEvent.getPostiPrenotati());

                        System.out.println(
                                "\n Cosa vuoi fare : [1]  PRENOTA UN BIGLIETTO  |  [2]  DISDICI UN BIGLIETTO \n");

                        String ticketChoice = scan.nextLine();

                        // SWITCH INPUT

                        switch (ticketChoice.toLowerCase()) { // NEW SWITCH SINTAX (TIPS FROM ORACLE JAVA EXTENSION FOR
                                                              // VSCODE)

                            case "1" -> {
                                System.out.printf(
                                        "\n \u001B[35m• Ricorda : Puoi prenotare al massimo %s posti : \u001B[0m \n",
                                        newEvent.getPostiDisponibili());

                                newEvent.prenota();
                            }

                            case "2" -> {
                                System.out.printf(
                                        "\n \u001B[35m• Ricorda : Puoi disdire al massimo %s posti : \u001B[0m \n",
                                        newEvent.getPostiPrenotati());

                                newEvent.disdici();
                            }

                            default -> System.err.println("\n \u001B[31m !! Scelta non corretta !!\u001B[0m \n");

                        }

                        System.out.println(
                                "\n Vuoi prenotare / disdire un altro posto per l'evento selezionato ? \n [S]  [N] ");

                        String sceltaRipeti = scan.nextLine();

                        if (sceltaRipeti.compareToIgnoreCase("n") == 0) {
                            ripeti = false;

                            // ADD CREATED EVENT TO EVENT ARRAYLIST AND PRINT LIST

                            Manager.listaEventi(listaEventi);

                            System.out.println("\n\n ---- Uscita dal programma in corso ... ---\n\n");

                            Manager.pausa(3000);

                            System.out.println("\n \u001B[36mTICKETRAFFO © -> GOODBYE \u001B[0m \n");
                        }

                    }
                } else {
                    System.err.println("\u001B[31m  Errore: l'input non è valido. Riprova.\u001B[0m");
                }
            }

        }
        scan.close();
        input.close();

    }

}
