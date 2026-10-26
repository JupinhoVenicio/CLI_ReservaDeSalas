
import Classes.GerenciadorDeSalas;
import Classes.Input;
import Classes.Reserva;
import Classes.Sala;
import Enum.MenuOpcoes;
import Enum.SalaStatus;

public class App {

    GerenciadorDeSalas gerenciador = new GerenciadorDeSalas();

    public void executarCadastrarSala() {

        try {

            Sala salaNova = new Sala();

            String nome = Input.st("\n\nNome da Sala: ");

            salaNova.setNome(nome);

            int capacidade = Input.in("\n\nCapacidade da Sala (Pessoas): ");
            salaNova.setCapacidade(capacidade);

            char projetor = Input.ch("\n\nTem projetor (Y/N)\nY = Sim\t\tN = Não");
            salaNova.setProjetor(projetor);

            gerenciador.registrarSala(salaNova);
            System.out.println("\nSala Cadastrada.");

        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
        }

    }

    public void executarRemoverSala() {

        if (gerenciador.isNenhumaSala() == true) {

            System.out.println("\nNenhuma sala foi cadastrada.");

        } else {

            int userInput;

            gerenciador.listarSalasTotais();

            userInput = Input.in("\nRemova uma sala (Número da Lista): ");

            if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasTotaisSize()) {
                System.out.println("Opção Inválida.");
            } else {

                Sala sala = gerenciador.getAtributosDaSalaTotal(userInput - 1);

                if (sala.getStatusDeReserva() == SalaStatus.RESERVADA) {
                    System.out.println("\nSala contém reservas. Cancele todas para remover.");

                } else {
                    gerenciador.removerSala(sala);
                    System.out.println("\nSala Removida.");
                }

            }

        }

    }

    public void executarListarSalas() {

        if (!gerenciador.isNenhumaSala()) {
            gerenciador.listarSalasTotais();

        } else {
            System.out.println("\nNenhuma sala foi cadastrada.");
        }

    }

    public void executarCriarReserva() {

        int userInput;

        if (gerenciador.isNenhumaSala() == true) {

            System.out.println("\nNenhuma sala foi cadastrada.");

        } else {

            try {
                gerenciador.listarSalasTotais();

                userInput = Input.in("\nEscolha uma sala (Número da Lista): ");

                if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasTotaisSize()) {
                    System.out.println("Opção Inválida.");
                } else {

                    Sala sala = gerenciador.getAtributosDaSalaTotal(userInput - 1);

                    Reserva reserva = new Reserva();

                    reserva.setSala(sala);
                    reserva.setNomeSalaReservada();

                    int HorarioInicio = Input.in("\nEHorário de Início: ");

                    int HorarioFim = Input.in("\nEHorário de Fim: ");

                    reserva.setHorario(HorarioInicio, HorarioFim);

                    if (gerenciador.temHorarioConflito(sala, reserva) == true) {
                        System.out.println("\nHorario em conflito com outra reserva.");
                    } else {

                        gerenciador.reservarSala(reserva);
                        System.out.println("\nReserva Efetuada.");
                    }

                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }

    }

    public void executarCancelarReserva() {

        int userInput;
        try {
            if (gerenciador.isNenhumaSalaReservada()) {

                System.out.println("\nNenhuma sala foi reservada.");

            } else {

                gerenciador.listarSalasReservadas();

                userInput = Input.in("\nRemova uma reserva (Número da Lista)");

                if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasReservadasSize()) {
                    System.out.println("Opção Inválida.");
                } else {

                    Reserva reserva = gerenciador.getAtributosDaSalaReservada(userInput - 1);

                    gerenciador.desreservarSala(reserva);
                    System.out.println("\nReserva Cancelada.");
                }

            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }

    }

    public void executarListarReservas() {

        if (!gerenciador.isNenhumaSalaReservada()) {
            gerenciador.listarSalasReservadas();

        } else {
            System.out.println("\nNenhuma sala foi reservada.");
        }

    }

    public static void main(String[] args) throws Exception {

        App app = new App();

        MenuOpcoes opcaoEscolhida;

        do {

            System.out.println("\n-----Sistema de Reserva de Salas-----");

            for (MenuOpcoes opcao : MenuOpcoes.values()) {
                System.out.println("\n" + opcao.getNum() + " - " + opcao.getLabel());
            }

            System.out.println("\n----------------------------------------");

            int userInput = Input.in("\nEscolha (Número da Lista): ");

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

    }

}
