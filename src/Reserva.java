public class Reserva {
    

    private Sala sala;
    private String nomeSalaReservada;
    private int horarioInicio;
    private int horarioFim;

   
    public void setSala(Sala sala){
        this.sala = sala;
    }

    public void setNomeSalaReservada() {
        this.nomeSalaReservada = this.sala.getNome();
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

    public Sala getSala(){
        return sala;
    }

     public String getNomeSalaReservada(){
        return nomeSalaReservada;
    }

    

}
