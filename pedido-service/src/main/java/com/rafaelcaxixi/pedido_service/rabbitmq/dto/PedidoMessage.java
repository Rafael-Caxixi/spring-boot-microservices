package com.rafaelcaxixi.pedido_service.rabbitmq.dto;

public record PedidoMessage(Long idPedido, Long idCliente, Double valorTotal) {
}
