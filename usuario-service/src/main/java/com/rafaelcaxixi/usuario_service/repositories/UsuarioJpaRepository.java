package com.rafaelcaxixi.usuario_service.repositories;

import com.rafaelcaxixi.usuario_service.domain.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
}
