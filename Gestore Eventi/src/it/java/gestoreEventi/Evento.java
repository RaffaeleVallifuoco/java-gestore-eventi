package it.java.gestoreEventi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {

    private String titoloEvento;
    private LocalDateTime dataEvento;
    private int postiTotali;
    private int postiPrenotati;

    // ----------------------------------------------
    // -------------- COSTRUTTORE -------------------
    // ----------------------------------------------

    public Evento(String titoloEvento, LocalDateTime dataEvento, int postiTotali) {

        this.postiPrenotati = 0;
        this.titoloEvento = titoloEvento;
        this.dataEvento = dataEvento;
        this.postiTotali = postiTotali;

    }

    // ----------------------------------------------
    // ----------------- METODI ---------------------
    // ----------------------------------------------

}
