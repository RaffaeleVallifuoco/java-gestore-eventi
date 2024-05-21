package it.java.gestoreEventi;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

public class Concerto extends Evento {

    private double prezzoConcerto;

    public double getPrezzoConcerto() {
        return prezzoConcerto;
    }

    public Concerto() {

        super("Concerto");

        this.prezzoConcerto = 123.99;

        this.setDataEvento(LocalDateTime.of(2025, 07, 07, 23, 00, 00));

        this.setPostiDisponibili(100);
    }

    private String formattaPrezzo() {

        Locale italia = Locale.ITALY;

        NumberFormat formatoEuro = NumberFormat.getCurrencyInstance(italia);

        String prezzoFormattato = formatoEuro.format(this.prezzoConcerto);

        return prezzoFormattato;
    }

    @Override
    public String toString() {

        return super.toString() + " - Prezzo : " + formattaPrezzo();
    }

}
