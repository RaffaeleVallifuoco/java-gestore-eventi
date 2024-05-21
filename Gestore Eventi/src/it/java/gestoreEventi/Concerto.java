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

    public void setPrezzoConcerto(double prezzoConcerto) {
        this.prezzoConcerto = prezzoConcerto;
    }

    public Concerto() {

        super("BABY K - Donna Sulla Luna  •Milano• ");

        // this.prezzoConcerto = 100.00;

        this.setDataEvento(LocalDateTime.of(2025, 07, 07, 21, 30, 00));

        this.setPostiDisponibili(500);
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
