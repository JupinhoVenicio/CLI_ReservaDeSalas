package menuopcoes;

public enum MenuOpcoes {

    CADASTRAR_SALA("Cadastrar Sala"),
    REMOVER_SALA("Remover Sala"),
    LISTAR_SALA("Listar Sala"),
    CRIAR_RESERVA("Criar Reserva"),
    CANCELAR_RESERVA("Cancelar Reserva"),
    LISTAR_RESERVAS("Listar Reservas"),
    SAIR("Sair");

    private final String label;
    private final int id;

    MenuOpcoes(String label) {
        this.label = label;
        this.id = idCounter.nextId();

    }

    public String getLabel() {
        return label;

    }

    public int getId() {
        return id;
    }

    public static MenuOpcoes fromNum(int num) {

        for (MenuOpcoes index : MenuOpcoes.values()) {
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
