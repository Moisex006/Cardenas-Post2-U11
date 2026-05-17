package com.universidad.refactoring_u11.valueobject;


public class LineaPedido {

    private final Double precioUnitario;
    private final Integer cantidad;

    public LineaPedido(Double precioUnitario,
                       Integer cantidad) {

        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}