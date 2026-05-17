package com.universidad.refactoring_u11.service;

import com.universidad.refactoring_u11.domain.Pedido;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    public double calcularEnvio(
            Pedido pedido,
            String tipoEnvio) {

        switch (tipoEnvio) {

            case "ESTANDAR":
                return pedido.getTotal() > 50 ? 0 : 5.99;

            case "EXPRESS":
                return 12.99;

            case "MISMO_DIA":
                return 24.99;

            case "GRATIS":
                return 0;

            default:
                throw new IllegalArgumentException(
                        "Tipo desconocido");
        }
    }
}