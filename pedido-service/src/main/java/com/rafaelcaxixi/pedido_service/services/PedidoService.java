package com.rafaelcaxixi.pedido_service.services;

import com.rafaelcaxixi.pedido_service.client.UsuarioClient;
import com.rafaelcaxixi.pedido_service.domain.dto.PedidoRequestDTO;
import com.rafaelcaxixi.pedido_service.domain.dto.PedidoResponseDTO;
import com.rafaelcaxixi.pedido_service.domain.entities.PedidoEntity;
import com.rafaelcaxixi.pedido_service.repositories.PedidoJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoJpaRepository pedidoJpaRepository;
    private final UsuarioClient usuarioClient;

    public PedidoService(PedidoJpaRepository pedidoJpaRepository, UsuarioClient usuarioClient) {
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.usuarioClient = usuarioClient;
    }

    public PedidoResponseDTO cadastrarPedido(PedidoRequestDTO pedidoRequestDTO) {
        if(!usuarioClient.usuarioExiste(pedidoRequestDTO.idCliente())){
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        PedidoEntity pedidoEntity = pedidoJpaRepository.save(new PedidoEntity(pedidoRequestDTO.idCliente(), pedidoRequestDTO.valorTotal()));
        return new PedidoResponseDTO(pedidoEntity.getId(), pedidoEntity.getStatus());
    }


}
