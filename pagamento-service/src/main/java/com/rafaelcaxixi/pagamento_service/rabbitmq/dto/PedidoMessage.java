package com.rafaelcaxixi.pagamento_service.rabbitmq.dto;

public record PedidoMessage(Long idPedido, Long idCliente, Double valorTotal) {
}
