package it.java.gestoreEventi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestMain {

    public static void main(String[] args) {

        System.out.println("\b - TEST PROGRAMMEVENTI CLASS -");

        ProgrammaEventi listaeventi = new ProgrammaEventi("Programma concerti");

        LocalDateTime data1 = LocalDateTime.of(2024, 1, 15, 21, 00, 00);
        LocalDateTime data2 = LocalDateTime.of(2025, 7, 12, 20, 00, 00);
        LocalDateTime data3 = LocalDateTime.of(2024, 7, 02, 11, 00, 00);
        Evento concerto1 = new Evento("concerto1", data1, 123);
        Evento concerto2 = new Evento("concerto2", data2, 299);
        Evento concerto3 = new Evento("concerto3", data3, 24);

        listaeventi.aggiungiEvento(concerto1);
        listaeventi.aggiungiEvento(concerto2);
        listaeventi.aggiungiEvento(concerto3);

        listaeventi.stampaProgramma();

        LocalDate dataRicerca = LocalDate.of(2024, 07, 02);

        listaeventi.getEventiPerData(dataRicerca);

    }

}
