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

    public void listarSalasTotais(){

        int i = 1;
        for(Sala sala : salasTotais){

            System.out.println("\n"+(i)+" - Sala: "+sala.getNome()+" | Capacidade: "+sala.getCapacidade()+" | Tem projetor: "+sala.getProjetor());
            i = i+1;
        }

    }
    public void listarSalasReservadas(){

          int i = 1;
        for(Reserva sala : salasReservadas){

            System.out.println("\n"+(i)+" - Sala: "+sala.getNomeSalaReservada()+" | Horário: "+sala.getHorarioInicio()+":00 até "+sala.getHorarioFim()+":00");
            i = i+1;
        }

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
