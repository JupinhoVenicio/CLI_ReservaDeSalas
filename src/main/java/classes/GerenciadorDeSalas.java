package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeSalas {
    private List<Sala> salas = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

    public List<Reserva> buscarConflitos(Sala sala, LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {
        List<Reserva> conflitos = new ArrayList<>();

        for (Reserva index : reservas) {

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
        salas.add(sala);

    }

    public void removerSala(Sala sala) {
        salas.remove(sala);

    }

    public void editarSala(Sala salaAntiga, Sala salaNova) {
        int posicao = salas.indexOf(salaAntiga);
        salas.set(posicao, salaNova);
    }

    public void reservar(Reserva reserva) {
        List<Reserva> conflitos = buscarConflitos(reserva.getSala(), reserva.getDataHorarioInicio(),
                reserva.getDataHorarioFim());
        if (!(conflitos.isEmpty())) {
            throw new IllegalArgumentException(
                    "\nData/Horário em conflito com a(s) seguinte(s) reserva(s):\n" + listarConflitos(conflitos));
        }
        reservas.add(reserva);

    }

    public void desreservar(Reserva reserva) {

        reservas.remove(reserva);

    }

    public void editarReserva(Reserva reservaAntiga, LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {
        Reserva reservaNova = new Reserva(reservaAntiga.getSala(), dataHorarioInicio, dataHorarioFim);
        List<Reserva> conflitos = buscarConflitos(reservaNova.getSala(), dataHorarioInicio, dataHorarioFim);
        conflitos.remove(reservaAntiga);
        if (!(conflitos.isEmpty())) {
            throw new IllegalArgumentException(
                    "\nData/Horário em conflito com a(s) seguinte(s) reserva(s):\n" + listarConflitos(conflitos));
        }
        int posicao = reservas.indexOf(reservaAntiga);
        reservas.set(posicao, reservaNova);
    }

    public String listarSalas() {

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (Sala sala : salas) {

            sb.append("\n" + (i) + " - " + sala);
            i = i + 1;
        }
        return sb.toString();
    }

    public String listarReservas() {

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (Reserva reserva : reservas) {

            sb.append("\n" + (i) + " - " + reserva);
            i = i + 1;
        }

        return sb.toString();

    }

    public String listarConflitos(List<Reserva> conflitos) {

        StringBuilder sb = new StringBuilder();
        for (Reserva sala : conflitos) {

            sb.append("\n" + sala);

        }

        return sb.toString();
    }

    public int getSalasTotaisSize() {
        return salas.size();
    }

    public int getSalasReservadasSize() {
        return reservas.size();
    }

    public Sala getAtributosDaSala(int index) {
        return salas.get(index);
    }

    public Reserva getAtributosDaReserva(int index) {
        return reservas.get(index);
    }

    public boolean nenhumaSala() {
        return salas.isEmpty();
    }

    public boolean nenhumaReserva() {
        return reservas.isEmpty();
    }

    public boolean temReserva(Sala sala) {

        for (Reserva reserva : reservas) {

            if (reserva.getSala() == sala) {

                return true;

            }

        }
        return false;

    }
}
