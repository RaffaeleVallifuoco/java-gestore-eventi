package it.java.gestoreEventi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private LocalDate data;
    private List<Evento> eventList;

    public LocalDate getData() {
        return data;
    }

    // ---------------------------------------------------
    // ----------------- COSTRUTTORI ---------------------
    // ---------------------------------------------------

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventList = new ArrayList<>();
        aggiungiEvento(new Concerto("Coldplay Rome", LocalDateTime.of(2024, 07, 30, 20, 50), 44.99, 2000));
        aggiungiEvento(new Concerto("Gigi d'AgostinolIVE @ Altromondo Studios ", LocalDateTime.of(2025, 06, 28, 22, 00),
                40.00, 5000));
        aggiungiEvento(new Concerto("Cristian Marchi LIVE @ Plasmaphobia  ", LocalDateTime.of(2025, 10, 11, 22, 22),
                39.98, 1232));
    }

    // ---------------------------------------------------
    // ------------------- METODI ------------------------
    // ---------------------------------------------------

    // GET NUMERO EVENTI IN LISTA
    public int getNumeroEventi() {
        return eventList.size();
    }

    // AGGIUNGI EVENTO
    public void aggiungiEvento(Evento evento) {
        eventList.add(evento);
    }

    // STAMPA EVENTI DATA SPECIFICA

    public void getEventiPerData(LocalDate data) {
        System.out.printf("\n Eventi in data %s ", data);
        boolean find = false;
        for (Evento evento : eventList) {
            if (evento.getDataEvento().toLocalDate().equals(data)) {
                System.out.println(evento);
                find = true;
            }
        }
        if (!find) {
            System.out.println("Nessun evento trovato per la data " + data);
        }
    }

    // SVUOTA LISTA EVENTI
    public void svuotaEventi() {
        eventList.clear();
    }

    // STAMPA LISTA

    public void stampaProgramma() {
        System.out.printf("\n  - Eventi presenti nel database : - \n•%s• \n", this.titolo);

        // Ordino gli eventi per data
        Collections.sort(eventList, Comparator.comparing(Evento::getDataEvento));

        for (Evento evento : eventList) {
            System.out.println(evento);
        }
    }

}
