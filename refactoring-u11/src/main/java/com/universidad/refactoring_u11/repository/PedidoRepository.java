package com.universidad.refactoring_u11.repository;

import com.universidad.refactoring_u11.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    com.universidad.refactoring_u11.domain.Producto findProductoById(Long id);
}