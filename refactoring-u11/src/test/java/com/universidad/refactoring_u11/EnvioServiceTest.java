package com.universidad.refactoring_u11;

import com.universidad.refactoring_u11.domain.Pedido;
import com.universidad.refactoring_u11.service.EnvioService;
import com.universidad.refactoring_u11.strategy.EnvioEstandar;
import com.universidad.refactoring_u11.strategy.EstrategiaEnvio;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvioServiceTest {

    private final EnvioService service =
            new EnvioService(
                    Map.of(
                            "ESTANDAR",
                            new EnvioEstandar()
                    )
            );

    @Test
    void calcularEnvio_estandar_conTotalAlto_debeSerGratis() {

        Pedido p = new Pedido();

        p.setTotal(60.0);

        assertEquals(
                0.0,
                service.calcularEnvio(p, "ESTANDAR"),
                0.001
        );
    }
}
