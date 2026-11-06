package Classes;

import Classes.Enums.SalaStatus;

public class Sala {

    private String nome;
    private int capacidade;
    private boolean temProjetor;
    private SalaStatus statusDeReserva = SalaStatus.DISPONIVEL;


    
    public Sala(String nome, int capacidade, boolean temProjetor) {

        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("\nEntrada Inválida: Campo de nome vazio.");
        }
        this.nome = nome;
        if(capacidade<=0){
            throw new IllegalArgumentException("\nEntrada Inválida: Salá não pode abrigar menos de 1 pessoa.");
        }
        this.capacidade = capacidade;
        this.temProjetor = temProjetor;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public int getCapacidade() {

        return capacidade;
    }

    public void setCapacidade(int capacidade) {

        if (capacidade <= 0) {
            
        }

        this.capacidade = capacidade;

    }

    public void setProjetor(boolean temProjetor) {
       this.temProjetor = temProjetor;

    }

    public boolean temProjetor() {

        return temProjetor;
    }

    public String getProjetor() {

        String projetor;

        if (temProjetor == true) {
            projetor = "Sim";
            return projetor;
        } else if (temProjetor == false) {
            projetor = "Não";
            return projetor;
        } else {
            throw new IllegalArgumentException("\nErro: Condição do projetor não foi encontrada!");
        }

    }

    public SalaStatus getStatusDeReserva() {

        return statusDeReserva;
    }

    public void reservarStatus() {
        this.statusDeReserva = SalaStatus.RESERVADA;
    }

    public void desreservarStatus() {
        this.statusDeReserva = SalaStatus.DISPONIVEL;
    }

}
