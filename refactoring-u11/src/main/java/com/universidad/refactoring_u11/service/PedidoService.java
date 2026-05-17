package com.universidad.refactoring_u11.service;

import com.universidad.refactoring_u11.domain.Pedido;
import com.universidad.refactoring_u11.repository.PedidoRepository;
import com.universidad.refactoring_u11.valueobject.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PedidoService {

    private final PedidoRepository repo;
    private final NotificacionService notificacion;

    public PedidoService(
            PedidoRepository repo,
            NotificacionService notificacion) {

        this.repo = repo;
        this.notificacion = notificacion;
    }

    public String procesarPedido(
            DatosCliente cliente,
            LineaPedido[] lineas,
            String metodoPago,
            boolean esUrgente,
            CodigoDescuento descuento) {

        double total = calcularTotal(lineas);

        double totalConDescuento =
                aplicarDescuento(total, descuento);

        notificacion.notificarPedido(
                cliente,
                esUrgente);

        return persistirPedido(
                cliente,
                totalConDescuento);
    }

    private double calcularTotal(
            LineaPedido[] lineas) {

        return Arrays.stream(lineas)
                .mapToDouble(
                        l -> l.getPrecioUnitario()
                                * l.getCantidad())
                .sum();
    }

    private double aplicarDescuento(
            double total,
            CodigoDescuento d) {

        return d != null
                ? total * (1 - d.getPorcentaje())
                : total;
    }

    private String persistirPedido(
            DatosCliente cliente,
            double total) {

        Pedido pedido = new Pedido(
                1L,
                cliente.getNombre(),
                total
        );

        return "OK_" + repo.save(pedido).getId();
    }
}