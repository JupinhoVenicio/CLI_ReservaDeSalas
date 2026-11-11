
import java.time.LocalDateTime;
import java.util.List;

import classes.GerenciadorDeSalas;
import classes.Reserva;
import classes.Sala;
import console.Input;
import menuopcoes.MainMenu;

public class App {

    private final GerenciadorDeSalas gerenciador;

    public App (GerenciadorDeSalas gerenciador){
        this.gerenciador = gerenciador;
    }

    private void executarCadastrarSala() {

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

    private void executarRemoverSala() {

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

    private void executarListarSalas() {

        if (!gerenciador.nenhumaSala()) {
            System.out.println(gerenciador.listarSalasTotais());

        } else {
            System.out.println("\nNenhuma sala foi cadastrada.");
        }

    }

    private void executarCriarReserva() {

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

                    List<Reserva> conflitos = gerenciador.buscarConflitos(sala, dataHorarioInicio, dataHorarioFim);

                    if (conflitos.isEmpty()) {
                        Reserva reserva = new Reserva(sala, dataHorarioInicio, dataHorarioFim);
                        gerenciador.reservarSala(reserva);
                        System.out.println("\nReserva Efetuada.");
                    } else {
                        System.out.println("\nHorário em conflito com a(s) seguinte(s) reserva(s):");
                        System.out.println(gerenciador.listarConflitos(conflitos));
                    }

                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }

    }

    private void executarCancelarReserva() {

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

    private void executarListarReservas() {

        if (!gerenciador.nenhumaSalaReservada()) {
            System.out.println(gerenciador.listarSalasReservadas());

        } else {
            System.out.println("\nNenhuma sala foi reservada.");
        }

    }

    public static void main(String[] args) throws Exception {
        new App(new GerenciadorDeSalas()).run();
    }

    private void run(){
        executarMainMenu();
    }

    private void executarMainMenu() {

        MainMenu opcaoEscolhida;

        do {

            System.out.println("\n-----Sistema de Reserva de Salas-----");

            for (MainMenu opcao : MainMenu.values()) {
                System.out.println("\n" + opcao.getId() + " - " + opcao.getLabel());
            }

            System.out.println("\n----------------------------------------");

            int userInput = Input.in("\nEscolha (Número da Lista): ");

            opcaoEscolhida = MainMenu.fromNum(userInput);

            if (opcaoEscolhida == null) {
                System.out.println("\nOpção Inválida.");

            } else {

                switch (opcaoEscolhida) {

                    case SALA_MENU:
                        executarCadastrarSala();
                        break;
                    case RESERVA_MENU:
                        executarRemoverSala();
                        break;

                    case SAIR:
                        break;

                    default:

                }
            }

        } while (opcaoEscolhida != MainMenu.SAIR);

    }

}
