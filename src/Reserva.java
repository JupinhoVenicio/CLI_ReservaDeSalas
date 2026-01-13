import java.util.ArrayList;

public class Reserva {
    private ArrayList<Sala> salasTotais = new ArrayList<>();
    private ArrayList<Reserva> salasReservadas = new ArrayList<>();

    private String nomeSalaReservada;
    private int horarioInicio;
    private int horarioFim;

    public void setNomeSalaReservada(Sala sala) {
        this.nomeSalaReservada = sala.getNome();
    }

    public void setHorario(int horarioInicio, int horarioFim) {
        if (horarioInicio >= horarioFim) {
            throw new IllegalArgumentException("\nBug: Horario de início mais tarde que o de fim.");
        } else if (horarioInicio > 23 || horarioInicio < 0 || horarioFim > 23 || horarioFim < 0) {
            throw new IllegalArgumentException("\nBug: Horario não existente");
        } else {

            this.horarioInicio = horarioInicio;
            this.horarioFim = horarioFim;

        }
    }

    public int getHorarioInicio() {
        return horarioInicio;
    }

    public int getHorarioFim() {
        return horarioFim;
    }

    public boolean temHorarioConflito(Reserva salaNova) {

        for (Reserva index : salasReservadas) {

            if (salaNova.getHorarioInicio() < index.getHorarioInicio()
                    && salaNova.getHorarioFim() <= index.getHorarioInicio()) {
                return false;

            }

        }

    }

    public void registrarSala(Sala sala) {
        salasTotais.add(sala);

    }

    public void removerSala(Sala sala, Reserva salaReservada) {
        salasTotais.remove(sala);
        salasReservadas.remove(salaReservada);

    }

    public void reservarSala(Reserva salaReservada) {
        salasReservadas.add(salaReservada);

    }

    public void desreservarSala(Reserva salaReservada) {

        salasReservadas.remove(salaReservada);
    }

    public boolean isNenhumaSala() {
        if (salasTotais.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNenhumaSalaReservada() {
        if (salasReservadas.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
