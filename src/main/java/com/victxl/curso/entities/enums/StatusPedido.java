package com.victxl.curso.entities.enums;

public enum StatusPedido {

    ESPERANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int cod;
    private StatusPedido(int cod) {
        this.cod = cod;

    }
    public int getCod() {
        return cod;
    }
    public static StatusPedido valueOf(int cod) {
        for (StatusPedido status : StatusPedido.values()) {
            if (status.getCod() == cod) {
                return status;
            }
        }
      throw new IllegalArgumentException("Codigo Invalido");
    }
}
