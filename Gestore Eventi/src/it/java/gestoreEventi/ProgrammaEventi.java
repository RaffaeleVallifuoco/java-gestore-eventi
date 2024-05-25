package it.java.gestoreEventi;

import java.time.LocalDate;
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
        System.out.println(titolo);

        // Ordino gli eventi per data
        Collections.sort(eventList, Comparator.comparing(Evento::getDataEvento));

        for (Evento evento : eventList) {
            System.out.println(evento);
        }
    }

}
