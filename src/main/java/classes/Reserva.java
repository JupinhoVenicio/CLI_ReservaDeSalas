package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {

    private final Sala sala;
    private final LocalDateTime dataHorarioInicio;
    private final LocalDateTime dataHorarioFim;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

    @Override
    public String toString() {
        return String.format("Sala: %s%n\tInício: %s%n\tFim: %s",
                sala.getNome(),
                dataHorarioInicio.format(formatter),
                dataHorarioFim.format(formatter));
    }

    public Reserva(Sala sala, LocalDateTime dataHorarioInicio, LocalDateTime dataHorarioFim) {
        if (sala == null) {
            throw new IllegalArgumentException("\nErro: Reserva precisa ser vinculada a uma sala.");
        }
        this.sala = sala;

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

    public LocalDateTime getDataHorarioInicio() {
        return dataHorarioInicio;
    }

    public LocalDateTime getDataHorarioFim() {
        return dataHorarioFim;
    }

    public Sala getSala() {
        return sala;
    }


}
