package com.rafaelcaxixi.pagamento_service.repositories;

import com.rafaelcaxixi.pagamento_service.domain.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {

}
