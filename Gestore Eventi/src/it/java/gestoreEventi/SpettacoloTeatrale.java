package it.java.gestoreEventi;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

public class SpettacoloTeatrale extends Evento {

    private double prezzoSpettacolo;

    public double getPrezzoSpettacolo() {
        return prezzoSpettacolo;
    }

    public void setPrezzoEvento(double prezzoEvento) {
        this.prezzoSpettacolo = prezzoEvento;
    }

    public SpettacoloTeatrale() {

        super("E fuori Nevica (V.Salemme, C.Buccirosso, M.Casagrande, N.Paone)");

        this.prezzoSpettacolo = 100.00;

        this.setDataEvento(LocalDateTime.of(1999, 8, 4, 20, 00, 00));

        this.setPostiDisponibili(500);
    }

    private String formattaPrezzo() {

        Locale italia = Locale.ITALY;

        NumberFormat formatoEuro = NumberFormat.getCurrencyInstance(italia);

        String prezzoFormattato = formatoEuro.format(this.prezzoSpettacolo);

        return prezzoFormattato;
    }

    @Override
    public String toString() {

        return super.toString() + " - Prezzo : " + formattaPrezzo();
    }

}
