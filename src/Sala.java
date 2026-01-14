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
        if (nome == null) {
            throw new IllegalArgumentException("\nCampo do nome da sala vazio!");
        } else {
            this.nome = nome;
        }

    }

    public int getCapacidade() {

        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade < 2) {
            throw new IllegalArgumentException("\nBug: Capacidade não pode ser menor que 2 pessoas!");
        } else {
            this.capacidade = capacidade;
        }
    }

    public char projetorStringToChar(String userInput) {

        if (userInput == null||userInput.isBlank()) {
            throw new IllegalArgumentException("\nInválido: Nada foi digitado.");
        } else if (userInput.length() > 1) {
            throw new IllegalArgumentException("\nInválido: Usuario digitou mais de um caracter.");
        } else {
            char conversao = userInput.charAt(0);
            return conversao;
        }

    }

    public void setProjetor(char convertidoInput) {
        if (convertidoInput == 'Y' || convertidoInput == 'y') {
            this.temProjetor = true;
        }else if (convertidoInput == 'N' || convertidoInput == 'n') {
            this.temProjetor = false;
        }else{
            throw new IllegalArgumentException("\nInválido: Nenhuma opção foi selecionada.");
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
            throw new IllegalArgumentException("\nBug: Condição do projetor não foi encontrada!");
        }

    }

    public SalaStatus getStatusDeReserva() {

        return statusDeReserva;
    }
   

}
