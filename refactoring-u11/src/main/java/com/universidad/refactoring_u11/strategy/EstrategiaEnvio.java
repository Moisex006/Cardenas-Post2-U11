package com.universidad.refactoring_u11.strategy;

import com.universidad.refactoring_u11.domain.Pedido;

public interface EstrategiaEnvio {

    double calcularCosto(Pedido pedido);
}