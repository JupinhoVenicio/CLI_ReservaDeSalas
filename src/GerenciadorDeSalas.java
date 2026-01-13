import java.util.ArrayList;

public class GerenciadorDeSalas {
    private ArrayList<Sala> salasTotais = new ArrayList<>();
    private ArrayList<Reserva> salasReservadas = new ArrayList<>();

    public boolean temHorarioConflito(Reserva salaNova) {

        for (Reserva index : salasReservadas) {

            if (salaNova.getHorarioFim() <= index.getHorarioInicio()) {
            
            }else if(salaNova.getHorarioInicio()>= index.getHorarioFim()){
                
            }else{
                return true;
            }

        }
        return false;

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
