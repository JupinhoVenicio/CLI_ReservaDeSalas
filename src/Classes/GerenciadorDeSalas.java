package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeSalas {
    private List<Sala> salasTotais = new ArrayList<>();
    private List<Reserva> salasReservadas = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

    public List<Reserva> buscarConflitos(Sala sala, LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {
        List<Reserva> conflitos = new ArrayList<>();

        for (Reserva index : salasReservadas) {

            if (sala.equals(index.getSala())) {

                boolean fimNovoAntesDoInicioIndex = !dataHorarioFim.isAfter(index.getDataHorarioInicio());
                boolean inicioNovoDepoisDofimIndex = !dataHorarioInicio.isBefore(index.getDataHorarioFim());

                if (!(fimNovoAntesDoInicioIndex || inicioNovoDepoisDofimIndex)) {
                    conflitos.add(index);
                }

            }
        }
        return conflitos;
    }

    public void registrarSala(Sala sala) {
        salasTotais.add(sala);

    }

    public void removerSala(Sala sala) {
        salasTotais.remove(sala);

    }

    public void reservarSala(Reserva salaReservada) {
        if (!(buscarConflitos(salaReservada.getSala(), salaReservada.getDataHorarioInicio(),
                salaReservada.getDataHorarioFim()).isEmpty())) {
            throw new IllegalArgumentException("\nHorario em conflito com outra reserva.");
        }
        salasReservadas.add(salaReservada);

    }

    public void desreservarSala(Reserva salaReservada) {

        salasReservadas.remove(salaReservada);

    }

    public String listarSalasTotais() {

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (Sala sala : salasTotais) {

            sb.append("\n" + (i) + " - " + sala);
            i = i + 1;
        }
        return sb.toString();
    }

    public String listarSalasReservadas() {

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (Reserva sala : salasReservadas) {

            sb.append("\n" + (i) + " - " + sala);
            i = i + 1;
        }

        return sb.toString();

    }

    public int getSalasTotaisSize() {
        return salasTotais.size();
    }

    public int getSalasReservadasSize() {
        return salasReservadas.size();
    }

    public Sala getAtributosDaSalaTotal(int index) {
        return salasTotais.get(index);
    }

    public Reserva getAtributosDaSalaReservada(int index) {
        return salasReservadas.get(index);
    }

    public boolean nenhumaSala() {
        return salasTotais.isEmpty();
    }

    public boolean nenhumaSalaReservada() {
        return salasReservadas.isEmpty();
    }

    public boolean temReserva(Sala sala) {

        for (Reserva reserva : salasReservadas) {

            if (reserva.getSala() == sala) {

                return true;

            }

        }
        return false;

    }
}
