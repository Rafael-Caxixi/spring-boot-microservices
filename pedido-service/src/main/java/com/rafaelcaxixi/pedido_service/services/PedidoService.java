package com.rafaelcaxixi.pedido_service.services;

import com.rafaelcaxixi.pedido_service.client.UsuarioClient;
import com.rafaelcaxixi.pedido_service.domain.dto.PedidoRequestDTO;
import com.rafaelcaxixi.pedido_service.domain.dto.PedidoResponseDTO;
import com.rafaelcaxixi.pedido_service.domain.entities.PedidoEntity;
import com.rafaelcaxixi.pedido_service.rabbitmq.RabbitConfig;
import com.rafaelcaxixi.pedido_service.rabbitmq.dto.PedidoMessage;
import com.rafaelcaxixi.pedido_service.repositories.PedidoJpaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoJpaRepository pedidoJpaRepository;
    private final UsuarioClient usuarioClient;
    private final RabbitTemplate rabbitTemplate;

    public PedidoService(PedidoJpaRepository pedidoJpaRepository, UsuarioClient usuarioClient, RabbitTemplate rabbitTemplate) {
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.usuarioClient = usuarioClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    public PedidoResponseDTO cadastrarPedido(PedidoRequestDTO pedidoRequestDTO) {
        if(!usuarioClient.usuarioExiste(pedidoRequestDTO.idCliente())){
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        PedidoEntity pedidoEntity = pedidoJpaRepository.save(new PedidoEntity(pedidoRequestDTO.idCliente(), pedidoRequestDTO.valorTotal()));

        //enviando mensagem na fila
        PedidoMessage pedidoMessage = new PedidoMessage(pedidoEntity.getId(), pedidoRequestDTO.idCliente(), pedidoRequestDTO.valorTotal());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, pedidoMessage);

        return new PedidoResponseDTO(pedidoEntity.getId(), pedidoEntity.getStatus());
    }


}
