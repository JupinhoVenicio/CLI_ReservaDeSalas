package Enum;

public enum MenuOpcoes {

    CADASTRAR_SALA("Cadastrar Sala", 1),
    LISTAR_SALA("Listar Sala", 2),
    CRIAR_RESERVA("Criar Reserva", 3),
    CANCELAR_RESERVA("Cancelar Reserva", 4),
    LISTAR_RESERVAS("Listar Reservas", 5),
    SAIR("Sair", 6);

    private final String label;
    private final int num;

    MenuOpcoes(String label, int num) {
        this.label = label;
        this.num = num;

    }

    public String getLabel() {
        return label;

    }

    public int getNum() {
        return num;
    }

    public static MenuOpcoes fromNum(int num) {

        for (MenuOpcoes index : MenuOpcoes.values()) {
            if (num == index.getNum()) {
                return index;
            }

        }
        return null;

    }

}
