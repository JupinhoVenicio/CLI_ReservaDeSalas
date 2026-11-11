package menuopcoes;

public enum SalaMenu {


    CADASTRAR_SALA("Cadastrar Sala"),
    EDITAR_SALA ("Editar Sala"),
    REMOVER_SALA("Remover Sala"),
    LISTAR_SALA("Listar Salas"),
    VOLTAR("Voltar");

    private final String label;
    private final int id;

    SalaMenu(String label) {
        this.label = label;
        this.id = idCounter.nextId();

    }

    public String getLabel() {
        return label;

    }

    public int getId() {
        return id;
    }

    public static SalaMenu fromNum(int num) {

        for (SalaMenu index : SalaMenu.values()) {
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

