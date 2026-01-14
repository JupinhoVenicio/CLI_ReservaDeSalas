
import java.util.InputMismatchException;
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

            System.out.println("\n\nTem projetor (Y/N)\nY = Sim\t\tN = Não");
            teclado.nextLine();
            String projetor = teclado.nextLine();
            salaNova.setProjetor(salaNova.projetorStringToChar(projetor));

            gerenciador.registrarSala(salaNova);
            System.out.println("\nSala Cadastrada.");

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

            System.out.print("\nRemova (Número): ");
            userInput = teclado.nextInt();

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

                System.out.print("\nEscolha (Número): ");
                userInput = teclado.nextInt();

                if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasTotaisSize()) {
                    System.out.println("Opção Inválida.");
                } else {

                    Sala sala = gerenciador.getAtributosDaSalaTotal(userInput - 1);

                    Reserva reserva = new Reserva();

                    reserva.setSala(sala);
                    reserva.setNomeSalaReservada();

                    System.out.print("\nHorário de Início: ");
                    int HorarioInicio = teclado.nextInt();
                    System.out.print("\nHorário de Fim: ");
                    int HorarioFim = teclado.nextInt();

                    reserva.setHorario(HorarioInicio, HorarioFim);

                    if (gerenciador.temHorarioConflito(sala, reserva) == true) {
                        System.out.println("\nHorario em conflito com outra reserva.");
                    } else {
                        System.out.println("\nReserva Efetuada.");
                        gerenciador.reservarSala(reserva);
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada Inválida.");
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

                System.out.print("\nRemova (Número): ");
                userInput = teclado.nextInt();

                if ((userInput - 1) < 0 || (userInput - 1) >= gerenciador.getSalasReservadasSize()) {
                    System.out.println("Opção Inválida.");
                } else {

                    Reserva reserva = gerenciador.getAtributosDaSalaReservada(userInput - 1);

                  
                        gerenciador.desreservarSala(reserva);
                        System.out.println("\nReserva Cancelada.");
                    }

                }

            

        } catch (InputMismatchException e) {
            System.out.println("\nEntrada Inválida.");
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
