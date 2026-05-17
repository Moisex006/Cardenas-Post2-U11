package com.universidad.refactoring_u11;

import com.universidad.refactoring_u11.domain.Pedido;
import com.universidad.refactoring_u11.strategy.EnvioEstandar;
import com.universidad.refactoring_u11.strategy.EnvioExpress;
import com.universidad.refactoring_u11.strategy.EnvioMismoDia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstrategiaEnvioTest {

    @Test
    void envioEstandar_conCompraAlta_debeSerGratis() {

        Pedido p = new Pedido();

        p.setTotal(60);

        assertEquals(
                0.0,
                new EnvioEstandar()
                        .calcularCosto(p),
                0.001
        );
    }

    @Test
    void envioExpress_debeCostar1299() {

        Pedido p = new Pedido();

        assertEquals(
                12.99,
                new EnvioExpress()
                        .calcularCosto(p),
                0.001
        );
    }

    @Test
    void envioMismoDia_debeCostar2499() {

        Pedido p = new Pedido();

        assertEquals(
                24.99,
                new EnvioMismoDia()
                        .calcularCosto(p),
                0.001
        );
    }
}