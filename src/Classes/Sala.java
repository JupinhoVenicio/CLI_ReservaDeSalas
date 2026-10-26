package Classes;

import Enum.SalaStatus;

public class Sala {

    private String nome;
    private int capacidade;
    private boolean temProjetor;
    private SalaStatus statusDeReserva = SalaStatus.DISPONIVEL;

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
            throw new IllegalArgumentException("\nEntrada Inválida: Capacidade Negativa.");
        }

        this.capacidade = capacidade;

    }

    public void setProjetor(char input) {
        if (Character.toLowerCase(input) == 'y') {
            this.temProjetor = true;
        } else if (Character.toLowerCase(input) == 'n') {
            this.temProjetor = false;
        } else {
            throw new IllegalArgumentException("\nEntrada Inválida: Nenhuma opção foi selecionada.");
        }

    }

    public boolean isTemProjetor() {

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
