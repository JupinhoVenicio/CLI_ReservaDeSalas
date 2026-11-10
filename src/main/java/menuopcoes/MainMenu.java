package menuopcoes;

public enum MainMenu {

    CADASTRAR_SALA("Cadastrar Sala"),
    REMOVER_SALA("Remover Sala"),
    LISTAR_SALA("Listar Sala"),
    CRIAR_RESERVA("Criar Reserva"),
    CANCELAR_RESERVA("Cancelar Reserva"),
    LISTAR_RESERVAS("Listar Reservas"),
    SAIR("Sair");

    private final String label;
    private final int id;

    MainMenu(String label) {
        this.label = label;
        this.id = idCounter.nextId();

    }

    public String getLabel() {
        return label;

    }

    public int getId() {
        return id;
    }

    public static MainMenu fromNum(int num) {

        for (MainMenu index : MainMenu.values()) {
            if (num == index.getId()) {
                return index;
            }

        }
        return null;

    }

    private static class idCounter {
        private static int count = 1;

        public static int nextId() {
            return count++;
        }
    }

}
