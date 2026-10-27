package Classes;

import java.time.LocalDateTime;

public class Reserva {

    private Sala sala;
    private String nomeSalaReservada;
    private LocalDateTime dataHorarioInicio;
    private LocalDateTime dataHorarioFim;

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setNomeSalaReservada() {
        this.nomeSalaReservada = this.sala.getNome();
    }

    public void setHorario(LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {
        if (dataHorarioInicio.isAfter(dataHorarioFim)) {
            throw new IllegalArgumentException(
                    "\nData/Horário de inicio não pode ser depois que a Data/Horário de fim.");
        } else {

            this.dataHorarioInicio = dataHorarioInicio;
            this.dataHorarioFim = dataHorarioFim;

        }
    }

    public LocalDateTime getDataHorarioInicio() {
        return dataHorarioInicio;
    }

    public LocalDateTime getDataHorarioFim() {
        return dataHorarioFim;
    }

    public Sala getSala() {
        return sala;
    }

    public String getNomeSalaReservada() {
        return nomeSalaReservada;
    }

}
