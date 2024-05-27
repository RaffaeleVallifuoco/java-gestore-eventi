package it.java.gestoreEventi;

import java.time.LocalDateTime;
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

    protected static void pausa(int milliseconds) {
        try {

            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    protected static LocalDateTime formattaData(String dataEvento) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy.HH:mm");

        return LocalDateTime.parse(dataEvento, formatter);

    }

    protected static void inputEvento() {
        System.out.print("\n Inserisci il nome dell'evento :  ");
        nomeEvento = scan.nextLine();

        boolean validInput = false;

        while (!validInput) {
            System.out.print(
                    "\n Inserisci la data dell'evento ( FORMATO (dd/MM/yyyy.HH:mm) :  ");
            dataEvento = scan.nextLine();

            try {

                dataEventoFormattata = Manager.formattaData(dataEvento);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.err.println(
                        "\n Formato data non valido. Per favore, inserisci un valore corretto.\n");
            }
        }

        System.out.print("\n Inserisci i posti disponibili per l'evento : \n");
        postiDisponibili = input.nextInt();
        input.nextLine();
    }

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
