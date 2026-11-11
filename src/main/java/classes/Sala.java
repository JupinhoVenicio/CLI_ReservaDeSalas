package classes;

public class Sala {

    private final String nome;
    private final int capacidade;
    private final boolean temProjetor;

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

    public int getCapacidade() {
        return capacidade;
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
