package com.universidad.refactoring_u11.service;
import com.universidad.refactoring_u11.valueobject.DatosCliente;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    public void notificarPedido(
            DatosCliente cliente,
            boolean urgente) {

        System.out.println(
                "Notificando a "
                        + cliente.getEmail());

        System.out.println(
                "Urgente: "
                        + urgente);
    }
}