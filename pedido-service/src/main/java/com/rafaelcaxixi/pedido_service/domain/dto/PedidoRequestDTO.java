package com.rafaelcaxixi.pedido_service.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequestDTO(
        @NotNull
        Long idCliente,
        @NotNull
        Double valorTotal) {
}
