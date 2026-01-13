import java.util.ArrayList;

public class Reserva {
    

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

    

    

}
