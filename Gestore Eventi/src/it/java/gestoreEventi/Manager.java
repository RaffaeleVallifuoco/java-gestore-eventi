package it.java.gestoreEventi;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Manager {

    protected static String nomeEvento;
    protected static String dataEvento;
    protected static LocalDateTime dataEventoFormattata;
    protected static int postiDisponibili;;

    static Scanner scan = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);

    // PAUSA ESECUZIONE

    protected static void pausa(int milliseconds) {
        try {

            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    // FORMATTA DATA

    protected static LocalDateTime formattaData(String dataEvento) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy.HH:mm");

        return LocalDateTime.parse(dataEvento, formatter);

    }

    // INSERIMENTO EVENTO

    protected static void inputEvento() {
        System.out.print("\n Inserisci il nome dell'evento :  ");
        nomeEvento = scan.nextLine();

        boolean validInput = false;

        while (!validInput) {
            System.out.print(
                    "\n Inserisci la data dell'evento separando data e ora da un PUNTO( FORMATO (dd/MM/yyyy.HH:mm) :  ");
            dataEvento = scan.nextLine();

            try {

                dataEventoFormattata = Manager.formattaData(dataEvento);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.err.println(
                        "\n \u001B[31m  !! Formato data non valido. Per favore, inserisci un valore corretto !! \u001B[0m \n");
            }
        }

        boolean validInt = false;
        while (!validInt) {
            try {
                System.out.print("\n Inserisci i posti disponibili per l'evento :  ");
                postiDisponibili = input.nextInt();
                input.nextLine();

                validInt = true;
            } catch (InputMismatchException e) {
                System.out.println("\n \u001B[31m !! Input non valido!!\u001B[0m \n");
                input.next(); // Clear the invalid input
            }
        }
    }

    // INSERIMENTO IN ARRAY LISTA EVENTI

    protected static void listaEventi(ProgrammaEventi Array) {
        System.out.println(
                "\n Vuoi stampare la lista completa degli eventi presenti a database ? \n [S] [N]");
        String printChoice = scan.nextLine();

        switch (printChoice.toLowerCase()) {
            case "s":
                Manager.pausa(1000);

                System.out.println("\n Recupero gli eventi...... attendi....\n");

                Manager.pausa(2000);

                Array.stampaProgramma();

                break;

            case "n":
                System.out.println("");
                break;

            default:
                System.err.println("\n Scelta non corretta");
                break;
        }
    }

}
