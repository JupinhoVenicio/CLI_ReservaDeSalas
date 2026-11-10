package classes;

public class Sala {

    private String nome;
    private int capacidade;
    private boolean temProjetor;

    @Override
    public String toString() {
        return String.format("Sala: %s%n\tCapacidade: %s%n\tTem projetor: %s", 
            nome, 
            capacidade,
            getProjetor());
    }

    public Sala(String nome, int capacidade, boolean temProjetor) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("\nEntrada Inválida: Campo de nome vazio.");
        }
        this.nome = nome;
        if (capacidade <= 0) {
            throw new IllegalArgumentException("\nEntrada Inválida: Salá não pode abrigar menos de 1 pessoa.");
        }
        this.capacidade = capacidade;
        this.temProjetor = temProjetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("\nEntrada Inválida: Campo de nome vazio.");
        }
        this.nome = nome;

    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {

        if (capacidade <= 0) {
            throw new IllegalArgumentException("\nEntrada Inválida: Salá não pode abrigar menos de 1 pessoa.");
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

        String projetor = "";

        if (temProjetor == true) {
            projetor = "Sim";

        } else if (temProjetor == false) {
            projetor = "Não";

        }
        return projetor;

    }
}
