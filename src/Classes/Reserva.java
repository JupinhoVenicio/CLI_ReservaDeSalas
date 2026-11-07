package Classes;

import java.time.LocalDateTime;

public class Reserva {

    private Sala sala;
    private String nomeSalaReservada;
    private LocalDateTime dataHorarioInicio;
    private LocalDateTime dataHorarioFim;

    public Reserva(Sala sala, LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {
        if (sala == null) {
            throw new IllegalArgumentException("\nErro: Reserva precisa ser vinculada a uma sala.");
        }
        this.sala = sala;
        this.nomeSalaReservada = sala.getNome();
        if (dataHorarioInicio == null || dataHorarioFim == null) {
            throw new IllegalArgumentException("\nErro: Data/Horário não encontrado. Verifique o D/H de inicio e fim.");
        }
        if (dataHorarioInicio.isAfter(dataHorarioFim)) {
            throw new IllegalArgumentException(
                    "\nEntrada Inválida: Data/Horário de inicio não pode ser depois que a Data/Horário de fim.");
        } else if (dataHorarioInicio.isEqual(dataHorarioFim)) {
            throw new IllegalArgumentException("\nEntrada Inválida: Data/Horário de início não podem iguais.");
        } else if (dataHorarioInicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("\nEntrada Inválida: Data/Horário de início não podem ser no passado.");
        }
        this.dataHorarioInicio = dataHorarioInicio;
        this.dataHorarioFim = dataHorarioFim;
    }

    public void setSala(Sala sala) {
        if (sala == null) {
            throw new IllegalArgumentException("\nErro: Reserva precisa ser vinculada a uma sala.");
        }
        this.sala = sala;
    }

    public void setNomeSalaReservada() {
        if (sala == null) {
            throw new IllegalArgumentException("\nErro: Reserva precisa ser vinculada a uma sala.");
        }
        this.nomeSalaReservada = this.sala.getNome();
    }

    public void setHorario(LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {
        if (dataHorarioInicio == null || dataHorarioFim == null) {
            throw new IllegalArgumentException("\nErro: Data/Horário não encontrado. Verifique o D/H de inicio e fim.");
        }
        if (dataHorarioInicio.isAfter(dataHorarioFim)) {
            throw new IllegalArgumentException(
                    "\nEntrada Inválida: Data/Horário de inicio não pode ser depois que a Data/Horário de fim.");
        } else if (dataHorarioInicio.isEqual(dataHorarioFim)) {
            throw new IllegalArgumentException("\nEntrada Inválida: Data/Horário de início não podem iguais.");
        } else if (dataHorarioInicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("\nEntrada Inválida: Data/Horário de início não podem ser no passado.");
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
