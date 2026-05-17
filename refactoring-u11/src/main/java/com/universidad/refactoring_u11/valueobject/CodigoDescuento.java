package com.universidad.refactoring_u11.valueobject;

public class CodigoDescuento {

    private final Double porcentaje;

    public CodigoDescuento(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }
}