package it.java.gestoreEventi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {

    private String titoloEvento;
    private LocalDateTime dataEvento;
    private int postiTotali;
    private int postiPrenotati;

    // ----------------------------------------------
    // ----------- GETTERS & SETTERD ----------------
    // ----------------------------------------------

    public void setTitoloEvento(String titoloEvento) {
        this.titoloEvento = titoloEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getTitoloEvento() {
        return titoloEvento;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    // ----------------------------------------------
    // -------------- COSTRUTTORE -------------------
    // ----------------------------------------------

    public Evento(String titoloEvento, LocalDateTime dataEvento, int postiTotali) {

        this.postiPrenotati = 0;
        this.titoloEvento = titoloEvento;
        this.dataEvento = dataEvento;
        this.postiTotali = postiTotali;

        // LocalDateTime currentDate = LocalDateTime.now();

        // if (dataEvento.isBefore(currentDate)) {
        // System.out.println("\n L'evento desiderato è già avvenuto ! Impossibile
        // effettuare prenotazione");
        // }else {
        // Evento myEvento = new Evento(titoloEvento, dataEvento, postiTotali);
        // }

    }

    // ----------------------------------------------
    // ----------------- METODI ---------------------
    // ----------------------------------------------

    public void prenota(int postiDaPrenotare) {

        if (postiDaPrenotare < this.postiTotali) {
            this.postiTotali -= postiDaPrenotare;
        }

    }

    public void disdici() {

    }

    @Override
    public String toString() {

        return super.toString();
    }

}
