package menuopcoes;

public enum ReservaMenu {

    CRIAR_RESERVA("Criar Reserva"),
    EDITAR_RESERVA("Editar Reserva"),
    CANCELAR_RESERVA("Cancelar Reserva"),
    LISTAR_RESERVAS("Listar Reservas"),
    VOLTAR("Voltar");

    private final String label;
    private final int id;

    ReservaMenu(String label) {
        this.label = label;
        this.id = idCounter.nextId();

    }

    public String getLabel() {
        return label;

    }

    public int getId() {
        return id;
    }

    public static ReservaMenu fromNum(int num) {

        for (ReservaMenu index : ReservaMenu.values()) {
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
