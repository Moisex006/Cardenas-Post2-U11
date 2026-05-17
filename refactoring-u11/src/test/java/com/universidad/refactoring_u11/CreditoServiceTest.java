package com.universidad.refactoring_u11;

import com.universidad.refactoring_u11.domain.Cliente;
import com.universidad.refactoring_u11.service.CreditoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditoServiceTest {

    private final CreditoService service =
            new CreditoService();

    @Test
    void aprobarCredito_clienteNulo_debeRechazar() {

        assertEquals(
                "RECHAZADO",
                service.aprobarCredito(null, 1000)
        );
    }

    @Test
    void aprobarCredito_clienteInactivo_debeRechazar() {

        Cliente c =
                new Cliente(false, 700, 5000);

        assertEquals(
                "RECHAZADO",
                service.aprobarCredito(c, 1000)
        );
    }

    @Test
    void aprobarCredito_scoreBajo_debeRechazar() {

        Cliente c =
                new Cliente(true, 500, 5000);

        assertEquals(
                "RECHAZADO",
                service.aprobarCredito(c, 1000)
        );
    }

    @Test
    void aprobarCredito_montoMayorAlLimite_debeRechazar() {

        Cliente c =
                new Cliente(true, 700, 1000);

        assertEquals(
                "RECHAZADO",
                service.aprobarCredito(c, 5000)
        );
    }

    @Test
    void aprobarCredito_clienteValido_debeAprobar() {

        Cliente c =
                new Cliente(true, 700, 10000);

        assertEquals(
                "APROBADO",
                service.aprobarCredito(c, 2000)
        );
    }
}