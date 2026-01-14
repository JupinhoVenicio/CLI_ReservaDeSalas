import java.util.ArrayList;
import java.util.Scanner;

import Enum.MenuOpcoes;
import Enum.SalaStatus;

public class App {

    private Scanner teclado = new Scanner(System.in);
    GerenciadorDeSalas gerenciador = new GerenciadorDeSalas();

    public void executarCadastrarSala() {

        try {

            Sala salaNova = new Sala();

            System.out.print("\nNome da Sala: ");
            String nome = teclado.nextLine();
            salaNova.setNome(nome);

            System.out.print("\n\nCapacidade da Sala (Pessoas): ");
            int capacidade = teclado.nextInt();
            salaNova.setCapacidade(capacidade);

            System.out.println("\n\nTem projetor (Y/N)\nY = Sim\tN = Não");
            teclado.nextLine();
            String projetor = teclado.nextLine();
            salaNova.setProjetor(salaNova.projetorStringToChar(projetor));

            gerenciador.registrarSala(salaNova);

        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
        }

    }

    public void executarRemoverSala() {

        int userInput;

        if (gerenciador.isNenhumaSala() == true) {

            System.out.println("\nNenhuma sala foi cadastrada.");

        } else {

            gerenciador.listarSalasTotais();

            System.out.print("Remova (Número): ");
            userInput = teclado.nextInt();

            if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasTotaisSize()) {
                System.out.println("Opção Inválida.");
            } else {

                Sala sala = gerenciador.getAtributosDaSalaTotal(userInput - 1);

                if (sala.getStatusDeReserva() == SalaStatus.RESERVADA) {
                    System.out.println("\nSala contém reservas. Cancele todas para remover.");

                } else {
                    gerenciador.removerSala(sala);
                }

            }

        }

    }

    public void executarListarSalas() {

    }

    public void executarCriarReserva() {

    }

    public void executarCancelarReserva() {

    }

    public void executarListarReservas() {

    }

    public static void main(String[] args) throws Exception {

        App app = new App();
        Scanner teclado = new Scanner(System.in);

        MenuOpcoes opcaoEscolhida;

        do {

            System.out.println("\n-----Sistema de Reserva de Salas-----");

            for (MenuOpcoes opcao : MenuOpcoes.values()) {
                System.out.println("\n" + opcao.getNum() + " - " + opcao.getLabel());
            }

            System.out.println("\n----------------------------------------");
            System.out.print("\nEscolha (Número): ");

            int userInput = teclado.nextInt();

            opcaoEscolhida = MenuOpcoes.fromNum(userInput);

            if (opcaoEscolhida == null) {
                System.out.println("\nOpção Inválida.");

            } else {

                switch (opcaoEscolhida) {

                    case CADASTRAR_SALA:
                        app.executarCadastrarSala();
                        break;
                    case REMOVER_SALA:
                        app.executarRemoverSala();
                        break;
                    case LISTAR_SALA:
                        app.executarListarSalas();
                        break;
                    case CRIAR_RESERVA:
                        app.executarCriarReserva();
                        break;
                    case CANCELAR_RESERVA:
                        app.executarCancelarReserva();
                        break;
                    case LISTAR_RESERVAS:
                        app.executarListarReservas();
                        break;
                    case SAIR:
                        break;

                    default:

                }
            }

        } while (opcaoEscolhida != MenuOpcoes.SAIR);

        teclado.close();

    }

}
