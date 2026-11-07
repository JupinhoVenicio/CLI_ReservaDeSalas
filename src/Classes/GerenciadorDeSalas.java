package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeSalas {
    private List<Sala> salasTotais = new ArrayList<>();
    private List<Reserva> salasReservadas = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

    public boolean temHorarioConflito(Sala sala, LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {

        for (Reserva index : salasReservadas) {

            if (sala.equals(index.getSala())) {

                boolean fimNovoAntesDoInicioIndex = !dataHorarioFim.isAfter(index.getDataHorarioInicio());
                boolean inicioNovoDepoisDofimIndex = !dataHorarioInicio.isBefore(index.getDataHorarioFim());

                if (!(fimNovoAntesDoInicioIndex || inicioNovoDepoisDofimIndex)) {
                    return true;
                }

            }
        }
        return false;
    }

    public void registrarSala(Sala sala) {
        salasTotais.add(sala);

    }

    public void removerSala(Sala sala) {
        salasTotais.remove(sala);

    }

    public void reservarSala(Reserva salaReservada) {
        if (temHorarioConflito(salaReservada.getSala(), salaReservada.getDataHorarioInicio(), salaReservada.getDataHorarioFim())){
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

            sb.append("\n" + (i) + " - Sala: " + sala.getNome() + " | Capacidade: " + sala.getCapacidade()
                    + " | Tem projetor: " + sala.getProjetor());
            i = i + 1;
        }
        return sb.toString();
    }

    public String listarSalasReservadas() {

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (Reserva sala : salasReservadas) {

            sb.append("\n" + (i) + " - Sala: " + sala.getNomeSalaReservada() + "\n\tInício: "
                    + sala.getDataHorarioInicio().format(formatter) + "\n\tFim: "
                    + sala.getDataHorarioFim().format(formatter));
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

    public boolean salaPossuiNenhumaReserva(Sala sala) {

        for (Reserva reserva : salasReservadas) {

            if (reserva.getSala() == sala) {

                return false;

            }

        }
        return true;

    }
}
