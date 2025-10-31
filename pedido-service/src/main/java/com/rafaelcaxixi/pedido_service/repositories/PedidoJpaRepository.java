package com.rafaelcaxixi.pedido_service.repositories;

import com.rafaelcaxixi.pedido_service.domain.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {
}
