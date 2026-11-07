
import java.time.LocalDateTime;

import Classes.GerenciadorDeSalas;
import Classes.Input;
import Classes.Reserva;
import Classes.Sala;
import Classes.Enums.MenuOpcoes;

public class App {

    GerenciadorDeSalas gerenciador = new GerenciadorDeSalas();

    public void executarCadastrarSala() {

        try {

            String nome = Input.st("\n\nNome da Sala: ");

            int capacidade = Input.in("\n\nCapacidade da Sala (Pessoas): ");

            boolean projetor = Input.yn("\n\nTem projetor (Y/N)\nY = Sim\t\tN = Não");

            Sala salaNova = new Sala(nome, capacidade, projetor);

            gerenciador.registrarSala(salaNova);
            System.out.println("\nSala Cadastrada.");

        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
        }

    }

    public void executarRemoverSala() {

        if (gerenciador.nenhumaSala() == true) {

            System.out.println("\nNenhuma sala foi cadastrada.");

        } else {

            int userInput;

            System.out.println(gerenciador.listarSalasTotais()); 

            userInput = Input.in("\nRemova uma sala (Número da Lista): ");

            if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasTotaisSize()) {
                System.out.println("Opção Inválida.");
            } else {

                Sala sala = gerenciador.getAtributosDaSalaTotal(userInput - 1);

                if (gerenciador.temReserva(sala)) {
                    System.out.println("\nSala contém reservas. Cancele todas para remover.");

                } else {
                    gerenciador.removerSala(sala);
                    System.out.println("\nSala Removida.");
                }

            }

        }

    }

    public void executarListarSalas() {

        if (!gerenciador.nenhumaSala()) {
            System.out.println(gerenciador.listarSalasTotais()); 

        } else {
            System.out.println("\nNenhuma sala foi cadastrada.");
        }

    }

    public void executarCriarReserva() {

        int userInput;

        if (gerenciador.nenhumaSala() == true) {

            System.out.println("\nNenhuma sala foi cadastrada.");

        } else {

            try {
                System.out.println(gerenciador.listarSalasTotais()); 

                userInput = Input.in("\nEscolha uma sala (Número da Lista): ");

                if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasTotaisSize()) {
                    System.out.println("Opção Inválida.");
                } else {

                    Sala sala = gerenciador.getAtributosDaSalaTotal(userInput - 1);

                    LocalDateTime dataHorarioInicio = Input
                            .ldt("\nHorário de Início no formato 24h (dd/MM/yyyy HH:mm):\n\n");

                    LocalDateTime dataHorarioFim = Input.ldt("\nHorário de Fim no formato 24h (dd/MM/yyyy HH:mm):\n\n");

                    if (gerenciador.temHorarioConflito(sala, dataHorarioInicio, dataHorarioFim)) {
                        System.out.println("\nHorario em conflito com outra reserva.");
                    } else {
                        Reserva reserva = new Reserva(sala, dataHorarioInicio, dataHorarioFim);
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
            if (gerenciador.nenhumaSalaReservada()) {

                System.out.println("\nNenhuma sala foi reservada.");

            } else {

                System.out.println(gerenciador.listarSalasReservadas());

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

        if (!gerenciador.nenhumaSalaReservada()) {
            System.out.println(gerenciador.listarSalasReservadas());

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
