package com.rafaelcaxixi.usuario_service.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(
        @NotBlank
        String login,
        @NotBlank
        String cpf) {
}
