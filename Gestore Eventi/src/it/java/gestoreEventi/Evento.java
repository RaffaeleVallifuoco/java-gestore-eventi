package it.java.gestoreEventi;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titoloEvento;
    private LocalDateTime dataEvento;
    private LocalDate data;
    private LocalTime time;
    private int postiTotali;
    private int postiDisponibili;
    private int postiPrenotati = 0;

    private Scanner scan = new Scanner(System.in);

    // ----------------------------------------------
    // ----------- GETTERS & SETTERs ----------------
    // ----------------------------------------------

    public void setTitoloEvento(String titoloEvento) {
        this.titoloEvento = titoloEvento;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getTitoloEvento() {
        return titoloEvento;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    // ----------------------------------------------
    // -------------- COSTRUTTORI -------------------
    // ----------------------------------------------

    public Evento(String titoloEvento) {

        this.postiPrenotati = 0;
        this.postiTotali = 8000;
        this.titoloEvento = titoloEvento;
        this.dataEvento = LocalDateTime.of(2024, 07, 12, 21, 00, 00);

    }

    public Evento(String titoloEvento, LocalDateTime dataEvento, int postiDisponibili) {

        this.titoloEvento = titoloEvento;
        this.dataEvento = dataEvento;
        this.postiDisponibili = postiDisponibili;
        this.postiPrenotati = 0;

    }

    public Evento(String titoloEvento, LocalDate data, LocalTime time, int postiDisponibili) {

        this.titoloEvento = titoloEvento;
        this.data = data;
        this.time = time;
        this.postiDisponibili = postiDisponibili;
        this.postiPrenotati = 0;

    }

    // ----------------------------------------------
    // ----------------- METODI ---------------------
    // ----------------------------------------------

    // PRENOTA TICKET

    public void prenota() {

        LocalDateTime currentDate = LocalDateTime.now();

        if (checkDate(currentDate, dataEvento) && checkPositive()) {
            System.out.println("\n QUanti posti vuoi prenotare ? \b");
            int postiDaPrenotare = scan.nextInt();
            scan.nextLine();

            if (postiDaPrenotare > this.postiDisponibili) {
                System.out.println(
                        "\n - ! ATTENZIONE ! - \n La disponibilità di posti per questo evento non soddisfa la sua richiesta. \n IMPOSSIBILE COMPLETARE L'OPERAZIONE \n");
            } else {

                try {
                    // Pausa di 1 secondo (1000 millisecondi)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                System.out.println("\n Prenotazione effettuata con successo \n");
                this.postiDisponibili -= postiDaPrenotare;
                this.postiPrenotati += postiDaPrenotare;
                System.out.printf("\nPosti ora disponibili : %s   |   Posti prenotati : %s   \n",
                        this.postiDisponibili, this.postiPrenotati);

            }

        } else {
            System.out.println(
                    "\n ! ERRORE ! La data dell'evento selezionato è già passata. \n IMPOSSIBILE COMPLETARE L'OPERAZIONE \n");
        }

    }

    // DISDICI TICKET

    public void disdici() {

        LocalDateTime currentDate = LocalDateTime.now();
        // ZonedDateTime eventDate = null;

        if (checkDate(currentDate, dataEvento) && checkPositive()) {
            System.out.println("\n Quanti posti vuoi disdire ? \n");
            int postiDaDisdire = scan.nextInt();
            scan.nextLine();

            if (postiDaDisdire >= this.postiPrenotati) {
                System.out.println(
                        "\n - ! ATTENZIONE ! - \n Impossibile disdire pià posti di quanti ne siano stati prenotati. \n IMPOSSIBILE COMPLETARE L'OPERAZIONE");
            } else {

                try {
                    // Pausa di 1 second0 (1000 millisecondi)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                System.out.println("\n Operazione effettuata con successo");
                postiDisponibili += postiDaDisdire;
                postiPrenotati -= postiDaDisdire;

            }

        }
        System.out.printf("\nPosti ora disponibili : %s   |   Posti prenotati : %s   \n",
                this.postiDisponibili, this.postiPrenotati);

    }

    // CHECK DATA CORRENTE < DATA EVENTO

    public boolean checkDate(LocalDateTime currentDateTime, LocalDateTime eventDateTime) {

        return currentDateTime.isBefore(eventDateTime);
    }

    // cehck posti prenotati > o

    public boolean checkPositive() {

        return (postiTotali > 0);
    }

    // ----------------------------------------------
    // ---------------- ToSTRING --------------------
    // ----------------------------------------------

    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy.HH:mm");
        String dataFormattata = this.dataEvento.format(formatter);
        return titoloEvento + " del " + dataFormattata;

    }
}
