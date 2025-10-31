package com.rafaelcaxixi.usuario_service.services;

import com.rafaelcaxixi.usuario_service.domain.dto.UsuarioRequestDto;
import com.rafaelcaxixi.usuario_service.domain.dto.UsuarioResponseDto;
import com.rafaelcaxixi.usuario_service.domain.entities.UsuarioEntity;
import com.rafaelcaxixi.usuario_service.repositories.UsuarioJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioService(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    public UsuarioResponseDto cadastrarUsuario(UsuarioRequestDto usuarioRequestDto) {
        UsuarioEntity usuarioEntity = usuarioJpaRepository.save(new UsuarioEntity(usuarioRequestDto.login(), usuarioRequestDto.cpf()));
        return new UsuarioResponseDto(usuarioEntity.getId(), usuarioEntity.getLogin(), usuarioEntity.getCpf());
    }

    public UsuarioResponseDto buscarPorId(Long id){
        UsuarioEntity usuarioEntity = usuarioJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return new UsuarioResponseDto(usuarioEntity.getId(), usuarioEntity.getLogin(), usuarioEntity.getCpf());
    }

    public boolean usuarioExiste(Long id){
        return usuarioJpaRepository.existsById(id);
    }
}
