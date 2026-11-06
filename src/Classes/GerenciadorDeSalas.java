package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GerenciadorDeSalas {
    private ArrayList<Sala> salasTotais = new ArrayList<>();
    private ArrayList<Reserva> salasReservadas = new ArrayList<>();

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
        salasReservadas.add(salaReservada);

    }

    public void desreservarSala(Reserva salaReservada) {

        salasReservadas.remove(salaReservada);

    }

    public void listarSalasTotais() {

        int i = 1;
        for (Sala sala : salasTotais) {

            System.out.println("\n" + (i) + " - Sala: " + sala.getNome() + " | Capacidade: " + sala.getCapacidade()
                    + " | Tem projetor: " + sala.getProjetor());
            i = i + 1;
        }

    }

    public void listarSalasReservadas() {

        int i = 1;
        for (Reserva sala : salasReservadas) {

            System.out.println("\n" + (i) + " - Sala: " + sala.getNomeSalaReservada() + "\n\tInício: "
                    + sala.getDataHorarioInicio().format(formatter) + "\n\tFim: "
                    + sala.getDataHorarioFim().format(formatter));
            i = i + 1;
        }

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
